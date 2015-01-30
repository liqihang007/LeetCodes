//Given an array of integers, every element appears three times except for one. Find that single one.

public class SingleNumber2 {
/*
	Image the numbers in A have just one bit,
	that is: A = [0, 0, 0, 1, 1, 1, x]
	We have three times "0", three times "1", and a different "x".
	So, if count of "1" in A is three's multiple, than x = 0,
	else, x = 1.
	Iterate all numbers in A.
	When encount FIRST "1", set "ec1 = 1";
	When encount SECOND "1", set "ec2 = 1";
	When encount THIRD "1", set "ec3 = 1, ec1 = 0, ec2 = 0", and move on...
	At last "ec1" is the different number.
*/
	public static int singleNumber(int[] A) {
        int bit1=0, bit2=0, bit3=0;
        for(int i:A){
        	bit3=bit2 & i;
        	bit2=(bit2 | (bit1 & i)) & ~bit3;
        	bit1=(bit1 | i) & ~bit3;
        }
//        System.out.println(bit2);
        return bit1;
    }
	
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] {1,1,1,3,3,3,5,5,5,34,34,34,8}));
	}

}
