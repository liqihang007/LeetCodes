//Given a set of distinct integers, S, return all possible subsets.
//Note:
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
//For example,
//If S = [1,2,3], a solution is:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]

import java.util.*;

public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        subsetsHelper(result, list, num, 0);
        return result;
    }
    
    
    private void subsetsHelper(ArrayList<ArrayList<Integer>> result,
                               ArrayList<Integer> list, int[] num, int pos) {
        result.add(new ArrayList<Integer>(list));
        for (int i = pos; i < num.length; i++) {
            list.add(num[i]);
            subsetsHelper(result, list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }
    
//	public static List<List<Integer>> subsets(int[] S) {
//        List<List<Integer>> set=new ArrayList<>();
//        set.add(new ArrayList<Integer>());
//        if (S.length>=1){
//            Arrays.sort(S);
//        	for(int i=0;i<S.length;i++){
//            	int k=set.size();
//        		for (int j=0;j<k;j++){
//        			List<Integer> temp1 = new ArrayList<Integer>(set.get(j));
//        			temp1.add(S[i]);
//        			set.add(temp1);
//        		}
//        	}
//        }        
//        return set;
//    }
	
	public static void main(String[] args) {
		int[] S=new int[]{1,2,2};
		System.out.println(Arrays.toString(S));
		System.out.println(subsets(S));
	}
}
