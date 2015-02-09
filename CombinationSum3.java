//Given n distinct positive integers, integer k (k <= n) and a number target.
//Find k numbers where sum is target. Calculate how many solutions there are?
//Example
//Given [1,2,3,4], k=2, target=5. There are 2 solutions:
//[1,4] and [2,3], return 2.
	
import java.util.*;

public class CombinationSum3 {
	
	public int kSum(int A[], int k, int target){	//	DP
		if(k==0 || A.length==0) return 0;
		int size=A.length;
		int[][][]dp=new int [k+1][size+1][target+1];	//how many ways to select k nums in the first sz elements with target
		for(int i=1; i<=size; i++){
			if(A[i-1]<=target){
				for(int j=i;j<=size;j++){
					dp[1][j][A[i-1]]=1;
				}
			}
		}
		for(int i=2;i<=k;i++){
			for(int j=i;j<=size;j++){
				for(int p=1;p<=target;p++){
					dp[i][j][p]=0;
					if(j>i){	//	ignore A[j-1]
						dp[i][j][p]+=dp[i][j-1][p];
					}
					if(p>=A[j-1]){	//	choose A[j-1]
						dp[i][j][p]+=dp[i-1][j-1][p-A[j-1]];
					}
				}
			}
		}
		return dp[k][size][target];
	}
	
//	public int kSum(int A[], int k, int target) {
//        if(k==0 || A.length==0) return 0;
//        int res=0;
//        Arrays.sort(A);
//        helper(A, res, 0, 0, k, target);
//        return res;
//    }
//	
//	public void helper(int A[], int res, int size, int pos, int k, int tar){
//		if(size>k || tar<0) return;
//		if(size==k && tar==0){
//			res++;
//			return;
//		}
//		for(int i = pos;i<A.length;i++){
//			if(A[i]<tar)
//				helper(A, res, size, i+1, k, tar-A[i]);
//		}
//	}
	
	public static void main(String[] args) {
		CombinationSum3 test=new CombinationSum3();
		int[]A=new int []{1,3,4,5,8,10,11,12,14,17,20,22,24,25,28,30,31,34,35,37,38,40,42,44,45,48,51,54,56,59,60,61,63,66};
//		List<List<Integer>> res= test.kSum(new int[]{1,2,3,4},2,5);
		int res= test.kSum(A,24,842); // 453474
		System.out.println(res);

	}

}
