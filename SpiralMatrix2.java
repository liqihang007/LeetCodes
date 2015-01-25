//Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//For example,
//Given n = 3,
//You should return the following matrix:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]

import java.util.*;

public class SpiralMatrix2 {

	public static int[][] generateMatrix(int n) {
        if(n==0){
        	return (new int[0][0]);
        }
        HashSet<Integer> used=new HashSet<Integer>();
    	int[][]A=new int[n][n];
    	int dic=1;
    	int check=1;
    	int i=0, j=0;
    	while(check<=n*n){
    		if(dic>4){dic=1;}
    		used.add(i*n+j);
    		A[i][j]=check;
    		check++;
    		if(dic==1){
    			j++;
    			if(used.contains(i*n+j) || j==n){
    				j--;i++;dic++;
    			}
    		}
    		else{
    			if(dic==2){
        			i++;
        			if(used.contains(i*n+j) || i==n){
        				i--;j--;dic++;
        			}
        		}
    			else{
    				if(dic==3){
    	    			j--;
    	    			if(used.contains(i*n+j) || i<0){
    	    				j++;i--;dic++;
    	    			}
    	    		}
    				else{
    					i--;
		    			if(used.contains(i*n+j) || j<0){
		    				i++;j++;dic++;
    		    		}
    				}
    			}
    		}
    	}
    	return A;
    }
	
	public static void main(String[] args) {
		int [][] A=generateMatrix(3);
		for(int i=0;i<A.length;i++){
			System.out.println(Arrays.toString(A[i]));
		}
	}

}
