### run the docker compose to start rabbitMQ and mysql
docker-compose up

### Rabbit MQ link - http://localhost:15672/#/queues

### now run the registration application- mvn spring-boot:run
 POST http://localhost:8082/parking/start

#### IN POSTMAN param - parkingNumber 1-A
#### Body 
{
"ownerName": "c1",
"registrationNumber":"p1",
"modelNumber":"start",
"fuelType":"petrol"
}

### now start the process application 

DELETE  http://localhost:8082/parking/end
param - parkingNumber : 1-A

### To check data in mysql
docker exec -it mysql mysql -u user -p
password
use parking;

select * from car;
select * from parking_start;
select * from parking_end;


