//Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//Find the minimum element.
//You may assume no duplicate exists in the array.

public class FindMinimuminRotatedSortedArray {

//	public static int findMin(int[] num) {
//		int myreturn=num[0];
//        if (num.length>1){
//        	for (int i=1;i<num.length;i++){
//	        	if (num[i]<num[i-1]){
//	        		return num[i];
//	        	}
//        	}
//        }
//        return myreturn;
//    }
//	

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
				int mid=(i+j)/2;
				if (num[i]<=num[mid] && num[mid+1]<=num[j]){
					myreturn=Math.min(num[i], num[mid+1]);
				}
				else{
					if(num[i]>num[mid]){
						myreturn=checkmin(num, i,mid);
					}
					else{
						myreturn=checkmin(num, mid+1,j);
					}
				}
			}
		}
		return myreturn;
	}
	
	public static void main(String[] args) {
		System.out.println(findMin(new int[]{1,2,3}));
	}

}
