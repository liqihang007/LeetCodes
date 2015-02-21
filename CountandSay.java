//The count-and-say sequence is the sequence of integers beginning as follows:
//1, 11, 21, 1211, 111221, ...
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//Given an integer n, generate the nth sequence.
//Note: The sequence of integers will be represented as a string.

public class CountandSay {

	public static String countAndSay(int n) {
        String s="1";
        int ct=1;
        while(ct<n){
	        String temp="";
	        for(int i=0;i<s.length();i++){
	        	int j=i+1;
	        	for(;j<s.length();j++){
	            	if(s.charAt(j)!=s.charAt(i)){
	            		break;
	            	}	            	
	            }
	        	if(j-i>1){
	        		temp=temp+(j-i)+s.charAt(i);
	        		i=j-1;
	        	}
	        	else{
	        		temp=temp+"1"+s.charAt(i);
	        	}
	        }
	        ct++;
	        s=temp;
        }
        return s;
    }
	
	public static void main(String[] args) {
		System.out.println(countAndSay(2));
	}

}
