//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//Each element in the array represents your maximum jump length at that position.
//Determine if you are able to reach the last index.
//For example:
//A = [2,3,1,1,4], return true.
//A = [3,2,1,0,4], return false.

import java.util.Arrays;

public class JumpGame {

	public static boolean canJump(int[] A) { // DP: the available steps left
        if (A==null || A.length==0){
        	return false;
        }
        else{
        	int[] B=new int[A.length];
        	B[0]=0;
        	for (int i=1;i<A.length;i++){
        		B[i]=Math.max(A[i-1],B[i-1])-1;
        		if (B[i]<0){
        			return false;
        		}
        	}
        	return true;
        }
    }
	
	public static void main(String[] args) {
		int[] A1={2,3,1,1,4};
		int[] A2={3,2,1,0,4};
		int[] A3={2,5,0,0,0,0,0};
		int[] A4={0};
		boolean a1=canJump(A1);
		boolean a2=canJump(A2);
		boolean a3=canJump(A3);
		boolean a4=canJump(A4);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
	}

}
