//Given a collection of integers that might contain duplicates, S, return all possible subsets.
//Note:
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
//For example,
//If S = [1,2,2], a solution is:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]

import java.util.*;

public class Subsets2 {
    
    public ArrayList<ArrayList<Integer>> subsets(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(num == null || num.length ==0) {
            return result;
        }
        Arrays.sort(num);
        subsetsHelper(result, list, num, 0);
        return result;
    }
    
    private void subsetsHelper(ArrayList<ArrayList<Integer>> result,
                               ArrayList<Integer> list, int[] num, int pos) {
        result.add(new ArrayList<Integer>(list));
        for (int i = pos; i < num.length; i++) {
            if ( i != pos && num[i] == num[i - 1]) {
                continue;
            }
            list.add(num[i]);
            subsetsHelper(result, list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }
    
//	public static List<List<Integer>> subsetsWithDup(int[] num){
//		List<List<Integer>> set=new ArrayList<>();
//        set.add(new ArrayList<Integer>());
//        if (num.length>=1){
//            Arrays.sort(num);
//        	for(int i=0;i<num.length;i++){
//            	int k=set.size();
//        		for (int j=0;j<k;j++){
//        			List<Integer> temp1 = new ArrayList<Integer>(set.get(j));
//        			temp1.add(num[i]);
//        			set.add(temp1);
//        		}
//        	}
//        }
//        HashSet <List<Integer>> hash = new HashSet <List<Integer>>();
//        for(List<Integer> check : set){
//    		hash.add(check);
//        }
//        return new ArrayList<List<Integer>>(hash);
//    }
	
	public static void main(String[] args) {
		int[] S=new int[]{1,2,2};
		System.out.println(Arrays.toString(S));
		System.out.println(subsetsWithDup(S));
	}
}