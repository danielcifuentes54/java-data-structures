package com.dc.exercises;

import java.util.*;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 *
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 */
public class LRUCache {

    private int capacity;
    private List lruList;
    private Map<Integer, Integer> data;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.lruList = new ArrayList<Integer>();
        this.data = new HashMap<>();
    }

    public int get(Integer key) {

        Integer value = this.data.getOrDefault(key, -1);
        if(value != -1){
            lruList.remove(key);
            lruList.add(key);
            return value;
        }
        return -1;
    }

    public void put(Integer key, Integer value) {
        Integer valueFromData = this.data.getOrDefault(key, -1);

        if(valueFromData == -1){
            if (this.lruList.size() >= this.capacity){
                this.data.remove(lruList.get(0));
                this.lruList.remove(0);
            }
            this.data.put(key, value);
            this.lruList.add(key);
        }else {
            lruList.remove(key);
            lruList.add(key);
            this.data.put(key, value);
        }
    }

    /*
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);
        lruCache.put(10,1);
        lruCache.put(10,2);
        lruCache.put(10,3);
        lruCache.put(10,4);
    }*/

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);
        lruCache.put(10,13);
        lruCache.put(3,17);
        lruCache.put(6,11);
        lruCache.put(10,5);
        lruCache.put(9,10);
        System.out.println(lruCache.get(13));
        lruCache.put(2,19);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        lruCache.put(5,25);
        System.out.println(lruCache.get(8));
        lruCache.put(9,22);
        lruCache.put(5,5);
        lruCache.put(1,30);
        System.out.println(lruCache.get(11));
        lruCache.put(9,12);
        System.out.println(lruCache.get(7));
        System.out.println(lruCache.get(5));
        System.out.println(lruCache.get(8));
        System.out.println(lruCache.get(9));
        lruCache.put(4,30);
        lruCache.put(9,3);
        System.out.println(lruCache.get(9));
        System.out.println(lruCache.get(10));
        System.out.println(lruCache.get(10));
    }


    public static void main2(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        System.out.println(lruCache.get(2));
        lruCache.put(2,6);
        System.out.println(lruCache.get(1));
        lruCache.put(1,5);
        lruCache.put(1,2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        //result should be -1,-1,2,6


    }


    public static void main3(String[] args) {
        LRUCache lruCache = new LRUCache(2);
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


    /*
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
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

    }*/
}
