//Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//You may assume no duplicates in the array.
//Here are few examples.
//[1,3,5,6], 5 -> 2
//[1,3,5,6], 2 -> 1
//[1,3,5,6], 7 -> 4
//[1,3,5,6], 0 -> 0

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
