//Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
//For example, given the range [5, 7], you should return 4.

/*
We can find two numbers that are special in the range [m, n]
(1) m' = 0bxyz0111
(2) n' = 0bxyz1000
The bitwise AND of all the numbers in range [m, n] is just the bitwise AND of the two special number
rangeBitwiseAnd(m, n) = m' & n' = 0bxyz0000
This tells us, the bitwise and of the range is keeping the common bits of m and n from left to right 
until the first bit that they are different, padding zeros for the rest.
*/

public class BitwiseANDofNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
		int i=0;
		while(m!=n){
			m>>=1;
			n>>=1;
			i++;
		}
		return n<<i;
    }
}
