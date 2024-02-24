package com.dc.exercises;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheBetterPerformance {


    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LRUCacheBetterPerformance(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    public void put(int key, int value) {
        map.put(key, value);
    }


    public static void main(String[] args) {
        LRUCacheBetterPerformance lruCache = new LRUCacheBetterPerformance(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);
        lruCache.get(3);
        lruCache.get(4);
        lruCache.get(3);
        lruCache.put(5,5);
    }
    public static void main0(String[] args) {
        LRUCacheBetterPerformance lruCache = new LRUCacheBetterPerformance(2);
        System.out.println(lruCache.get(2));
        lruCache.put(2,6);
        System.out.println(lruCache.get(1));
        lruCache.put(1,5);
        lruCache.put(1,2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        //result should be -1,-1,2,6


    }


    public static void main2(String[] args) {
        LRUCacheBetterPerformance lruCache = new LRUCacheBetterPerformance(2);
        lruCache.put(1,0);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        //result should be 0,-1,-1,3,4


    }



    public static void main3(String[] args) {
        LRUCacheBetterPerformance lruCache = new LRUCacheBetterPerformance(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        //result should be 1,-1,-1,3,4

    }
}
