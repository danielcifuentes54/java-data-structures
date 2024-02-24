package com.dc.data.structures;

import java.util.ArrayList;

// Adjacency Matrix: A 2D array to store 1's/0's to represent edges
// runtime complexity to check and edge: O(1)
// space complexity: O(V^2)
public class WorkingWithGraphsMatrix {

    public static void main(String[] args) {
        Graph graph = new Graph(5);

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

        System.out.println(graph.checkEdge(0,1));
        System.out.println(graph.checkEdge(3,2));
    }


    static class Node {

        char data;

        Node(char data){
            this.data = data;
        }
    }

    static class Graph{

        ArrayList<Node> nodes;
        int[][] matrix;

        Graph(int size){
            this.nodes = new ArrayList<>();
            this.matrix = new int[size][size];
        }

        public void addNode(Node node){
            this.nodes.add(node);
        }

        public void addEdge(int src, int dst){
            this.matrix[src][dst] = 1;
        }

        public boolean checkEdge(int src, int dst){
            return this.matrix[src][dst] == 1;
        }

        public void print(){
            System.out.print("  ");
            for (Node node : this.nodes){
                System.out.print(node.data + " ");
            }
            System.out.println();
            for (int i = 0; i < this.matrix.length; i++) {
                System.out.print(this.nodes.get(i).data + " ");
                for (int j = 0; j < this.matrix.length; j++) {
                    System.out.print(this.matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
