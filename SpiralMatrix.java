//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//For example,
//Given the following matrix:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//return [1,2,3,4,5,6,7,8,9]

import java.util.*;

public class SpiralMatrix {

    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0)
            return res;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count=0;
        while(count*2<rows && count*2<cols){
            for(int i=count; i<cols-count; i++)
                res.add(matrix[count][i]);
            for(int i=count+1; i<rows-count; i++)
                res.add(matrix[i][cols-count-1]);
            if(rows-2*count==1 || cols-2*count==1)  // if only one row/col remains
                break;
            for(int i=cols-count-2; i>=count; i--)
                res.add(matrix[rows-count-1][i]);
            for(int i=rows-count-2; i>=count+1; i--)
                res.add(matrix[i][count]);
            count++;
        }
        return res;
    }

	public static void main(String[] args) {
		int [][] A= new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
//		int [][] A= new int[][]{{1,2,3}};
//		int [][] A= new int[][]{{1},{2},{3}};
//		int [][] A=null;

		for(int i=0;i<A.length;i++){
			System.out.println(Arrays.toString(A[i]));
		}
		System.out.println(spiralOrder(A));
	}
}
