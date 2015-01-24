

public class SearchInsertPosition {
	public static int searchInsert(int[] A, int target) {
		if (A==null || A.length==0){
			return 0;
		}
		else{
			int i=0;
			while(i<A.length){
				if(A[i]<target){
					i++;
				}
				else{
					return i;
				}
			}
			return i;
		} 
    }
	
	public static void main(String[] args) {
		int[] A=new int[]{1,3,5,6};
		System.out.println(searchInsert(A,5));
		System.out.println(searchInsert(A,2));
		System.out.println(searchInsert(A,7));
		System.out.println(searchInsert(A,0));
	}

}
