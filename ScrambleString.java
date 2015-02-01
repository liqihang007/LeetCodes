//Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
//Below is one possible representation of s1 = "great":
//    great
//   /    \
//  gr    eat
// / \    /  \
//g   r  e   at
//           / \
//          a   t
//To scramble the string, we may choose any non-leaf node and swap its two children.
//For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
//    rgeat
//   /    \
//  rg    eat
// / \    /  \
//r   g  e   at
//           / \
//          a   t
//We say that "rgeat" is a scrambled string of "great".
//Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
//    rgtae
//   /    \
//  rg    tae
// / \    /  \
//r   g  ta  e
//       / \
//      t   a
//We say that "rgtae" is a scrambled string of "great".
//Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

public class ScrambleString {

/*	DP
    f[n][i][j] means isScramble(s1[i: i+n], s2[j: j+n])
    f[n][i][j] = (f[k][i][j] && f[n-k][i+k][j+k]) || (f[k][i][j+n-k] && f[n-k][i+k][j]) for each k<n
    input: f[0][:][:]
    return: f[n-1][0][0]
*/
	
	public static boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()){return false;}
        if(s1.length()==0){return true;}
        if(s1.length()==1 && s1.equals(s2)){return true;}
        int n=s1.length();
        boolean dp[][][]=new boolean [n][n][n];
        for(int i=0;i<n;i++){
        	for(int j=0;j<n;j++){
        		dp[0][i][j]=s1.charAt(i)==s2.charAt(j);
        	}
        }
        for(int len=2 ;len<=n; len++){
        	for(int i=n-len;i>=0;i--){
            	for(int j=n-len;j>=0;j--){
            		for(int k=1; k<len; k++){
            			if((dp[k-1][i][j]&&dp[len-1-k][i+k][j+k]) || (dp[k-1][i][j+len-k]&&dp[len-k-1][i+k][j])){
            				dp[len-1][i][j]=true;
            				break;
            			}
            		}
            	}
            }
        }
        return dp[n-1][0][0];
    }

	public static void main(String[] args) {
		System.out.println(isScramble("great","rgtae"));
	}
}
