//Given a sorted integer array without duplicates, return the summary of its ranges.
//For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

import java.util.*;

public class SummaryRanges {

	public static List<String> summaryRanges(int[] nums) {
		List<String> res=new ArrayList<String>();
		if(nums.length==0) return res;
		if(nums.length==1){
			res.add(""+nums[0]);
			return res;
		}
		int i=0, j=0;
		for(j=0;j<nums.length-1;j++){
			if(nums[j+1]>nums[j]+1){
				if(i==j){
					res.add(""+nums[i]);
					i=j+1;
				}
				else{
					res.add(nums[i]+"->"+nums[j]);
					i=j+1;
				}
			}
		}
		if(i==nums.length-1){
			res.add(""+nums[nums.length-1]);
		}
		else{
			res.add(nums[i]+"->"+nums[nums.length-1]);
		}
		return res;
    }

	public static void main(String[] args) {
		System.out.println(summaryRanges(new int[]{1,2}));
		System.out.println(summaryRanges(new int[]{1,3}));
		System.out.println(summaryRanges(new int[]{0,1,2,4,5,7}));
	}

}
