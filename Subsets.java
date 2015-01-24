import java.util.*;

public class Subsets {
	public static List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> set=new ArrayList<>();
        set.add(new ArrayList<Integer>());
        if (S.length>=1){
            Arrays.sort(S);
        	for(int i=0;i<S.length;i++){
            	int k=set.size();
        		for (int j=0;j<k;j++){
        			List<Integer> temp1 = new ArrayList<Integer>(set.get(j));
        			temp1.add(S[i]);
        			set.add(temp1);
        		}
        	}
        }        
        return set;
    }
	
	public static void main(String[] args) {
		int[] S=new int[]{1,2,2};
		System.out.println(Arrays.toString(S));
		System.out.println(subsets(S));
	}
}
