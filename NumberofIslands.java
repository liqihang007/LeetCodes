//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
//You may assume all four edges of the grid are all surrounded by water.
//Example 1:
//11110
//11010
//11000
//00000
//Answer: 1
//Example 2:
//11000
//11000
//00100
//00011
//Answer: 3
//
// see also: count countries

import java.util.*;

public class NumberofIslands {
	public int numIslands(char[][] grid) {
		if(grid.length==0 || grid[0].length==0) return 0;
		boolean [][] visited=new boolean[grid.length][grid[0].length];
		int res=0;
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				if(!visited[i][j]){
					if(grid[i][j]=='1')
						res++; // count only A[i][j]==1
					bfs(grid, visited, i, j);
				}
			}
		}
		return res;
    }
	
	public void bfs(char[][] A, boolean[][]visited, int i, int j){
		if(i<0 || i>A.length-1 || j<0 || j>A[0].length-1 || visited[i][j]==true || A[i][j]!='1')
			return;
		visited[i][j]=true;
		bfs(A, visited, i+1, j);
		bfs(A, visited, i-1, j);
		bfs(A, visited, i, j+1);
		bfs(A, visited, i, j-1);
	}
	
	public static void main(String[] args) {
		NumberofIslands test=new NumberofIslands();
		char[][]A=new char[][]{{'1','1','1','1','0'},
							 {'1','1','0','1','0'},
							 {'1','1','0','0','0'},
							 {'0','0','0','0','0'}};
		System.out.println(test.numIslands(A));
		char[][]B=new char[][]{{'1','1','0','0','0'},
							 {'1','1','0','0','0'},
							 {'0','0','1','0','0'},
							 {'0','0','0','1','1'}};
		System.out.println(test.numIslands(B));
	}
}
