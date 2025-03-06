package com.ajay.app;
class Shape {
    double area(){return 0.0;};
}
class Circle extends Shape{
    private double radius;
        Circle(double radius){
            this.radius = radius;
        }

    @java.lang.Override
    double area() {
        return Math.PI*radius*radius;
    }
}
class Rectangle extends Shape{
    private double length, width;
    Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    @java.lang.Override
    double area() {
        return length*width;
    }
}
class Triangle extends Shape{
    private double length, height;
    Triangle(double length, double height){
        this.length = length;
        this.height = height;
    }
    @java.lang.Override
    double area() {
        return 0.5*length*height;
    }
}
public class Main{
    public static void main(String[] args){
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(10,20);
        Shape triangle = new Triangle(10,20);
        System.out.println("Area Of Circle "+circle.area());
        System.out.println("Area of Rectangle "+rectangle.area());
        System.out.println("Area of Triangle "+triangle.area());
    }
}
