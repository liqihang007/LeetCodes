//Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
//Find all unique quadruplets in the array which gives the sum of target.
//Note:
//Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a <= b <= c <= d)
//The solution set must not contain duplicate quadruplets.
//    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
//    A solution set is:
//    (-1,  0, 0, 1)
//    (-2, -1, 1, 2)
//    (-2,  0, 0, 2)

import java.util.*;
    
public class FourSum {

	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> res= new ArrayList<List<Integer>>();
		if(num.length<4) return res;
		Arrays.sort(num);
		for(int i=0;i<num.length-3;i++){
			if(i>0 && num[i]==num[i-1])
				continue;
			for(int j=i+1;j<num.length-2;j++){
				if(j>i+1 && num[j]==num[j-1])
					continue;
				int a=j+1, b=num.length-1;
				while(a<b){
					int sum=num[i]+num[j]+num[a]+num[b];
					if(sum==target){
						List<Integer> list=new ArrayList<Integer>();
						list.add(num[i]);
						list.add(num[j]);
						list.add(num[a]);
						list.add(num[b]);
						res.add(list);
						b--;
						a++;
						while(a<b && num[a]==num[a-1])
							a++;
						while(a<b && num[b]==num[b+1])
							b--;
					}else if(sum>target)
						b--;
					else
						a++;
				}
			}
		}
		return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
