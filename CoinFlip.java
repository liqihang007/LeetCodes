// Given M coins to flip, return how many possible ways that N coins are heads on.

import java.util.*;

public class CoinFlip {
	static public int coinflipways(int n, int m){
		if(m == 0 || n > m) return 0;
		int res = 1;
		for (int i = n+1; i <= m; i++){
			res *= i;
		}
		for (int i = 1; i <= m-n; i++){
			res /= i;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		s.trim();
		String [] input = s.split(" ");
		int res = coinflipways(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		System.out.println(res);
	}
}
