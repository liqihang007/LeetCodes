import java.util.Arrays;

//Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
//For example, given the following matrix:
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//Return 4.

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
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
        		res=(int) Math.max(Math.pow(Math.min(right[j]-left[j],height[j]),2), res); // update result
        	}
        }
        return res;
    }
}
