package com.dc.data.structures;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class WorkingWithSets {

    public static void main(String[] args) {

        //No order - No duplicates
        Set<Ball> balls = new HashSet<>();

        balls.add(new Ball("yellow"));
        balls.add(new Ball("blue"));
        balls.add(new Ball("red"));
        balls.add(new Ball("red"));

        balls.forEach(System.out::println);

        // No duplicates
        Set<Ball2> balls2 = new TreeSet<>();

        balls2.add(new Ball2("yellow",1));
        balls2.add(new Ball2("blue",2));
        balls2.add(new Ball2("red",3));

        balls2.forEach(System.out::println);

    }

    static class Ball2 implements Comparable<Ball2> {
        String color;
        Integer position;

        public Ball2(String color, Integer position){
            this.color = color;
            this.position = position;
        }

        @Override
        public int compareTo(Ball2 other) {
            return this.position.compareTo(other.position);
        }

        @Override
        public String toString() {
            return "Ball2{" +
                    "color='" + color + '\'' +
                    '}';
        }
    }

    record  Ball(String color){}
}
