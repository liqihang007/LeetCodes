//Given a positive integer, please decompose into a sum of perfect squares, using as few terms as possible.
//E.g., 7 = 4 + 1 + 1 + 1
//12 = 4 + 4 + 4

import java.util.*;

public class DecompositionIntoSquares {

	public List<Integer> decompose(int A){
		//List<Integer> res=new ArrayList<Integer>();
		HashMap<Integer, List<Integer>> res = new HashMap<Integer, List<Integer>>();
		int [] dp = new int[A+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0]=0;
		for(int i=1;i<=A;i++){
		if(isSquare(i))
			dp[i+1]=1;
			res.get(i+1).add(i);
		}
		for(int i=1;i<=A;i++){
			for(int j=i-1;j>=1;j--){
				if(isSquare(i-j+1)){
					if(dp[i]>dp[j]+1){
						dp[i]=dp[j]+1;
						if(res.containsKey(j))
							res.get(i-1).add(j);
					}

				}
		
			}
		}
		return res.get(A);
	} 
	
	public boolean isSquare(int num){
		return (num & (num-1)) == 0;
	}
	
	public static void main(String[] args) {

	}
}
