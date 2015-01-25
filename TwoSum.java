//Given an array of integers, find two numbers such that they add up to a specific target number.
//The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
//Please note that your returned answers (both index1 and index2) are not zero-based.
//You may assume that each input would have exactly one solution.
//Input: numbers={2, 7, 11, 15}, target=9
//Output: index1=1, index2=2

import java.util.*;

public class TwoSum {
	
	public static int[] twoSum(int[] numbers, int target) {
		int [] results=new int[2];
		HashMap<Integer, Integer> hash= new HashMap<Integer, Integer>();
		for (int i=0;i<numbers.length;i++){
			
			int key=target-numbers[i];
			if (hash.containsKey(key)){
				int x=hash.get(key)+1;
				int y=i+1;
				if (x>y){
					int temp=x;
					x=y;
					y=temp;
				}
				results[0]=x;
				results[1]=y;
				return results;
			}
			else{
				hash.put(numbers[i], i);
			}
		}
		return results;
    }

	public static void main(String[] args) {
		int[] A= new int[] {150,24,79,50,88,345,2};
		System.out.println(Arrays.toString(twoSum(A, 200)));
	}

}
