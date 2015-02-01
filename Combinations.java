//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//For example,
//If n = 4 and k = 2, a solution is:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]

import java.util.*;

public class Combinations {

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>>res = new ArrayList<List<Integer>>();
		if(n==0 || k==0 || n<k){return res;}
		check(res, new ArrayList<Integer>(),n,k,1);
		return res;
    }
	
	public static void check(List<List<Integer>>res, List<Integer>list, int n, int k, int pos){
		if(list.size()==k){
			res.add(list);
			return;
		}
		for(int i=pos;i<=n;i++){
			list.add(i);
			check(res,list,n,k,pos+1);
			list.remove(list.size()-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(combine(5,3));
	}

}
