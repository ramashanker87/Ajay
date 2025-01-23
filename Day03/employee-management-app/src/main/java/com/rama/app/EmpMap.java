package com.rama.app;
import com.rama.app.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;
public class EmpMap {
    public static void main(String[] args) {
        List<Employee> EList = new ArrayList<>();
        Employee e1 = new Employee("Ajay", 21, "Tcs", 1, 50000);
        Employee e2 = new Employee("B", 32, "Tcs", 2, 26000);
        Employee e3 = new Employee("C", 23, "Tcs", 3, 10000);
        Employee e4 = new Employee("D", 54, "Tcs", 4, 80000);
        Employee e5 = new Employee("E", 45, "Tcs", 5, 24000);
        Employee e6 = new Employee("F", 26, "Tcs", 6, 70000);
        EList.add(e1);
        EList.add(e2);
        EList.add(e3);
        EList.add(e4);
        EList.add(e5);
        EList.add(e6);
        System.out.println("Employees with Salary<40000");
        Map<String, Employee> salfilt = EList.stream().
                filter(emp -> emp.Salary < 40000)
                .collect(Collectors.toMap(emp -> emp.name, emp -> emp));
        System.out.println(salfilt);
        System.out.println("Employees with age>25");
        Map<String, Employee> agefilt = EList.stream().
                filter(emp -> emp.age > 25)
                .collect(Collectors.toMap(emp -> emp.name, emp -> emp));
        System.out.println(agefilt);


        //to print Map
        salfilt.forEach((name,emp)->System.out.println(name+"->"+emp));

        agefilt.forEach((name,emp)->System.out.println(name+"->"+emp));
    }
}

//import com.rama.app.Employee;

