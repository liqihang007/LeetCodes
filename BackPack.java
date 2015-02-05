//Given n items with size A[i], an integer m denotes the size of a backpack. How full you can fill this backpack? 
//You can not divide any item into small pieces.
//Example
//If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select 2, 3 and 5, so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.
//You function should return the max size we can fill in the given backpack.
		
/**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
*/

public class BackPack {

    public int backPack(int m, int[] A) {
        if(m==0 || A.length==0) return 0;
        int n=A.length, res=0;
        boolean[]dp=new boolean [m+1];
        dp[0]=true;
        for(int i=0;i<n;i++){
            for(int j=m;j>=A[i];j--){
                dp[j]=dp[j-A[i]];
                if(dp[j]){
                	res=Math.max(j, res);
                }
            }
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
