package com.ajay.app.service;

import com.ajay.app.module.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ParkingService {

    public static final Logger logger = LoggerFactory.getLogger(ParkingService.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;
    @Value("${rabbitmq.start.request.routingkey.name}")
    private String startRequestRoutingKeyName;
    @Value("${rabbitmq.end.request.routingkey.name}")
    private String endRequestRoutingKeyName;

    private final AmqpTemplate producerAmqpTemplate;
    public ParkingService( AmqpTemplate producerAmqpTemplate) {
        this.producerAmqpTemplate = producerAmqpTemplate;

    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    public String parkingStartService(Car car, String parkingNumber) {
        logger.info("Acquiring parking number " + parkingNumber);
        Map<String, Object> message = new HashMap<>();
        message.put("car", car);
        message.put("parkingNumber", parkingNumber);
        producerAmqpTemplate.convertAndSend(exchangeName, startRequestRoutingKeyName, message);
        return "Parking is starting";
    }

    public String parkingEndService( String parkingNumber){
        logger.info("releasing parking number " + parkingNumber);
        producerAmqpTemplate.convertAndSend(exchangeName, endRequestRoutingKeyName, parkingNumber);
        return "Parking is ending";
    }
    @RabbitListener(queues = "${rabbitmq.start.response.queue.name}")
    public void receiveStartResponse(String message) {
        logger.info("Received start response: " + message);
    }

    @RabbitListener(queues = "${rabbitmq.end.response.queue.name}")
    public void receiveEndResponse(String message) {
        logger.info("Received end response: " + message);
    }

}
