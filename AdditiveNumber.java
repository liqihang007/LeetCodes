//Additive number is a string whose digits can form additive sequence.
//A valid additive sequence should contain at least three numbers. 
//Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
//For example:
//"112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
//1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
//"199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
//1 + 99 = 100, 99 + 100 = 199
//Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
//Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

public class AdditiveNumber {
	public boolean isAdditiveNumber(String num) {
		for(int i=1; i<num.length()-1; i++){
            for(int j=i+1; j<num.length(); j++) {
                if(dfs(num, 0, i, j)) return true;
            }
        }
        return false;
    }
	
	public boolean dfs(String num, int start, int end1, int end2) {
        String s1 = num.substring(start, end1);
        String s2 = num.substring(end1, end2);
        if((s1.length()>1 && s1.charAt(0)=='0') || (s2.length()>1 && s2.charAt(0)=='0')) 
        	return false;
        long n1 = Long.valueOf(s1);
        long n2 = Long.valueOf(s2);
        String result = String.valueOf(n1+n2);
        if(num.substring(end2).length()==0) 
        	return true;
        if(num.substring(end2).indexOf(result)!=0) 
        	return false;
        return dfs(num, end1, end2, end2+result.length());
    }
}
