//Given a collection of numbers, return all possible permutations.
//For example,
//[1,2,3] have the following permutations:
//[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

import java.util.*;

public class Permutations {

	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>>res= new ArrayList<List<Integer>>();
		if(num==null || num.length==0){return res;}
		Arrays.sort(num);
		fillres(res, new ArrayList<Integer>(), num);
		return res;
    }
	
	public void fillres(List<List<Integer>>res, List<Integer> list, int[] num){
		if(list.size()==num.length){
			res.add(new ArrayList<Integer>(list));
		}
		for(int i=0;i<num.length;i++){
			if(!list.contains(num[i])){
				list.add(num[i]);
				fillres(res,list,num);
				list.remove(list.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}
