public class CircularArray {
	      private int start;
		  private int size;
		  private Object [] cir;
		  
		  /*
		   * if Object [] lin = {10, 20, 30, 40, null}
		   * then, CircularArray(lin, 2, 4) will generate
		   * Object [] cir = {40, null, 10, 20, 30}
		   */
		  public CircularArray(Object [] lin, int st, int sz){
			  cir = new Object[lin.length];
			  this.start=st;
			  this.size=sz;
			  int k = start;
			  for(int i=0; i<cir.length; i++) {
				  cir[k]= lin[i];
				  
				  k=(k+1)%(cir.length);
				  
			  }
			  
		    //TO DO
		  }
		  
		  //Prints from index --> 0 to cir.length-1
		  public void printFullLinear(){
			  for(int i=0; i<cir.length; i++) {
				  if(i==cir.length-1) { 
					  System.out.print(cir[i]);
				  }
			  else {
			  
				  System.out.print(cir[i]+" ");
				  
			  }
		        //TO DO
			  
		  }
		  }
		  
		  // Starts Printing from index start. Prints a total of size elements
		  public void printForward(){
		    //To DO
			  int k = start;
			  for(int i =0; i<size;i++ ) {
				  System.out.print(cir[k]+" ");
				  k=(k+1)%cir.length;
				  
			  }
			  System.out.println();
		  }
		  
		  
		  public void printBackward(){
			  int k = (start+size -1)%cir.length;
			  for(int i =0; i<size; i++) {
				  System.out.print(cir[k]+" ");
				  k--;
				  if(k==-1) {
					  k = cir.length-1;
				  }
			  }
			  System.out.println();
			  
		   //TO DO
		  }
		  
		  // With no null cells
		  public Object []  linearize(){
			  Object [] l = new Object[size];
			  int k = start;
			  for(int i=0; i<cir.length;i++) {
				  if(cir[k]!=null) {
					 l[i] =cir[k];
					 
				  }
				  k=(k+1)%cir.length;
			  }
			  
			  for(int i=0; i<l.length; i++) {
				  if(i==l.length-1) {
					  System.out.print(l[i]);
				  }
				  else {
					  System.out.print(l[i]+" ");
				  }
				  
			  }
			  System.out.println();
		    return l;
		  }
		  
		  // Do not change the Start index
		  //This method can be implemented without using any return type.
		  //I did this just so you guys learn how it can be done without 
		  //making it void.
		  public Object[] resizeStartUnchanged(int newcapacity){
			  Object [] o = new Object[newcapacity];
			  int k = start;
			  int p = start;
			  for(int i=0; i<cir.length;i++) {
				  o[p]=cir[k];
				  k=(k+1)%cir.length;
				  p=(p+1)%o.length;
				  
			  }
			  return o;
			 
		    //TO DO
		  }
		  
		  // Start index becomes zero
		  public Object [] resizeByLinearize(int newcapacity){
		    //TO DO
			  Object [] o = new Object[newcapacity];
			  int k = start;
			  for(int i = 0; i <cir.length; i++) {
				  o[i] = cir[k];
				  k=(k+1)%cir.length;
			  }
			  
			  // printing out the new resized array to see if the code works.
			 /* for(int i =0; i<o.length;i++ ) {
				  if(i==o.length-1) {
					  System.out.print(o[i]);
				  }
				  else {
					  System.out.print(o[i]+" ");
				  }
			  }*/
			  return o;
		  }
		  
		  /* pos --> position relative to start. Valid range of pos--> 0 to size.
		   * Increase array length by 3 if size==cir.length
		   * use resizeStartUnchanged() for resizing.
		   */
		  /* This method might not work sometimes. So try learning the 
		   * one given in your notes(cse220). That works on most cases.
		   */
		  public void insertByRightShift(Object elem, int pos){
			  Object[] a1 = new Object[cir.length];
		        if(size==cir.length){
		            a1=new Object[cir.length+3];
		        }
		        
		        a1=resizeStartUnchanged(a1.length);
		        cir = a1;
		        int a=(start+pos)%cir.length;
		        for(int i=(start+size-1)%cir.length;i>a;){
		            a1[i]=a1[i-1];
		            i--;
		            if(i<0){
		                i=i+cir.length;
		            }
		        }
		        a1[a]=elem;
		        size++;
		        
		  }
		  

		  
		  public void insertByLeftShift(Object elem, int pos) {
			  Object [] a2 = new Object[cir.length];
			  if(size==cir.length) {
				  a2 = new Object[cir.length+3];
			  }
			  
			  a2 = resizeStartUnchanged(a2.length);
			  cir = a2;
			  int index = (start+pos)%a2.length;
			  for(int i= start; i<=index; i++) {
				  a2[i-1]=a2[i];
				 
			  }
			  a2[index]=elem;
			  start--;
			  size++;
		    //TO DO
		  }
		  
		  /* parameter--> pos. pos --> position relative to start.
		   * Valid range of pos--> 0 to size-1
		   */
		  public void removeByLeftShift(int pos){
		    //TO DO
			  /*check the notes the code is given there*/
		  }
		  
		  /* parameter--> pos. pos --> position relative to start.
		   * Valid range of pos--> 0 to size-1
		   */
		  public void removeByRightShift(int pos){
		    //TO DO
		  }
		  
		  
		  //This method will check whether the array is palindrome or not
		  public void palindromeCheck(){
			  int j = (start+size-1)%cir.length;
			  int i= start;
			  boolean check = true;
			  for(int c =0; c<size/2; c++) {
				  if(cir[i]!=cir[j]) {
					  System.out.println("Oooops!! Not a palindrome");
					  check = false;
					  break;
					  
				  }
				  
				  else {
					  if(j<1) {
						  j=cir.length-1;//this can also be written as j=j+cir.length
					  }
				  }
				  j=(j-1)%cir.length;
				  i=(i+1)%cir.length;
			  
		    //TO DO
		  }
			  if(check==true) {
				  System.out.println("This is a palindrome");
			  }
		  }
		  
		  
		  //This method will sort the values by keeping the start unchanged
		  public void sort(){
		    //TO DO
		  }
		  public boolean palindromeCheckUp() {
			 Object [] linar = linearize();
			/* for(int a =0; a<linar.length; a++) {
				 System.out.println(linar[a]);
			 }*/
			  int j = linar.length-1;
			  int i =0;
			  boolean check = true;
			  for(int count =0; count<(linar.length-1)/2; count++) {
				  if(linar[i]!=linar[j]) {
					  check = false;
					  break;
				  }
				  i++;
				  j--;
			  }
			 return check;
		  }
		  
		  //This method will check the given array across the base array and if they are equivalent interms of values return true, or else return false
		  public boolean equivalent(CircularArray k){
		    //TO DO
		    return false; // Remove this line
		  }
		  
		  // rotating the array by one position
		  public void rotateLeft(CircularArray cr) {
			  
			  Object [] a = linearize();
			  
			  Object var = a[0];
			  int i;
			  for(i =0; i<size-1; i++ ) {
				  a[i]=a[i+1];
			  }
			a[i]=var;
			/*for(int j=0; j<a.length;j++) {
				System.out.print(a[j]+" ");} */
			cir = a;
			
		
			
		  }
		  public void rotateRight(CircularArray cr) {
			  Object [] a = linearize();
			  
			  Object var = a[size-1];
			  for(int i=size-1; i>0; i--) {
				  a[i]=a[i-1];
				  
			  }
			  a[0]=var;
			  cir = a;
		  }
}


