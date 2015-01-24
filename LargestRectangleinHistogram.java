//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
//For example,
//Given height = [2,1,5,6,2,3],
//return 10.

		import java.util.*;

public class LargestRectangleinHistogram {

	public static int largestRectangleArea(int[] height) {
        int res=0;
        if(height.length>=1){
        	int []A=new int[height.length+1];
        	for(int i=0;i<height.length;i++){A[i]=height[i];}
        	A[height.length]=0;
        	res=A[0];
        	Stack<Integer> S=new Stack<Integer>();
        	for(int i=1;i<A.length;i++){
        		System.out.println(S+" "+res);
        		if(S.isEmpty() || A[i]>A[S.peek()]){
        			S.push(i);     			
        			continue;
    			}
        		else{
        			int temp=S.pop();
        			int w = S.isEmpty()? i : i-S.peek()-1;
        			res=Math.max(w*A[temp],res);
        			i--;
        		}
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		int A[]=new int[]{1};
		System.out.println(largestRectangleArea(A));
	}

}
