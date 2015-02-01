//2D matrix with 0s and 1s. Try to find out how many countries in this matrix? 
//For example: 
//[[1,1,1,0] 
//[1,1,0,0] 
//[0,0,0,1]] 
//return 3, because one for 1s, one for 0s, and one for the last one. 
//another example: 
//[[1,1,1,1] 
//[0,0,0,0] 
//[1,0,0,1]] 
//return 4

import java.util.*;

public class CountCountries {
	
	public void bfs(int [][] A, boolean [][] visited, int i, int j, int label){
		if(i<0 || i>A.length-1 || j<0 || j>A[0].length-1 || visited[i][j]==true || A[i][j]!=label){
			return;
		}
		visited[i][j]=true;
		bfs(A,visited,i+1,j,label);
		bfs(A,visited,i-1,j,label);
		bfs(A,visited,i,j+1,label);
		bfs(A,visited,i,j-1,label);
	}
	
	public int countCountries(int[][] A){
		if(A.length==0 || A[0].length==0){return 0;}
		boolean [][] visited=new boolean[A.length][A[0].length];
		int res=0;
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				if(!visited[i][j]){
					res++;
//					if(A[i][j]==1){res++;}
					bfs(A,visited, i,j,A[i][j]);
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		CountCountries test=new CountCountries();
		int[][]A=new int[][]{{0,0,1,1},
							 {1,1,1,0},
							 {0,0,0,1},
							 {1,0,0,1}};
		System.out.println(test.countCountries(A));
	}
}
