import java.util.Arrays;


public class SearchforaRange {

	public static int[] searchRange(int[] A, int target) {
        int[] myreturn=new int[]{-1,-1};
        myreturn[0]=searchstart(A,target,0,A.length-1);
        myreturn[1]=searchend(A,target,0,A.length-1);
        return myreturn;
    }
	
	public static int searchstart(int[]A,int tar, int i,int j){
		int in=-1;
		if(i<=j){
			if(i==j){
				if(A[i]==tar){in=i;}
			}
			else{
				if(i==j-1){
					if(A[i]==tar){in= i;}
					else{
						if(A[j]==tar){in=j;}
					}
				}
				else{
					int mid=(int)(i+j)/2;
					if (A[mid]>=tar){
						in=searchstart(A,tar,i,mid);
					}
					else{
						in=searchstart(A,tar, mid+1,j);
					}
				}
			}
		}
		return in;
	}
	
	public static int searchend(int[]A,int tar, int i,int j){
		int in=-1;
		if(i<=j){
			if(i==j){
				if(A[i]==tar){in= i;}
			}
			else{
				if(i==j-1){
					if(A[j]==tar){in= j;}
					else{
						if(A[i]==tar){in= i;}
						}
				}
				else{
					int mid=(int)(i+j)/2;
					if (A[mid]<=tar){
						in= searchend(A,tar, mid,j);
					}
					else{
						in= searchend(A,tar,i,mid-1);
					}
				}
			}
		}
		return in;
	}
	
	public static void main(String[] args) {
		int[]A=new int[]{8, 8};
		System.out.println(Arrays.toString(searchRange(A,1)));
	}

}
