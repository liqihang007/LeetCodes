import java.util.*;

public class ContainerWithMostWater {
	public static int maxArea(int[] height) {
		int myreturn=0;
		if(height!=null && height.length>=2){
			int i=0, j=height.length-1;
			while(i<j){
				if(height[i]<height[j]){
					if (myreturn<height[i]*(j-i)){
						myreturn=height[i]*(j-i);
					}
					i++;
				}
				else{
					if (myreturn<height[j]*(j-i)){
						myreturn=height[j]*(j-i);
					}
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
