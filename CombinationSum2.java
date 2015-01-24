import java.util.*;


public class CombinationSum2 {

	public static List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result =new ArrayList<>();
        if (num!=null && num.length>0){
        	Arrays.sort(num);
        	findcomb(result, 0,num, target, new ArrayList<Integer>());
        }
        return result;
    }
	
	public static void findcomb(List<List<Integer>> result, int k, int[] num, int target, ArrayList<Integer> mylist){
		if (target<0 || num.length<=0){
			return;
		}
		if (target==0 && num.length>=0){
			result.add(new ArrayList<Integer>(mylist));
			return;
		}
		if (target>0){
			for (int j=k;j<num.length;j++){
				if (j>k && num[j]==num[j-1]){
					continue;
				}
				mylist.add(num[j]);
				findcomb(result, j+1, num, target-num[j], mylist);
				mylist.remove(mylist.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
//		int[] A={3,5,4,3,4};
		int[] A={1,1};
		System.out.println(combinationSum2(A,1));
		
	}

}
