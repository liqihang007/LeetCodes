//Given an array of integers, every element appears twice except for one. Find that single one.

public class SingleNumber {

	public int singleNumber(int[] A) {
        int res=0;
        for(int i=0;i<A.length;i++){
        	res=res^A[i];
        }
        return res;
    }
	public static void main(String[] args) {
		
	}

}
