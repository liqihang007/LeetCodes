//Find all possible combinations of k numbers that add up to a number n, given that only numbers 
//from 1 to 9 can be used and each combination should be a unique set of numbers.
//Ensure that numbers within the set are sorted in ascending order.
//Example 1:
//Input: k = 3, n = 7
//Output:
//[[1,2,4]]
//Example 2:
//Input: k = 3, n = 9
//Output:
//[[1,2,6], [1,3,5], [2,3,4]]

import java.util.*;

public class CombinationSum4 {
	
	public static List<List<Integer>> combinationSum4(int k, int n) {
        List<List<Integer>>res=new ArrayList<>();
        if(n==0 || k==0){return res;}
        help(res, new ArrayList<Integer>(), n, k, 1);
        return res;
    }
	
	public static void help(List<List<Integer>>res, List<Integer>list, int n, int k, int pos){
		if(list.size()==k && n==0){
			res.add(new ArrayList<Integer>(list));
			return;
		}
		if(list.size()>k || n<0 || pos>9){
			return;
		}
		for(int i=pos; i<=9; i++){
			list.add(i);
			help(res, list, n-i, k, i+1);
			list.remove(list.size()-1);
		}
	}

	public static void main(String[] args) {
		System.out.println(combinationSum4(3,9));
		System.out.println(combinationSum4(3,7));
	}
}
