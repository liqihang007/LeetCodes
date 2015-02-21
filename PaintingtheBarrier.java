//There are n barriers, you paint them use 2 colors, but no more than 2 neighbor barriers are in the same color.
//Return the maximal ways you can paint them?

import java.util.*;

public class PaintingtheBarrier {

	public static int paintingtheBarrier(int n){
		if(n==1){return 2;}
		if(n==2){return 4;}
		int []A=new int [n];
		A[0]=2;
		A[1]=4;
		for(int i=2;i<n;i++){
			A[i]=A[i-1]+A[i-2];
		}
		return A[n-1];
	}
	
	public static void main(String[] args) {
		System.out.println(paintingtheBarrier(10));
		int a=2;
		System.out.println(""+(~a));
	}

}
