package com.dc.searchs;

//Binary Search Tree = A tree data structure, where each node is greater than it's left child, but less than it's right.
//					   benefit: easy to locate a node when they are in this order
//					   time complexity: best case  O(log n)
//									    worst case O(n)
//					   space complexity: O(n)
public class LBinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new Node(5));
        tree.insert(new Node(1));
        tree.insert(new Node(9));
        tree.insert(new Node(2));
        tree.insert(new Node(7));
        tree.insert(new Node(3));
        tree.insert(new Node(6));
        tree.insert(new Node(4));
        tree.insert(new Node(8));

        System.out.println(tree.search(0));
        System.out.println(tree.search(3 ));
        tree.display();
        tree.remove(3);
        System.out.println(tree.search(3 ));
        tree.display();
    }

    static class BinarySearchTree {

        Node root;

        public void insert(Node node){
            root = insertHelper(root, node);
        }

        private Node insertHelper(Node root, Node node) {

            int data = node.data;

            if(root == null){
                root = node;
                return root;
            }else if(data < root.data){
                root.left = insertHelper(root.left, node);
            }else{
                root.right = insertHelper(root.right, node);
            }

            return root;
        }

        private void display(){
            System.out.println("Printing in order");
            displayHelperInOrder(root);
            System.out.println("Printing in post order");
            displayHelperPostOrder(root);
            System.out.println("Printing in pre order");
            displayHelperPreOrder(root);
        }

        //in order: left -> root -> right
        private void displayHelperInOrder(Node root) {
            if(root != null){
                displayHelperInOrder(root.left);
                System.out.println(root.data);
                displayHelperInOrder(root.right);
            }
        }

        //post order: left -> right > root
        private void displayHelperPostOrder(Node root) {
            if(root != null){
                displayHelperPostOrder(root.left);
                displayHelperPostOrder(root.right);
                System.out.println(root.data);
            }
        }

        //pre order: root -> left > right
        private void displayHelperPreOrder(Node root) {
            if(root != null){
                System.out.println(root.data);
                displayHelperPreOrder(root.left);
                displayHelperPreOrder(root.right);
            }
        }

        private boolean search(int data){
            return searchHelper(root, data);
        }

        private boolean searchHelper(Node root, int data) {

            if(root == null) {
                return false;
            } else if(root.data == data){
                return true;
            } else if (data < root.data) {
                return searchHelper(root.left, data);
            }else{
                return searchHelper(root.right, data);
            }
        }

        private void remove(int data){
            if(search(data)){
                removeHelper(root, data);
            }
            else{
                System.out.println(data + " could not be found");
            }
        }

        private Node removeHelper(Node root, int data) {

            if(root == null){
                return root;
            } else if (data < root.data) {
                root.left = removeHelper(root.left, data);
            } else if (data > root.data) {
                root.right = removeHelper(root.right, data);
            }else{//node found
                if(root.left == null && root.right == null){
                    //leaf
                    root = null;
                }else if(root.right != null){ //find a successor to replace this node
                    root.data = successor(root);
                    root.right = removeHelper(root.right, root.data);
                }else { //find a predecessor to replace this node
                    root.data = predecessor(root);
                    root.left = removeHelper(root.left, root.data);
                }
            }
            return root;
        }

        private int predecessor(Node root) {
            root = root.left;
            while(root.right != null){
                root = root.right;
            }
            return root.data;
        }

        private int successor(Node root) {//find the least value below the right child of this root node
            root = root.right;
            while (root.left != null){
                root = root.left;
            }
            return root.data;
        }

    }

    static class Node {
        int data;
        Node left;

        Node right;

        public Node(int data){
            this.data = data;
        }
    }
}
