//Using O(1) time to check whether an integer n is a power of 2.
//Example
//For n=4, return true
//For n=5, return false

public class PowerofTwo {

	public boolean isPowerOfTwo(int n) {
		// n is true iff be 10, 100, 1000, 10000, etc
		return n>0 && (n&(n-1))==0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
