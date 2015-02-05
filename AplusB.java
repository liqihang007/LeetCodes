//For given numbers a and b in function aplusb, return the sum of them.

public class AplusB {

	public static int aplusb(int a, int b) {
        int carry=0;
        do{
        	carry=a&b;
        	b=a^b;
        	a=carry<<1;
        }while(a!=0);
        return b;
    }
	
	public static void main(String[] args) {
		System.out.println(aplusb(123,34));
	}

}
