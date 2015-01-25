//Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
//Return the sum of the three integers. 
//You may assume that each input would have exactly one solution.
//For example, given array S = {-1 2 1 -4}, and target = 1.
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

import java.util.*;

public class ThreeSumClosest {

	public static int threeSumClosest(int[] num, int target) {
        int result=0;
        int mymin=Integer.MAX_VALUE;
        Arrays.sort(num);
        for (int i=0;i<num.length-2;i++){
        	int p=i+1;
        	int q=num.length-1;
        	while (p<q){
				int sum=num[i]+num[p]+num[q];
		    	if (sum==target){
		    		result=sum;
		    		mymin=0;
		    		break;
		    	}
		    	if (sum>target){
		    		if (sum-target<mymin){
		    			mymin=sum-target;
						result=sum;
		    		}
		    		q--;
		    	}
		    	else{
		    		if (target-sum<mymin){
		    			mymin=target-sum;
						result=sum;
		    		}
		    		p++;
		    	}
		    	while (i<num.length-2 && num[i]==num[i+1]){
		    		i++;
		    	}
        	}
        }
    	return result;
    }

	public static void main(String[] args) {
		int[] A={-1,2,1,-4};
		int r=threeSumClosest(A, 1);
		System.out.println(r);

	}

}
