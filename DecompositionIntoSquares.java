//Given a positive integer, please decompose into a sum of perfect squares, using as few terms as possible.
//E.g., 7 = 4 + 1 + 1 + 1
//12 = 4 + 4 + 4

import java.util.*;

public class DecompositionIntoSquares {

	public static List<Integer> decompose(int A){
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		int[]num=new int[32];
		for(int i=0;i<32;i++){
			num[i]=(int)Math.pow((double)(i+1),2.0);
		}
		helper(res,new ArrayList<Integer>(),A,num);
		int min=Integer.MAX_VALUE, which=-1;
		for(int i=0;i<res.size();i++){
			if(res.get(i).size()<min){
				min=res.get(i).size();
				which=i;
			}
		}
		if(which>=0)
			return res.get(which);
		return null;
	}
	
	public static void helper(List<List<Integer>> res, List<Integer> list, int A, int[]num){
		if(A<0){
			return;
		}
		if(A==0){
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i=num.length-1;i>=0;i--){
			if(A>=num[i]){
				list.add(num[i]);
				helper(res,list,A-num[i],num);
				list.remove(list.size()-1);
			}
		}
	}
	
//	public List<Integer> decompose(int A){
//		//List<Integer> res=new ArrayList<Integer>();
//		HashMap<Integer, List<Integer>> res = new HashMap<Integer, List<Integer>>();
//		int [] dp = new int[A+1];
//		Arrays.fill(dp, Integer.MAX_VALUE);
//		dp[0]=0;
//		for(int i=1;i<=A;i++){
//		if(isSquare(i))
//			dp[i+1]=1;
//			res.get(i+1).add(i);
//		}
//		for(int i=1;i<=A;i++){
//			for(int j=i-1;j>=1;j--){
//				if(isSquare(i-j+1)){
//					if(dp[i]>dp[j]+1){
//						dp[i]=dp[j]+1;
//						if(res.containsKey(j))
//							res.get(i-1).add(j);
//					}
//
//				}
//		
//			}
//		}
//		return res.get(A);
//	} 
	
	public boolean isSquare(int num){
		return (num & (num-1)) == 0;
	}
	
	public static void main(String[] args) {
		System.out.println(decompose(100));
	}
}
