//Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array 
//such that nums[i] = nums[j] and the difference between i and j is at most k.

import java.util.*;

public class ContainsDuplicate2 {

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k==0 || nums.length<1)
        	return false;
        HashMap<Integer, Integer>map=new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
        	if(!map.containsKey(nums[i]))
        		map.put(nums[i], i);
        	else
        		if(i-map.get(nums[i])<=k)
        			return true;
        		else
        			map.put(nums[i], i);
        }
        return false;
    }

	public static void main(String[] args) {
		System.out.println(containsNearbyDuplicate(new int[]{99,99},2));
	}

}
