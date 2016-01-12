//Given an integer, write a function to determine if it is a power of 3.

/*The idea is that the ternary number that is power of 3 will be something like 10,100,1000, etc. 
Analogous to binary numbers that are powers of 2.*/

public class PowerofThree {
	public boolean isPowerOfThree(int n) {
        String s = Integer.toString(n, 3);
        if (s.contains("2")) 
            return false;
        int result = Integer.valueOf(s, 2) & (Integer.valueOf(s, 2)-1);
        return result==0 & n>0 ? true : false;
    }
}
