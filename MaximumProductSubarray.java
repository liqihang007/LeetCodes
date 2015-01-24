
public class MaximumProductSubarray {
	public static int maxProduct(int[] A) {
		int res=0;
		if (A.length>=1){
			res=A[0];
			int max=A[0], min=A[0];
			for (int i=1;i<A.length;i++){
				int temp = max;
				max=Math.max(A[i],Math.max(max*A[i],min*A[i])); // for +
				min=Math.min(A[i],Math.min(temp*A[i],min*A[i])); // for -
				if (max>res){res=max;}
			}
		}
		return res;
	}
	
//	public static int maxProduct(int[] A) {
//		int max1=0,max2=0;
//		if (A.length>=1){
//			max1=A[0];
//			int temp=A[0];
//			for(int i=1;i<A.length;i++){
//				if(temp==0){
//					temp=A[i];
//				}
//				else{
//					temp=temp*A[i];
//				}
//				if(temp>max1){max1=temp;}
//			}
//			max2=A[A.length-1];
//			temp=A[A.length-1];
//			for(int i=A.length-2;i>=0;i--){
//				if(temp==0){
//					temp=A[i];
//				}
//				else{
//					temp=temp*A[i];
//				}
//				if(temp>max2){max2=temp;}
//			}
//			
//		}
//		return Math.max(max1,max2);
//    }
	
	public static void main(String[] args) {
		int A[]=new int[]{2,3,-2,4,-3,-1,2};
		System.out.println(maxProduct(A));
	}

}
