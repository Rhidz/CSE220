public class Node {
        Object element; // to store the elements be it numbers or strings or etc.
        Node next; // a pointer that stores addresses of other nodes in the linkedlist
        
        public Node(Object e, Node n) {// constructor that constructs a node ojbect 
        	this.element = e;
        	this.next = n;
        }
}
