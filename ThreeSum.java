import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class ThreeSum {

	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		Set<ArrayList<Integer>> set=new HashSet<ArrayList<Integer>>();
		Arrays.sort(num);
		for (int i=0;i<num.length;i++){
			set=findanswer(set,num,i,i+1,num.length-1);
		}
		ArrayList<ArrayList<Integer>> myreturn = new ArrayList<ArrayList<Integer>>(set);
		return myreturn;
    }
	
	public static Set<ArrayList<Integer>> findanswer(Set<ArrayList<Integer>> list, int[] A, int i, int a, int b)
	{
		if (A.length>=3 && b>a){
			ArrayList<Integer> answers=new ArrayList<Integer>();
			if (A[a]+A[b]==-A[i]){
				int[] temp={A[a],A[i],A[b]};
				Arrays.sort(temp);
				answers.add(temp[0]);
				answers.add(temp[1]);
				answers.add(temp[2]);
				list.add(answers);
				list=findanswer(list, A, i, a+1, b-1);
			}
			else{
				if (A[a]+A[b]>-A[i]){
					list=findanswer(list, A, i, a, b-1);
				}
				else{
					list=findanswer(list, A, i, a+1, b);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
//		int[] A={0,2,-1,-5,3,9,5,23,0,1,-3};
//		int[] A={3,0,-2,-1,1,2};
//		int[] A={-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		int[] A={0,0,0,0};
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
