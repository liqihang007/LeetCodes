
public class FindMinimuminRotatedSortedArray2 {

	public static int findMin(int[] num) {
		int myreturn=num[0];
        if (num.length>1){
        	myreturn = checkmin(num,0,num.length-1);
        }
        return myreturn;
    }
	
	public static int checkmin(int[] num, int i, int j){
		int myreturn=-1;
		if(i==j){
			myreturn=num[i];
		}
		else{
			if(i==j-1){
				myreturn=Math.min(num[i],num[j]);
			}
			else{
				int mid=(int)((int)(i+j)/2);
				myreturn=Math.min(checkmin(num, i,mid),checkmin(num, mid+1,j));	
			}
		}
		return myreturn;
	}
	
	public static void main(String[] args) {
		System.out.println(findMin(new int[]{10,1,10,10,10}));
	}

}
