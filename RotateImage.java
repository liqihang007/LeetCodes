//You are given an n x n 2D matrix representing an image.
//Rotate the image by 90 degrees (clockwise).

import java.util.*;

public class RotateImage {

	public static void rotate(int[][] matrix) {
        if (matrix.length>1){
        	int k=matrix.length;
        	if(k%2==0){ // even
        		for(int i=0;i<k/2;i++){
        			for (int j=0;j<k/2;j++){
        				int temp=matrix[i][j];
        				matrix[i][j]=matrix[matrix.length-1-j][i];
        				matrix[matrix.length-1-j][i]=matrix[matrix.length-1-i][matrix.length-1-j];
        				matrix[matrix.length-1-i][matrix.length-1-j]=matrix[j][matrix.length-1-i];
        				matrix[j][matrix.length-1-i]=temp;
        			}
        		}
        	}
        	else{ // odd
        		for(int i=0;i<(k-1)/2;i++){
        			for (int j=0;j<(k+1)/2;j++){
        				int temp=matrix[i][j];
        				matrix[i][j]=matrix[matrix.length-1-j][i];
        				matrix[matrix.length-1-j][i]=matrix[matrix.length-1-i][matrix.length-1-j];
        				matrix[matrix.length-1-i][matrix.length-1-j]=matrix[j][matrix.length-1-i];
        				matrix[j][matrix.length-1-i]=temp;
        			}
        		}
        		
        	}
        }
    }
	
	public static void main(String[] args) {
		int[][]A=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		rotate(A);
		System.out.println(Arrays.toString(A[0]));
		System.out.println(Arrays.toString(A[1]));
		System.out.println(Arrays.toString(A[2]));
//		System.out.println(Arrays.toString(A[3]));
	}

}
