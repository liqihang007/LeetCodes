//Given an array of integers, find out whether there are two distinct indices i and j in the array such that 
//the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.

import java.util.*;

/*The idea is like the bucket sort algorithm. 
Suppose we have consecutive buckets covering the range of nums with each bucket a width of (t+1). 
If there are two item with difference <= t, one of the two will happen:
(1) the two in the same bucket
(2) the two in neighbor buckets
Note that we do not need to actually allocate a lot of buckets. 
At any time there will only be at most min(k, n) buckets. 
All we need to do is calculate the label of the bucket m = value/(t+1), and check the buckets m - 1, m, m + 1. 
The whole algorithm is then O(n).*/
public class ContainsDuplicate3 {
	
	private int getID(int i, int t) { // get id of bucket where contains the i
	    return i<0 ? (i+1)/t-1 : i/t;
	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	    if (t<0) return false;
	    int n=nums.length;
	    Map<Integer, Integer> map = new HashMap<>();
	    t++;
	    for (int i=0; i<n; i++) { // sort nums into t buckets, nums[i] in the same bucket meet diff<=t
	        if (i>k) 
	        	map.remove(getID(nums[i - k - 1], t));
	        int m = getID(nums[i], t);
	        if (map.containsKey(m)) 
	        	return true;
	        if (map.containsKey(m - 1) && Math.abs(nums[i] - map.get(m - 1)) < t) 
	        	return true;
	        if (map.containsKey(m + 1) && Math.abs(nums[i] - map.get(m + 1)) < t) 
	        	return true;
	        map.put(m, nums[i]);
	    }
	    return false;
	}
}

