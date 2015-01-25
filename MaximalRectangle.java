//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

public class MaximalRectangle {

//The DP solution proceeds row by row, starting from the first row. 
//Let the maximal rectangle area at row i and column j be computed by [right(i,j) - left(i,j)]*height(i,j).
//All the 3 variables left, right, and height can be determined by the information from previous row, and also information from the current row. 
//So it can be regarded as a DP solution. 
//height counts the number of successive '1's above (plus the current one). 
//The value of left & right means the boundaries of the rectangle which contains the current point with a height of value height.
//The transition equations are:
//left(i,j) = max(left(i-1,j), curleft), curleft can be determined from the current row
//right(i,j) = min(right(i-1,j), curright), curright can be determined from the current row
//height(i,j) = height(i-1,j) + 1, if matrix[i][j]=='1';
//height(i,j) = 0, if matrix[i][j]=='0'
//The code is as below. The loops can be combined for speed but I separate them for more clarity of the algorithm.
	
	public static int maximalRectangle(char[][] matrix) {
        
    }
	
	public static void main(String[] args) {
		
	}
}
