package com.dc.data.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkingWithList {

    public static void main(String[] args) {

        try{
            List<String> colorsImmutable = List.of("blue", "green");

            // This does not work
            //colorsImmutable.add("red");

            List<String> colorsMutable = new ArrayList<>(List.of("blue", "green"));

            // This works
            //colorsMutable.add("red");

            List<String> colors = new ArrayList<>();

            colors.add("yellow");
            colors.add("blue");
            colors.add("red");

            System.out.println(colors);

            colors.forEach(System.out::println);

            for (String color: colors) {
                System.out.println(color);
            }

            for (int i = 0; i < colors.size(); i++) {
                System.out.println(colors.get(i));
            }
        }catch (Exception e){
            System.err.println(e);
        }


    }
}
