//Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
//Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//Note: You may not slant the container.

import java.util.*;

public class ContainerWithMostWater {
	public static int maxArea(int[] height) {
		int myreturn=0;
		if(height!=null && height.length>=2){
			int i=0, j=height.length-1;
			while(i<j){
				if(height[i]<height[j]){
                    res=max(res,height[i]*(j-i));
					i++;
				}
				else{
					res=max(res,height[j]*(j-i));
                    j--;
				}
			}
		}
		return myreturn;
	}

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] {2,1}));
	}
}
