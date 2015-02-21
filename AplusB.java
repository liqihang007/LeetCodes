//For given numbers a and b in function aplusb, return the sum of them.

public class AplusB {

	public static int aplusb(int a, int b) { // Iterative
        int carry=0;
        do{
        	carry=a&b; //CARRY is AND of two bits
        	b=a^b; //SUM of two bits is A XOR B
        	a=carry<<1; //shifts carry to 1 bit to calculate sum
        }while(a!=0);
        return b;
    }
    
    public static int add(int a, int b){ // Recursive
        if(b == 0) return a;
        int sum = a ^ b; //SUM of two integer is A XOR B
        int carry = (a & b) << 1;  //CARRY of two integer is A AND B
        return add(sum, carry);
    }
	
	public static void main(String[] args) {
		System.out.println(aplusb(123,34));
	}

}
