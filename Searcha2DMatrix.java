//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//Integers in each row are sorted from left to right.
//The first integer of each row is greater than the last integer of the previous row.
//For example,
//Consider the following matrix:
//[
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//Given target = 3, return true.
		
public class Searcha2DMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
        boolean myreturn=false;
        if(matrix!=null && matrix.length>0 && matrix[0].length>0){
        	for (int i=0;i<matrix.length;i++){
        		if (target>=matrix[i][0] && target<=matrix[i][matrix[0].length-1]){
        			for (int j=0;j<matrix[0].length;j++){
        				if(matrix[i][j]==target){myreturn=true;}
        			}
        		}
        	}
        }
        return myreturn;
    }
	public static void main(String[] args) {
		int[][]A=new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		System.out.println(searchMatrix(A,2));
	}

}
