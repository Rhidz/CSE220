public class LinkedList {
    public Node head;
    public int size; // to determine the size of the linkedlist


public LinkedList(int s) {
	this.size =s;
		
		
	
}
public void makeList(int [] a ) {
	    Node temp = null;
	    Node n = new Node(a[0],null);
		head = n;
		temp = head;
		for(int i=1; i<size; i++) {
			 n = new Node(a[i],null);
			 temp.next = n;
			 temp = temp.next;
		}
		
		
	
}


public void printList() {
	Node temp = head; // temp variable required for traversing
	for(int i=0; i<size; i++) {
		if(i==size-1) {
			System.out.print(temp.element);
			temp = temp.next;
		}
		else {
		System.out.print(temp.element + " ");
		temp = temp.next;
	}
	}
	System.out.println();
}

public int countNode(){
	
	Node temp = head;
	int count = 1;// as head is the first element in the link list hence count is initialized to 1
	while(temp.next!=null) {
		 count++;
		 temp = temp.next;
}
	return count;
}
// returns the reference of the Node at the given index. For invalid index return null.

public Node nodeAt(int idx){
	Node temp = head;
	Node n = null;
	if(idx==-1 || idx >size) {
		System.out.println("Invalid Index");
		return n;
	}
	else {
		for(int i =0; i<countNode(); i++) {
			if(i==idx) {
				n=temp;
			}
			else {
				temp = temp.next;
			}
		}
	}
	return n;
}

public Object get(int idx) {
	Node temp = head;
	Node n = null;
	if(idx==-1 || idx >size) {
		System.out.println("Not a valid index");
		return n;
	}
	else {
		for(int i =0; i<countNode(); i++) {
			if(i==idx) {
				n=temp;
			}
			else {
				temp = temp.next;
			}
		}
	}
	return n.element;

	
}
/* updates the element of the Node at the given index. 
 * Returns the old element that was replaced. For invalid index return null.
 * parameter: index, new element
 */
public Object set(int idx, Object elem){
	Node temp = head;
	Node n = null;
	Object var = null;
	if(idx== -1 || idx>size) {
		System.out.println("Invalid Index ");
		return null;
	}
	else {
		for(int i=0; i<countNode(); i++) {
			if(i==idx) {
				var = temp.element;
				temp.element = elem;
				
			}
			else {
				temp = temp.next;
			}
			
		}
	}
	return var;




}
/* returns the index of the Node containing the given element.
if the element does not exist in the List, return -1.
*/
public int indexOf(Object elem){
	Node temp = head;
	int index = -1;
	for(int i=0; i<countNode(); i++) {
		if(temp.element == elem) {
			index= i;
			break;
		}
		else {
			temp = temp.next;
		}
	}
	return index;
}

//returns true if the element exists in the List, return false otherwise.
public boolean contains(Object elem){
	Node temp = head;
	boolean var = false;
	for(int i=0; i<countNode(); i++) {
		if(temp.element == elem) {
			var = true;
			break;
		}
		else {
			temp =temp.next;
		}
	}
	return var;
}
// Makes a duplicate copy of the given List. Returns the reference of the duplicate list.

public Node copyList(){
	Node temp = head;
	Node n = null;
	Node duphead = null;
	for(int i =0; i<countNode(); i++) {
		if(i==0) {
		   n = new Node(temp.element,null);
		   n.next = temp.next;
		   duphead =n;
		   //System.out.println(temp.element);
			temp = temp.next;
		}
		else {
			n = new Node(temp.element,null);
			n.next = temp.next;
			//System.out.println(temp.element);
			temp = temp.next;
		}
	}

	// if you want to print the duplicated list use the code provided below
	/*temp = duphead;
	 while(temp.next!=null) {
		 System.out.print(temp.element+" ");
		 temp= temp.next;
		 
	 }
	 System.out.print(temp.element);
	 */
	 return duphead;
}
public Node reverseList() {
	Node reverseHead = new Node(head.element,null);/* this will the last element in the reversed linked
	list */
	for(Node n = head.next; n!=null ; n=n.next) {
		Node j = new Node(n.element,null);
		j.next = reverseHead;
		reverseHead = j;
	}
	return reverseHead;
}
public void insert(Object elem, int idx) {
	
	if(idx ==-1 || idx > size) {
		System.out.println("Invalid Index :(");
	}
	else {
		Node n = new Node(elem,null);
		if(idx ==0) {
			n.next = head;
			head = n;
		}
		else {
			Node previousNode = nodeAt(idx-1); /* Get the previous node to break 
			the link and insert a new one */
			n.next =previousNode.next;
			previousNode.next = n;
		}
		
	}
}
/* removes Node at the given index. returns element of the removed node.
 * Check validity of index. return null if index is invalid.
 */
public Object removeNode(int idx) {
	Object remelem = null;
	if(idx==-1 || idx>size) {
		System.out.println("Invalid Index");
	}
	else if(idx==0){
		Node rm = head;
		remelem = head.element;
		head = head.next;
		rm.next = null;
		rm.element=null;
		
	}
	else {
		Node previous = nodeAt(idx-1);
		previous.next= previous.next.next;
		Node rm = previous.next;
		remelem = previous.next.element;
		rm.element = null;
		rm.next = null;
		
	}
	return remelem;
}

public void rotateLeft() {
	Node temp = head;
	/* need to the find the last node */
	Node n = nodeAt(size-1);
	n.next = head;
	head = temp.next;
	n.next.next = null;
	
	
	for(Node t = head;t!=null;t=t.next) {
		System.out.print(t.element+" ");
	}
	System.out.println();
	
}

public void rotateRight() {
	
	Node n = nodeAt(size-1);
	Node f = nodeAt(size-2);
	
	n.next = head;
	head = n;
	f.next=null;
	

	for(Node t = head;t!=null;t=t.next) {
		System.out.print(t.element+" ");
	}
}
public LinkedList addLists(LinkedList l1, LinkedList l2,LinkedList l3) {
	int [] res = new int[l3.size];
	
	Node revhead = l2.reverseList();
	Node temp = l1.head;
	int i;
	if(l1.size==l2.size) {
	for( i=0; i<res.length;i++ ) {
		
		res[i]= (int)temp.element + (int)revhead.element;
	
		revhead=revhead.next;
		temp=temp.next;
	
	}
	}
	
	else if(l1.size>l2.size){
		i=0;
		for(Node n=revhead; n!=null;n=n.next) {
			res[i]= (int)n.element + (int)temp.element;
			temp = temp.next;
			i++;
		}
		for(Node n= temp; n!=null; n=n.next) {
			res[i] =  (int)n.element;
			i++;
		}
	}
	else {
		i=0; 
		for(Node n= temp; n!=null; n=n.next) {
			res[i]=(int)revhead.element+(int)n.element;
			revhead= revhead.next;
			i++;
		}
		for(Node n = revhead; n!=null; n=n.next) {
			res[i] =(int)n.element;
			i++;
		}
	}
	
	l3.makeList(res);
	 return l3;
}

}




