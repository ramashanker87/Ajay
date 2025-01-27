package com.ajay.app;

import org.junit.Test;
public class CalTest {
    @Test
    public void testAdd() {
        Cal calculator = new Cal();
        double result=calculator.add(11,42);
        assert result==53;
    }
    @Test
    public void testSubtract() {
        Cal calculator = new Cal();
        double result = calculator.subtract(65,15);
        assert result==50;
    }
    @Test
    public void testMultiply() {
        Cal calculator = new Cal();
        double result= calculator.multiply(5,10);
        assert result==50;
    }
    @Test
    public void testDivide() {
        Cal calculator = new Cal();
        double result= calculator.divide(50,10);
        assert result==5;
    }
}
