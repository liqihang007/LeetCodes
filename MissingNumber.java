// 0-N numbers in a N-size array with one number is missing, find its index

public class MissingNumber {

	public static int findMissing(int [] A){
		if(A.length==0)
			return 0;
		if(A[0]!=0)
				return 0;
		if(A[A.length-1]==A.length-1)
				return A.length;
		int a=0, b=A.length-1;
		while(a<b){
			int mid=(a+b)/2;
			if(A[mid]==mid)
				a=mid+1;
			else
				b=mid;
		}
		return a;
	}
	
	public static void main(String[] args) {
		int[]A=new int[] {0,2,3};
		System.out.println(findMissing(A));
	}
}
