//Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 times.
//You may assume that the array is non-empty and the majority element always exist in the array.

import java.util.*;

public class MajorityElement {

	public static int majorityElement(int[] num) {
	    int maj=0, count = 1;
	    for(int i=1; i<num.length; i++){
	        if(num[maj]==num[i])
	            count++;
	        else
	            count--;
	        if(count == 0){
	            maj=i;
	            count=1;
	        }
	    }
	    return num[maj];
	}
	
//	public static int majorityElement(int[] num) {
//        int myreturn=0;
//        HashMap<Integer, Integer> set = new HashMap<Integer,Integer>();
//        for (int i=0;i<num.length;i++){
//        	if (set.containsKey(num[i])){
//        		set.put(num[i], set.get(num[i])+1);
//        	}
//        	else{
//        		set.put(num[i],1);
//        	}
//        }
//        int maxnum=Collections.max(set.values());
//        for (Map.Entry<Integer, Integer> entry : set.entrySet()){
//        	if (entry.getValue()==maxnum){
//        		myreturn = entry.getKey();
//        	}
//        }
//        return myreturn;
//    }
	
	public static void main(String[] args) {
		System.out.println(majorityElement(new int[]{1,2,3,4,3,2,3,3,1,3,3,3}));

	}

}
