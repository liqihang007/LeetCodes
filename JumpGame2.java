//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//Each element in the array represents your maximum jump length at that position.
//Your goal is to reach the last index in the minimum number of jumps.
//For example:
//Given array A = [2,3,1,1,4]
//The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

public class JumpGame2 {

	public static int jump(int[] A) {
        if(A==null || A.length<=1){return 0;}
        int res=1;
        int begin=0; // where you stand
        int maxstep=A[0]; // the max range you can jump from "begin"
        
        while(maxstep<A.length-1){
            int maxrange=0; // the max range you can jump from "maxstep"
            for(int i=begin;i<=maxstep;i++){
                maxrange=Math.max(maxrange,i+A[i]);
            }
            begin=maxstep+1;
            maxstep=Math.max(maxstep,maxrange);
            res++;
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[]A=new int[]{2,1};
		System.out.println(jump(A));

	}

}
