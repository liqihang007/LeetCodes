import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeSumClosest {

	public static int threeSumClosest(int[] num, int target) {
        int result=0;
        int mymin=Integer.MAX_VALUE;
        Arrays.sort(num);
        for (int i=0;i<num.length-2;i++){
        	int p=i+1;
        	int q=num.length-1;
        	while (p<q){
				int sum=num[i]+num[p]+num[q];
		    	if (sum==target){
		    		result=sum;
		    		mymin=0;
//		    		System.out.println(i+" "+p+" "+q+" -1");
		    		break;
		    	}
		    	if (sum>target){
		    		if (sum-target<mymin){
		    			mymin=sum-target;
						result=sum;
//						System.out.println(i+" "+p+" "+q+" -2");
		    		}
		    		q--;
		    	}
		    	else{
		    		if (target-sum<mymin){
		    			mymin=target-sum;
						result=sum;
//						System.out.println(i+" "+p+" "+q+" -3");
		    		}
		    		p++;
		    	}
		    	while (i<num.length-2 && num[i]==num[i+1]){
		    		i++;
		    	}
        	}
        }
    	return result;
    }

	public static void main(String[] args) {
		int[] A={-1,2,1,-4};
		int r=threeSumClosest(A, 1);
		System.out.println(r);

	}

}
