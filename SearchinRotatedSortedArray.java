
public class SearchinRotatedSortedArray {

	public static int search(int[] A, int target) {
        if (A==null || A.length==0){
        	return -1;
        }
        return searchnum(A,0,A.length-1,target);
    }
	
	public static int searchnum(int[] A,int i, int j,int tar){
		if(i>j){
			return -1;
		}
		if (i==j){
			if(A[i]==tar){
				return i;
			}
			else{
				return -1;
			}
		}
		else{
			int mid=(int)((i+j)/2);
			if(A[i]<A[mid]){
				if(A[i]<=tar && tar<=A[mid]){
					return searchnum(A,i,mid,tar);
				}
				else{
					return searchnum(A,mid+1,j,tar);
				}
			}
			else{
				if(A[mid+1]<=tar && tar<=A[j]){
					return searchnum(A,mid+1,j,tar);
				}
				else{
					
					return searchnum(A,i,mid,tar);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[]A=new int[]{4,5,6,7,0,1,2};
		System.out.println(search(A,3));

	}

}
