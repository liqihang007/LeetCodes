//Write a program to check whether a given number is an ugly number.
//Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
//For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
//Note that 1 is typically treated as an ugly number.

public class UglyNumber {

	public static boolean uglyNumber(int num) {
        int tmp;
        do{
        	tmp=num;
        	num=(num%2==0)? num/2 : num;
        	num=(num%3==0)? num/3 : num;
        	num=(num%5==0)? num/5 : num;
        }while (num!=tmp);
        return (num==1)? true : false;
    }

	public static void main(String[] args) {
		System.out.println(uglyNumber(6));
		System.out.println(uglyNumber(8));
		System.out.println(uglyNumber(14));

	}

}
