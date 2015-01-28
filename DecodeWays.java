import java.util.Arrays;

//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//Given an encoded message containing digits, determine the total number of ways to decode it.
//For example, Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//The number of ways decoding "12" is 2.

public class DecodeWays {
	
	public static int numDecodings(String s) {	// DP
		if(s==null || s.length()<=0 || Character.getNumericValue(s.charAt(0))==0){return 0;}
		char[] nums = s.toCharArray();
		if(s.length()==1){
    		if(nums[0]==0){return 0;}
    		return 1;
    	}
		int []check=new int[nums.length];
		check[0]=1;
		for(int i=1;i<nums.length;i++){
			check[i]=check[i-1];
			if(nums[i]=='0' && !(nums[i-1]=='1' || nums[i-1]=='2')){ // 00 or 30, 40 ...
				return 0;
			}
			if(nums[i-1]=='1' && nums[i]!='0' && ((i+1<nums.length && nums[i+1]!='0') || i==nums.length-1)){ // 11-19, but not 110,190...
				if(i>2){check[i]+=check[i-2];}
				else{check[i]+=1;}
			}
			if(nums[i-1]=='2' && nums[i]>='1' && nums[i]<='6'){ // 21-26, but not 210,260...
				if(i>2){check[i]+=check[i-2];}
				else{check[i]+=1;}
			}
    	}
		return check[check.length-1];
	}

//    public static int numDecodings(String s) {	// recursive
//    	if(s==null || s.length()<=0 || Character.getNumericValue(s.charAt(0))==0){return 0;}
//    	if(s.length()==1){
//    		int test= Integer.parseInt(s);
//    		if(test==0){return 0;}
//    		return 1;
//    	}
//    	if(s.length()==2){
//    		int test= Integer.parseInt(s);
//    		if(test==0 || (test%10==0 && test>26)){return 0;}
//    		if(test==10 || test==20 || test>26){return 1;}
//    		return 2;
//    	}
//    	if(s.length()>2){
//    		if(s.charAt(0)=='0'){return 0;}
//    		int test = Integer.parseInt(s.substring(0,2));
//    		if(test==0 || (test%10==0 && test>26)){return 0;}
//    		if(test==10 || test==20){
//    			return numDecodings(s.substring(2,s.length()));
//    		}
//    		else{
//    			if(test>26){
//    				return numDecodings(s.substring(1,s.length()));
//    			}
//    			else{
//    				return numDecodings(s.substring(1,s.length()))+numDecodings(s.substring(2,s.length()));
//    			}
//    		}
//    	}
//    	return 0;
//    }
	
	public static void main(String[] args) 
	{
		String s1="1010101010";
		String s2="230";
		String s3="11";
		String s4="611";
		String s5="9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253";
		System.out.println(numDecodings(s1));
		System.out.println(numDecodings(s2));
		System.out.println(numDecodings(s3));
		System.out.println(numDecodings(s4));
		System.out.println(numDecodings(s5));
	}
}