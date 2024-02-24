package com.dc.data.structures;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class WorkingWithQueues {

    public static void main(String[] args) {
        linkedList();
    }

    private static void linkedList(){
        LinkedList<Person> linkedList = new LinkedList<>();
        linkedList.add(new Person("David", 31));
        linkedList.add(new Person("Daniel", 29));
        linkedList.add(new Person("Santi", 21));

        ListIterator<Person> personListIterator = linkedList.listIterator();

        while (personListIterator.hasNext()){
            System.out.println(personListIterator.next());
            System.out.println(personListIterator.nextIndex());
        }

        while (personListIterator.hasPrevious()){
            System.out.println(personListIterator.previous());
            System.out.println(personListIterator.nextIndex());
            System.out.println(personListIterator.previousIndex());
        }


    }

    private static void queues(){
        Queue<Person> superMarket = new LinkedList<>();
        superMarket.add(new Person("David", 31));
        superMarket.add(new Person("Daniel", 29));
        superMarket.add(new Person("Santi", 21));

        System.out.println(superMarket.size());
        System.out.println(superMarket.peek());
        System.out.println(superMarket.size());
        System.out.println(superMarket.poll());
        System.out.println(superMarket.size());
        System.out.println(superMarket.remove());
        System.out.println(superMarket.size());
    }

    static record Person(String name, int age){}
}
