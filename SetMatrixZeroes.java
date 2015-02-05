//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

import java.util.*;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0){return;}
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean empty_row0 = false;
        boolean empty_col0 = false;
        for(int i = 0; i < cols; i++){
            if(matrix[0][i] == 0){
                empty_row0 = true;
                break;
            }
        }
        for(int i = 0; i < rows; i++){
            if(matrix[i][0] == 0){
                empty_col0 = true;
                break;
            }
        }
        for(int i = 1; i < rows; i++) {
            for(int j =1; j<cols; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i<rows; i++) {
            for (int j=1; j< cols; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }
        if(empty_row0){
            for(int i = 0; i < cols; i++){
                matrix[0][i] = 0;
            }
        }
        if(empty_col0){
            for(int i = 0; i < rows; i++){
                matrix[i][0] = 0;
            }
        }
    }
    
//	public static void setZeroes(int[][] matrix) {
//        int diag=Math.min(matrix.length,matrix[0].length);
//        List<Integer> row=new ArrayList<Integer>();
//        List<Integer> col=new ArrayList<Integer>();
//
//        for(int d=0;d<diag;d++){
//        	for(int i=d;i<matrix.length;i++){
//        		if (matrix[i][d]==0){
//        			row.add(i);
//        			col.add(d);
//        		}
//        	}
//        	for(int j=d;j<matrix[0].length;j++){
//        		if (matrix[d][j]==0){
//        			col.add(j);
//        			row.add(d);
//        		}
//        	}
//        }
//        for (int i=0;i<row.size();i++){
//        	int x=row.get(i);
//        	int y=col.get(i);
//        	for (int j=0;j<matrix[0].length;j++){
//        		matrix[x][j]=0;
//        	}
//        	for (int j=0;j<matrix.length;j++){
//        		matrix[j][y]=0;
//        	}
//        }
//    }
	
	public static void main(String[] args) {
		int [][] A= new int[][]{{1,2,3,4},{0,4,5,6},{2,7,0,9},{1,2,3,4},{1,2,3,0}};
		for(int i=0;i<A.length;i++){
			System.out.println(Arrays.toString(A[i]));
		}
		setZeroes(A);
		System.out.println("");
		for(int i=0;i<A.length;i++){
			System.out.println(Arrays.toString(A[i]));
		}

	}

}
