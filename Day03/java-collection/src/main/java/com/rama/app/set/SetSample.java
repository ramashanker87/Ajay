package com.rama.app.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetSample {
    public static void main(String[] args) {
        Set<String> setString = new HashSet();
        setString.add("Test8");
        setString.add("Test6");
        setString.add("c");
        setString.add("d");

        for(String data:setString){
            System.out.println(data);
        }
        Set<Integer> setInteger = new HashSet();
        setInteger.add(10);
        setInteger.add(2);
        setInteger.add(50);
        for(Integer data:setInteger){
            System.out.println(data);
        }
        Set<Integer> setData = new LinkedHashSet<>();
        setData.add(10);
        setData.add(2);
        setData.add(50);
        for(Integer data:setData){
            System.out.println(data);
        }
    }
}
