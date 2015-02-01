//Given a string s, partition s such that every substring of the partition is a palindrome.
//Return the minimum cuts needed for a palindrome partitioning of s.
//For example, given s = "aab",
//Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

import java.util.*;

public class PalindromePartitioning2 {

	public static int minCut(String s) {
        if(s==null || s.length()<=1){return 0;}
        int len=s.length();
        int[]check=new int[len+1];
        boolean [][]table=checkpal_DP(s);
        Arrays.fill(check, Integer.MAX_VALUE);
        check[0]=-1;
        for(int i=0;i<len;i++){
        	for(int j=0;j<=i;j++){
        		if(table[j][i]){
        			check[i+1]=Math.min(check[i+1], check[j]+1);
        		}
        	}
        }
//        System.out.println(Arrays.toString(check));
        return check[len];
    }
	
	public static boolean[][] checkpal_DP(String s){
		int len=s.length();
		boolean[][] table=new boolean[len][len];
		for(int i=len-1;i>=0;i--){
			for(int j=i;j<len;j++){
				if(i==j){
					table[i][j]=true;
					continue;
				}
				if(j-i==1){
					table[i][j]=(s.charAt(i)==s.charAt(j));
					continue;
				}
				table[i][j]=(s.charAt(i)==s.charAt(j))&&(table[i+1][j-1]);
			}
		}
		return table;
	}

	public static void main(String[] args) {
		System.out.println(minCut("aabcbr"));
	}

}
