import java.util.Arrays;


public class RemoveDuplicatesfromSortedArray {

	public static int removeDuplicates(int[] A) {
        if(A==null || A.length==0){
        	return 0;
        }
        if(A.length==1){
        	return 1;
        }
        else{
        	Arrays.sort(A);
        	int count=1;
        	for (int i=1;i<A.length;i++){
        		if (A[i]!=A[i-1]){
        			A[count]=A[i];
        			count++;
        		}
        	}
        	return count;
        }
    }
	
	public static void main(String[] args) {
		int[] A={10,3,3,5,23,1,3,15};
		System.out.println(removeDuplicates(A));
	}

}
