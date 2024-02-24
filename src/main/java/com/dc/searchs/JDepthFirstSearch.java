package com.dc.searchs;

import java.util.ArrayList;

// DFS = A search algorithm for traversing a tree or graph data structure
// 1 pick a route
// 2 keep going until you reach a dead end, or a previously visited node
// 3 backtrack to last node that has unvisited adjacent neighbors
// you can use Stacks for the solutions

public class JDepthFirstSearch {

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
        graph.depthFirstSearch(0);


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

        public void depthFirstSearch(int src){
            boolean[] visited = new boolean[matrix.length];
            dFSHelper(src, visited);
        }

        private void dFSHelper(int src, boolean[] visited) {
            if(!visited[src]){
                visited[src] = true;
                System.out.println(nodes.get(src).data + " Visited");

                for(int i=0; i < matrix[src].length; i++) {
                    if (matrix[src][i] == 1) {
                        dFSHelper(i, visited);
                    }
                }
            }
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
