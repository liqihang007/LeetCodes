//You are a professional robber planning to rob houses along a street. 
//Each house has a certain amount of money stashed, the only constraint stopping you from 
//robbing each of them is that adjacent houses have security system connected and it will 
//automatically contact the police if two adjacent houses were broken into on the same night.
//Given a list of non-negative integers representing the amount of money of each house, 
//determine the maximum amount of money you can rob tonight without alerting the police.

import java.util.*;

public class HouseRobber {

	public static int rob(int[] nums) {
        int tmp1=0, tmp2=0, tmp3=0, res=0;
        for (int i=0;i<nums.length;i++){
        	int tmp=Math.max(tmp1+nums[i], tmp2+nums[i]);
        	tmp1=tmp2;
        	tmp2=tmp3;
        	tmp3=tmp;
        	res=Math.max(res, tmp);
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.println(rob(new int[]{2,1,1,2}));
	}

}
