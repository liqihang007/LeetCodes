//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

/*
The DP solution proceeds row by row, starting from the first row. 
Let the maximal rectangle area at row i and column j be computed by [right(i,j) - left(i,j)]*height(i,j).
All the 3 variables left, right, and height can be determined by the information from previous row, and also information from the current row. 
So it can be regarded as a DP solution. 
height counts the number of successive '1's above (plus the current one). 
The value of left & right means the boundaries of the rectangle which contains the current point with a height of value height.
The transition equations are:
left(i,j) = max(left(i-1,j), curleft), curleft can be determined from the current row
right(i,j) = min(right(i-1,j), curright), curright can be determined from the current row
height(i,j) = height(i-1,j) + 1, if matrix[i][j]=='1';
height(i,j) = 0, if matrix[i][j]=='0'
The code is as below. The loops can be combined for speed but I separate them for more clarity of the algorithm.
*/	

import java.util.Arrays;

public class MaximalRectangle {

	public static int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        if(n==0){return 0;}
        int m=matrix[0].length;
        if(m==0){return 0;}
        int left[]=new int [m];
        int right[]=new int [m];
        int height[]=new int [m];
        Arrays.fill(left, 0);
        Arrays.fill(right, m);
        Arrays.fill(height, 0);
        int res=0;
        for(int i=0;i<n;i++){
        	int tempL=0,tempR=m;
        	for(int j=0;j<m;j++){
        		if(matrix[i][j]=='1'){
        			left[j]=Math.max(left[j],tempL); // left boundary, from left -> right
        		}
        		else{
        			left[j]=0;
        			tempL=j+1;
        		}
        		if(matrix[i][j]=='1'){ // height, from left -> right
        			height[j]++; 
        		}
        		else{
        			height[j]=0;
        		}
        	}
        	for(int j=m-1;j>=0;j--){
        		if(matrix[i][j]=='1'){
        			right[j]=Math.min(right[j], tempR); // right boundary, from right -> left
        		}
        		else{
        			right[j]=m;
        			tempR=j;
        		}
        	}
        	for(int j=0;j<m;j++){
        		res=Math.max((right[j]-left[j])*height[j], res); // update result
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		char[][]A=new char[][]{{'0','1','1','1'},{'1','1','1','0'},{'1','1','1','1'},{'1','1','0','1'}};
		System.out.println(maximalRectangle(A));
	}
}
