//Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
//You have the following 3 operations permitted on a word:
//a) Insert a character
//b) Delete a character
//c) Replace a character

public class EditDistance {

	public int minDistance(String word1, String word2) { // DP
        int m=word1.length(), n=word2.length();
        if(m==0){return n;}
        if(n==0){return m;}
        int [][]table=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
        	table[i][0]=i;
        }
        for(int j=0;j<=n;j++){
        	table[0][j]=j;
        }
        for(int i=1;i<=m;i++){
        	for(int j=1;j<=n;j++){
        		int cost=0;
        		if(word1.charAt(i-1)!=word2.charAt(j-1)){
        			cost=1;
        		}
        		table[i][j]=Math.min(Math.min(table[i-1][j]+1, table[i][j-1]+1),table[i-1][j-1]+cost);
        	}
        }
        return table[m][n];
    }
	
	public static void main(String[] args) {
		String a="abcdefg";
		String b="bdefgt";
		System.out.println(new EditDistance().minDistance(a,b));
	}

}
