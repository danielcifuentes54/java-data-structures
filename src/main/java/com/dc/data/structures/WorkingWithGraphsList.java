package com.dc.data.structures;

import java.util.ArrayList;
import java.util.LinkedList;

// Adjacency List: An array/arraylist of linkedlist, each linkedlist has a unique node at the head
//                 All Adjacent neighbors to that node are added to that node's Linkedlist
// runtime complexity to check and edge: O(V)
// space complexity: O(V+e)
public class WorkingWithGraphsList {

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(4,0);
        graph.addEdge(4,2);

        graph.print();
    }


    static class Node {

        char data;
        Node(char data){
            this.data = data;
        }
    }

    static class Graph{

        ArrayList<LinkedList<Node>> alist;

        Graph(){
            alist = new ArrayList<>();
        }

        public void addNode(Node node){
            LinkedList<Node> currentList = new LinkedList<>();
            currentList.add(node);
            alist.add(currentList);
        }

        public void addEdge(int src, int dst){
            LinkedList<Node> currentList = alist.get(src);
            Node destinationNode = alist.get(dst).get(0);
            currentList.add(destinationNode);
        }

        public boolean checkEdge(int src, int dst){
            LinkedList<Node> currentList = alist.get(src);
            Node destinationNode = alist.get(dst).get(0);
            for (Node node : currentList){
                if (node == destinationNode){
                    return true;
                }
            }
            return false;
        }

        public void print(){
            for (LinkedList<Node> currentList : alist){
                for (Node node : currentList){
                    System.out.print(node.data + " -> ");
                }
                System.out.println();
            }
        }
    }
}
