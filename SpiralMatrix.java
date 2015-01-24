import java.util.*;

public class SpiralMatrix {

	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> myreturn=new ArrayList<Integer>();
        HashSet<Integer> used=new HashSet<Integer>();
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
        	return myreturn;
        }
        int i=0,j=0;
        boolean check=true;
        int dic=1;
        while(check){
        	if(dic>4){dic=1;}
        	if (used.contains(i*matrix[0].length+j) || j<0 || j>matrix[0].length-1
        			|| i<0 || i>matrix.length-1){
        		check=false;
        		break;
        	}
        	else{
	        	used.add(i*matrix[0].length+j);
	    		myreturn.add(matrix[i][j]);
	    		if(dic==1){
	    			j++;
	    			if(used.contains(i*matrix[0].length+j) || j>matrix[0].length-1){
	    				j--;i++;
	    				dic++;
	    			}
	    		}
	    		else{
	    			if(dic==2){
	        			i++;
	        			if(used.contains(i*matrix[0].length+j) || i>matrix.length-1){
	        				i--;j--;
	        				dic++;
	        			}
	        		}
	    			else{
	    				if(dic==3){
	            			j--;
	            			if(used.contains(i*matrix[0].length+j) || j<0){
	            				j++;i--;
	            				dic++;
	            			}
	            		}
	    				else{
                			i--;
                			if(used.contains(i*matrix[0].length+j) || i<0){
                				i++;j++;
                				dic++;
                			}
                		}
	    			}
        		}
        	}
        }
        return myreturn;
    }

	public static void main(String[] args) {
//		int [][] A= new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//		int [][] A= new int[][]{{1,2,3}};
//		int [][] A= new int[][]{{1},{2},{3}};
		int [][] A=null;

		for(int i=0;i<A.length;i++){
			System.out.println(Arrays.toString(A[i]));
		}
		System.out.println(spiralOrder(A));
	}
}
