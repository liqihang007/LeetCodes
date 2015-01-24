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
		if(k>=1){
        	for(int i=1;i<=n;i++){
        		List<Integer> temp = new ArrayList<Integer>();
        		temp.add(i);
        		res.add(temp);
        	}
        	for(int j=2;j<=k;j++){
        		List<List<Integer>>res2 = new ArrayList<List<Integer>>();
        		for(int i=0;i<res.size();i++){        			
        			int begin=res.get(i).get(res.get(i).size()-1)+1;
        			for(int p=begin;p<=n;p++){
        				List<Integer> temp=new ArrayList<Integer>(res.get(i));
        				temp.add(p);
        				res2.add(temp);
        			}
        		}
        		res=res2;
        	}
        }
		return res;
    }
	
	public static void main(String[] args) {
		System.out.println(combine(5,3));
	}

}
