package com.dc.data.structures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WorkingWithMaps {

    public static void main(String[] args) {
        Map<Integer, Person> map = new HashMap<>();

        map.put(1, new Person("Oscar"));
        map.put(2, new Person("Maryori"));
        map.put(5, new Person("Emi"));

        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.get(1));
        System.out.println(map.containsKey(4));
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.entrySet());
        map.entrySet().forEach(x -> System.out.println(x.getValue()));
        map.forEach((k,v) -> {
            System.out.println(k + " - " + v);
        });

        System.out.println(map.getOrDefault(10, new Person("Alba")));

        Map<Integer, Integer> numbers = new HashMap<>();


        sumNumber(numbers, 3);
        System.out.println(numbers);

    }

    record Person(String name){}

    private static Map<Integer, Integer> sumNumber(Map<Integer, Integer> numbers, int newNumber){

        numbers.put(newNumber, numbers.getOrDefault(newNumber, 0) + 1);
        return  numbers;

    }
}
