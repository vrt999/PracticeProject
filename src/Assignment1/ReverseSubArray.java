package Assignment1;

public class ReverseSubArray {

	public static void main(String[] args) {
		int A[] = { 1,2,3,4,5,6,7}, n = 4;
		ReverseSubArray r = new ReverseSubArray();
//		r.reverseConcrete(A,n);
		r.NumfromArray();
	}
		
	public void reverseSubArray() {		
		int A[] = { 1, 2, 3,4,5,6,7}, n = 3;
		int B[] = new int[A.length];
		int l = A.length / n;
		int o = A.length % n;
		int m = 0, k = 0, i = 0, j = 0;
		while (l >= 1) {
			k = n * m;
			for (i = k + 2, j = k; i >= k; i--, j++) { //2,0 1,1 0,2
				B[j] = A[i];
			}
			l--;
			m++;
		}

		if (o == 0) {
			for (int a : B)
				System.out.print(a + " ");
		} else if (o == 1) {
			B[j] = A[j];
			for (int a : B)
				System.out.print(a + " ");
		} else if (o == 2) {
			B[j] = A[j+1];
			B[j+1] = A[j];
			for (int a : B)
				System.out.print(a + " ");
		}
	}
	
	public void reverseConcrete(int A[],int n) {		
		int l = A.length;
		int m = 0, k= 0;
		while (l >=n) {			
			k = m+n-1;
			int c[] = reverse(A,m,k);
			for (int a : c)
				System.out.print(a + " ");
			l = l-n;
			m=m+n;
		}
		int c[] = reverse(A,k+1,A.length-1);
		for (int a : c)
			System.out.print(a + " ");
		
		}

	public int[] reverse(int[] x,int from,int to) {
		int b[] = new int[to-from+1];
		for(int g = 0,h = to;h>=from;g++,h--) {
			b[g] = x[h];
		}		
		return b;
		
	}
	
	public void leastNum() {
		int A[] = {8,4,6,9,3,2,5};
		int min = A[0];
		
		for(int i = 1;i<A.length;i++) 
			if(min>A[i])
				min = A[i];	
		
		System.out.println("The least array element: " + min);
	}
	
	public void leastTwoNum() {
		int A[] = {8,4,6,9,3,2,5};
		int least = A[0];
		int secondleast = A[1];
		
		for(int i = 1;i<A.length;i++) 
			if(least>A[i]) {
				secondleast = least;
				least = A[i];}
			else if(secondleast>A[i])
			secondleast = A[i];
		
		System.out.println("The least array element: " + least);
		System.out.println("The second least array element: " +secondleast);
	}
	
	public void NumfromArray() {
		int A[] = {8,4,6,9,3,2,5};
		long n = 0;
		
		for(int i =A.length - 1,j=0;i>=0;i--) {
			n = (long) (n+(A[i]*Math.pow(10, j)));
			j++;
		}
		
		System.out.println("The number: " + n);
		
	}

}
