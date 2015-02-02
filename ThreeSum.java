//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
//Find all unique triplets in the array which gives the sum of zero.
//Note:
//Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <= c)
//The solution set must not contain duplicate triplets.
//    For example, given array S = {-1 0 1 2 -1 -4},
//    A solution set is:
//    (-1, 0, 1)
//    (-1, -1, 2)

import java.util.*;

public class ThreeSum {

	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		Set<ArrayList<Integer>> set=new HashSet<ArrayList<Integer>>();
		Arrays.sort(num);
		for (int i=0;i<num.length-2;i++){
			int a=i+1;
			int b=num.length-1;
			while(b>a){
				if (num[a]+num[b]==-num[i]){
					ArrayList<Integer> answers=new ArrayList<Integer>();
					answers.add(num[i]);
					answers.add(num[a]);
					answers.add(num[b]);
					set.add(answers);
					b--;
					a++;
				}
				else{
					if (num[a]+num[b]>-num[i]){
						b--;
					}
					else{
						a++;
					}
				}
			}
		}
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(set);
		return res;
	}

	public static void main(String[] args) {
//		int[] A={0,2,-1,-5,3,9,5,23,0,1,-3};
//		int[] A={3,0,-2,-1,1,2};
		int[] A={-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
//		int[] A={0,0,0,0};
//		int[] A=null;
//		int[] A={0};
		ArrayList<ArrayList<Integer>> test=threeSum(A);
		for (int i=0;i<test.size();i++){
			ArrayList<Integer> subtest=test.get(i);
			int[] show = new int[subtest.size()];
			for (int j=0;j<subtest.size();j++){
				show[j]=subtest.get(j);
			}
			System.out.println(Arrays.toString(show));	
		}
	}
}
