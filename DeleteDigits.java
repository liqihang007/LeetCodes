//Given string A representative a positive integer which has N digits, remove any k digits of the number, the remaining digits are arranged according to the original order to become a new positive integer. Make this new positive integers as small as possible.
//N <= 240 and k <=N, 
//Example
//Given an integer A = 178542, k = 4
//return a string "12"
//Given an integer A = 90123549, k = 2
//return a string "12349"
		
public class DeleteDigits {

	public static String DeleteDigits(String A, int k) {
        if(k==0){
        	int i=0;
        	while(A.charAt(i)=='0')
        		i++;
        	return A.substring(i);
        }
        int i=1;
        while(i<A.length() && A.charAt(i-1)<=A.charAt(i))
        	i++;
        if(i==A.length()){
        	int j=0;
        	while(A.charAt(j)=='0' && j<A.length()-k)
        		j++;
        	return A.substring(j,A.length()-k);
        }
        String res="";
        res=A.substring(0,i-1)+A.substring(i,A.length());
    	return DeleteDigits(res, k-1);
    }
	
	public static void main(String[] args) {
		System.out.println(DeleteDigits("178542",4));
		System.out.println(DeleteDigits("90123549",2));
		System.out.println(DeleteDigits("1111111111111111112222222222222222222222223333333333333333333344444444444444444444555555555555555555555666666666666666666665789",1));
	}

}
