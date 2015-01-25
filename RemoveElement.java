//Given an array and a value, remove all instances of that value in place and return the new length.
//The order of elements can be changed. It doesn't matter what you leave beyond the new length.

public class RemoveElement {

public static int removeElement(int[] A, int elem) {
        if(A.length==0 || A==null){
        	return 0;
        }
        if (A.length==1){
        	if (A[0]==elem){
        		return 0;
        	}
        	else{
        		return 1;
        	}
        }
        else{
        	int myreturn=A.length;
        	int count=0;
        	for (int i=0;i<A.length;i++){
        		if (A[i]==elem){
        			myreturn--;
        		}
        		else{
        			A[count]=A[i];
        			count++;
        		}
        	}
        	return myreturn;
        }
    }

	public static void main(String[] args) {
//		int[] A={10,3,3,5,23,1,3,15};
		int[] A={1};
		System.out.println(removeElement(A,1));

	}

}
