//Hamming Distance between two strings of equal length is the number of positions at which the corresponding symbols are different.
//Write a function that takes a list of binary numbers and returns the sum of the hamming distances for each pair.
//Do it in O(n) time.

/*
The naive solution is O(n2), so we simplify this question by using {0,0,0,1,1} as input.
The output in this case would be 6. Why? Because 3 x 2 = 6.
So the equation for solution would be:
distance (for a bit) = number of '1's * number of '0's
The final answer would be the sum of distances for all bits.
*/

public class HammingDistanceofArray {

	public static int hammingDistanceofArray(int[] num){	//O(n^2)
		int res=0;
		for(int i=0;i<num.length-1;i++){
			for(int j=i+1;j<num.length;j++){
				if(num[i]!=num[j]){
					res++;
				}				
			}
		}
		return res;
	}
	
	public static int hammingDist(int[] nums) {	//O(n)
	    int[] bits = new int[32];
	    for (int i = 0; i < nums.length; i++) {
	        int j = 0;
	        while (nums[i]!=0) {
	            if ((nums[i]&1)!=0){
	                bits[j]++;
	            }
	            j++;
	            nums[i]/=2;
	        }
	    }
	    int res=0;
	    for (int i=0; i<32; i++) {
	        res+=bits[i]*(nums.length-bits[i]);
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		int []A=new int[]{0,0,0,1,0,1,1,1,0,1,1,0,0,1,0,0,1,1,0,1};
		int []B=new int[]{0,0,0,1,0,1,1,1,0,1,1,0,0,1,0,0,1,1,0,1};
		System.out.println(hammingDist(A));
		System.out.println(hammingDistanceofArray(B));
	}
}
