//Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. 
//What is the longest length you can get from the n pieces of wood? 
//Given L & k, return the maximum length of the small pieces.
//Note
//You couldn't cut wood into float length.
//Example
//For L=[232, 124, 456], k=7, return 114.
//Challenge
//O(n log Len), where Len is the longest length of the wood.

public class WoodCut {

	public static int woodCut(int[] L, int k) {
        if(L==null || L.length==0 || k==0) return 0;
        int low=1,high=0,tmp=0;
        for(int i:L)
        	high=Math.max(i, high);
        int res=0;
        while(low<=high){
        	int mid=low+(high-low)/2;
        	tmp=0;
        	for(int i:L)
        		tmp+=i/mid;
        	if(tmp<k){
        		high=mid-1;
        	}else{
        		res=mid;
        		low=mid+1;
        	}        	
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[]A=new int[]{51,8477,6344,6510,9179,5734,1488,9368,6972,4474,5715,8155,3291,6837,9971,501,3005,1952,4837,5446,2401,4614,3912,163,302,2392,7431,8726,9728,9905};
		System.out.println(woodCut(A,10));
	}

}
