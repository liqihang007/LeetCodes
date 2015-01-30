//Given a string (1-d array) , find if there is any sub-sequence that repeats itself. 
//Here, sub-sequence can be a non-contiguous pattern, with the same relative order. 
//Eg: 
//1. abab <------yes, ab is repeated 
//2. abba <---- No, a and b follow different order 
//3. acbdaghfb <-------- yes there is a followed by b at two places 
//4. abcdacb <----- yes a followed by b twice 

public class RepeatSubSequence {

	public static int repeatSubSequence(String s){ // modifirf LCS
		if(s==null || s.length()<=1){return 0;}
		int n=s.length();
		int [][]table=new int[n+1][n+1];
		for(int i=0;i<=n;i++){
			table[i][0]=0;
			table[0][i]=0;
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				if(i!=j && s.charAt(i-1)==s.charAt(j-1)){
					table[i][j]=table[i-1][j-1]+1;
				}
				else{
					table[i][j]=Math.max(table[i-1][j],table[i][j-1]);
				}
			}
		}
		return table[n][n];
//		if(table[n][n]>1){return true;}
//		else{return false;}
	}
	
	public static void main(String[] args) {
		String a="abab";
		String b="abba";
		String c="acbdaghfb";
		String d="abcdacb";
		System.out.println(repeatSubSequence(a));
		System.out.println(repeatSubSequence(b));
		System.out.println(repeatSubSequence(c));
		System.out.println(repeatSubSequence(d));
	}

}
