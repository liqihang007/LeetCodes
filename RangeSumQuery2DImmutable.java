//Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined 
//by its upper left corner (row1, col1) and lower right corner (row2, col2).
//Example:
//Given matrix = [
//  [3, 0, 1, 4, 2],
//  [5, 6, 3, 2, 1],
//  [1, 2, 0, 1, 5],
//  [4, 1, 0, 1, 7],
//  [1, 0, 3, 0, 5]
//]
//sumRegion(2, 1, 4, 3) -> 8
//sumRegion(1, 1, 2, 2) -> 11
//sumRegion(1, 2, 2, 4) -> 12
//Note:
//You may assume that the matrix does not change.
//There are many calls to sumRegion function.
//You may assume that row1 <= row2 and col1 <= col2.

import java.util.*;

public class RangeSumQuery2DImmutable {

	int [][] sums;
			
	public NumMatrix(int[][] matrix) {
		if (matrix==null || matrix.length == 0 || matrix[0].length == 0)
	        return;
		sums=new int[matrix.length+1][matrix[0].length+1];
        for(int i=1; i<=matrix.length; i++){
        	for(int j=1; j<=matrix[0].length; j++){
        		sums[i][j]=sums[i-1][j]+sums[i][j-1]-sums[i-1][j-1]+matrix[i-1][j-1];
        	}
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
    	if (sums == null)
            return 0;
        if (++row2 > sums.length)
            row2 = sums.length;
        if (++col2 > sums[0].length)
            col2 = sums[0].length;
        return sums[row2][col2] - sums[row2][col1] - sums[row1][col2] + sums[row1][col1];
    }
    
 // Your NumMatrix object will be instantiated and called as such:
 // NumMatrix numMatrix = new NumMatrix(matrix);
 // numMatrix.sumRegion(0, 1, 2, 3);
 // numMatrix.sumRegion(1, 2, 3, 4);
    
}
