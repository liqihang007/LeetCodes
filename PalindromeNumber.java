//Determine whether an integer is a palindrome. Do this without extra space.
//Some hints:
//Could negative integers be palindromes? (ie, -1)
//If you are thinking of converting the integer to string, note the restriction of using extra space.
//You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
//There is a more generic way of solving this problem.

public class PalindromeNumber {

	public static boolean isPalindrome(int x) {
        if (x<0){return false;}
        if (x<10 && x>0){return true;}
        int i=10;
        int j=1;
        while(x/j>=10){
        	j*=10;
        }
        while(x>0){
        	int p=x%10;
        	int q=x/j;
        	System.out.println(p+" "+q);
        	if(p!=q){
        		return false;
        	}
        	x=x%j;
        	x=x/10;
        	j/=100;
        }
        return true;
    }
	public static void main(String[] args) {
		System.out.println(isPalindrome(1000021));
	}

}
