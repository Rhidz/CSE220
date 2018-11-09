
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object [] o =  {10,20,20,40,null};
		CircularArray ca = new CircularArray(o,2,4);
		//ca.printFullLinear();
		//ca.printForward();
		
		//ca.printBackward();
       //test resizeStartUnchanged.
		/*Object [] test = ca.resizeStartUnchanged(7);
		for(int i =0; i<test.length; i++) {
			if(i==test.length-1) {
				System.out.print(test[i]);
			}
			else {
				System.out.print(test[i]+" ");
			}
		}*/
		//System.out.println();
		//ca.insertByLeftShift(66, 2);
		//ca.printForward();
		//ca.palindromeCheck();
		//ca.rotateLeft();
		//ca.printForward();
		Object [] o1 =  {10,10,20,20,null,null};
		CircularArray ca2 = new CircularArray(o1,2,4);
		
		
		/* quiz solution for the previous array. To make it palindrome 
		 * it needs to be rotated right. For convenience I have linearized the array hence the
		 * values of the null is not considered. To make the array a palindrome you need to
		 * rotate it right once. You can take a different object array and run the method
		 * rotateright|rotateleft in order to make the array a palindrome. As the question
		 * of the quiz said to use the circular array class I implemented it using the linearize m
		method as its easy and understandable. You can get more creative if you want. Hope this 
		helps. */
		ca2.rotateRight(ca2);
		ca2.palindromeCheckUp();
		boolean ans = ca2.palindromeCheckUp();
		if(ans) {
			System.out.println("Your array is a palindrome");
		}
		else {
			System.out.println("Please try rotating a few more times to get a palindrome");
		}
		
	}

}

