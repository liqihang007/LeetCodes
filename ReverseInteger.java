//Reverse digits of an integer.
//Example1: x = 123, return 321
//Example2: x = -123, return -321
//Have you thought about this?
//Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
//If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
//Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
//For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

public class ReverseInteger {

	public static int reverse(int x) {
        if(x<0){
        	String s=-x+"";
        	String revs=new StringBuilder(s).reverse().toString();
        	try{
        		int revi=Integer.parseInt(revs);
		    	return -revi;
		    } catch(Exception e){
		    	return 0;
		    }
        }
        else{
        	String s=x+"";
        	String revs=new StringBuilder(s).reverse().toString();
        	try{
        		int revi=Integer.parseInt(revs);
		    	return revi;
		    } catch(Exception e){
		    	return 0;
		    }
        }
    }

	public static void main(String[] args) {
		int a=1000000003;
		System.out.println(reverse(a));
	}

}
