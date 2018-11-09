import java.util.*;
public class Quiz2Sol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size and  values for first list");
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i =0; i<n;i++) {
			a[i]= sc.nextInt();
		}
		System.out.println("Enter size and values for second list");
		n = sc.nextInt();
		int [] b = new int[n];
		for(int i=0; i<n; i++) {
			b[i]= sc.nextInt();
		}
		/* Will make two linkedlists from the values of the integer arrays*/
		LinkedList l1 = new LinkedList(a.length);
		l1.makeList(a);
		LinkedList l2 = new LinkedList(b.length);
		l2.makeList(b);
		
		/*reversing any of the linkedlist */
		LinkedList result;
		if(a.length>b.length) {
			 result = new LinkedList(a.length);
		}
		else {
			 result = new LinkedList(b.length);
		}
		result=result.addLists(l1,l2,result);
		result.printList();

	}

}
