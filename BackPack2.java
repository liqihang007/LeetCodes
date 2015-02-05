//Given n items with size A[i] and value V[i], and a backpack with size m. 
//What's the maximum value can you put into the backpack?
//Example
//Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.

public class BackPack2 {

	public int backPackII(int m, int[] A, int V[]) {
        int n=A.length;
        int[]dp=new int[m+1];
        for(int i=0;i<n;i++){
	        for(int j=m;j>=A[i];j++){
	        	dp[j]=Math.max(dp[j-A[i]]+V[i],dp[j]);
	        }
        }
        return dp[m];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
