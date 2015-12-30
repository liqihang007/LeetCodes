//Given an array of integers, find if the array contains any duplicates. 
//Your function should return true if any value appears at least twice in the array, 
//and it should return false if every element is distinct.

import java.util.*;

public class ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {
        HashSet <Integer> set = new HashSet<Integer>();
        for(int i : nums){
        	if(set.contains(i))
        		return true;
        	else
        		set.add(i);
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
