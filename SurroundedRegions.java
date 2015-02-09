//Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
//A region is captured by flipping all 'O's into 'X's in that surrounded region.
//For example,
//X X X X
//X O O X
//X X O X
//X O X X
//After running your function, the board should be:
//X X X X
//X X X X
//X X X X
//X O X X

import java.util.*;

public class SurroundedRegions {

	public void solve(char[][] board) {
        if(board.length==0 || board[0].length==0) return;
        int rows=board.length, cols=board[0].length;
        for(int i=0;i<rows;i++){        	
    		dfs(board,i,0);
    		dfs(board,i,cols-1);
        }
        for(int j=0;j<cols;j++){        	
    		dfs(board,0,j);
    		dfs(board,rows-1,j);
        }
//        for(int i=0;i<rows;i++){
//        	String s="";
//        	for(int j=0;j<cols;j++){
//        		s+=board[i][j];
//        	}
//        	System.out.println(s);
//        }
        for(int i=0;i<rows;i++){
        	for(int j=0;j<cols;j++){
        		if(board[i][j]=='O')
        			board[i][j]='X';
        		if(board[i][j]=='T')
        			board[i][j]='O';
        	}
        }
    }

	public void dfs(char[][] board, int i, int j){
		if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!='O')
			return;
		else{
			board[i][j]='T';
			dfs(board,i-1,j);
			dfs(board,i+1,j);
			dfs(board,i,j-1);
			dfs(board,i,j+1);
		}
	}
	
	public static void main(String[] args) {
		char[][]A=new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		new SurroundedRegions().solve(A);
		for(int i=0;i<A.length;i++){
			String s="";
        	for(int j=0;j<A[0].length;j++){
        		s+=A[i][j];
        	}
        	System.out.println(s);
        }
	}

}
