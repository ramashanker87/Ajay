package com.ajay.app;
import com.ajay.app.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;
public class Emplist {
    public static void main(String[] args) {
        List<Employee> EList=new ArrayList<>();
        Employee e1=new Employee("Ajay",21,"Tcs",1,50000);
        Employee e2=new Employee("B",32,"Tcs",2,26000);
        Employee e3=new Employee("C",23,"Tcs",3,10000);
        Employee e4=new Employee("D",54,"Tcs",4,80000);
        Employee e5=new Employee("E",45,"Tcs",5,24000);
        Employee e6=new Employee("F",26,"Tcs",6,70000);
        EList.add(e1);
        EList.add(e2);
        EList.add(e3);
        EList.add(e4);
        EList.add(e5);
        EList.add(e6);

        for (Employee emp : EList) {
            emp.print();
        }
        System.out.println("Employee Salary Greater than 50000");
        List<Employee> filtsal=EList.stream()
                .filter(emp -> emp.Salary>50000)
                .collect(Collectors.toList());
        for (Employee emp : filtsal) {
            emp.print();
        }
        System.out.println("Employee Age Less than 30");
        List<Employee> filtage=EList.stream()
                .filter(emp -> emp.age<30)
                .collect(Collectors.toList());
        for (Employee emp : filtage) {
            emp.print();
        }
    }

}

//import com.rama.app.Employee;

