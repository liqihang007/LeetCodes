
public class TrappingRainWater {


	public static int trap(int[] A) {
        int myreturn=0;
        if (A!=null && A.length>=3){
        	int [] highL=new int[A.length];
        	int [] highR=new int[A.length];
        	highL[0]=A[0];
        	highR[A.length-1]=A[A.length-1];
        	for (int i=1;i<A.length;i++){
        		highL[i]=Math.max(A[i],highL[i-1]);
        	}
        	for (int i=A.length-2;i>=0;i--){
        		highR[i]=Math.max(A[i],highR[i+1]);
        	}
        	for (int i=1;i<A.length-1;i++){
        		if (highL[i]>A[i] && highR[i]>A[i]){
        			myreturn+=Math.min(highL[i],highR[i])-A[i];
        		}
        	}
        }
        return myreturn;
    }

	public static void main(String[] args) {
		int[] A=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(A));
	}

}
