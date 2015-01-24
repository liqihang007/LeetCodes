import java.util.Arrays;


public class MaximumSubarray {

	public static int maxSubArray(int[] A) {
        int sum=0;
        if(A.length>=1){
        	sum=A[0];
        	int temp=A[0];
        	for(int i=1;i<A.length;i++){
        		temp+=A[i];
        		if(A[i]>temp){ // temp is negative
        			temp=A[i];
        		}
        		if(temp>sum){
        			sum=temp;
        		}
        	}
        }
        return sum;
    }
	
	public static void main(String[] args) {
		int A[]=new int[]{-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(A));
	}

}
