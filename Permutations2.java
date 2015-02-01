//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//For example,
//[1,1,2] have the following unique permutations:
//[1,1,2], [1,2,1], and [2,1,1].

import java.util.*;

public class Permutations2 {

	public static List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (num == null || num.length == 0) {return res;}
        Arrays.sort(num);
        check(res, new LinkedList<Integer>(), num, new int[num.length]);
        return res;
    }

    private static void check(List<List<Integer>> res, List<Integer> path, int[] num, int[] visited){
        if (path.size() == num.length) {
        	res.add(new LinkedList<Integer>(path));
            return;
        }
        for (int i = 0; i < num.length; i ++) {
            if (visited[i]==1) {continue;}
            if (i>0 && visited[i-1]==0 && num[i-1]==num[i]) { 
            	// previous not visited, or duplicate number, save time of for-loop
            	continue;
            }
            visited[i]=1;
            path.add(num[i]);
            check(res, path, num, visited);
            visited[i]=0;
            path.remove(path.size()-1);
        }
    }
	
	public static void main(String[] args) {
		int[]A=new int[]{3,3,0,2};
		System.out.println(permuteUnique(A));
	}
}
