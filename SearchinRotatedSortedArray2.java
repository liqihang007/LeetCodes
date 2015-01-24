
public class SearchinRotatedSortedArray2 {

	public static boolean search(int[] A, int target) {
		if (A==null || A.length==0){
        	return false;
        }
        return searchnum(A,0,A.length-1,target);
    }
	
	public static boolean searchnum(int[] A,int i, int j,int tar){
		if(i>j){
			return false;
		}
		if (i==j){
			if(A[i]==tar){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			int mid=(int)((i+j)/2);
			return searchnum(A,i,mid,tar) || searchnum(A,mid+1,j,tar);
		}
	}
	
	public static void main(String[] args) {
		int[]A=new int[]{1,1,3,1};
		System.out.println(search(A,3));
	}

}
