import java.util.Arrays;

//Write a program to solve a Sudoku puzzle by filling the empty cells.
//Empty cells are indicated by the character '.'.
//You may assume that there will be only one unique solution.

public class SudokuSolver {

	public static void solveSudoku(char[][] board) {
		if(board.length!=9 || board[0].length!=9){return;}
		boolean [][] rows=new boolean[9][9];
		boolean [][] cols=new boolean[9][9];
		boolean [][][] blocks=new boolean[9][3][3];
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				rows[i][j]=false;
				cols[i][j]=false;
			}
			for(int j=0;j<3;j++){
				for(int p=0;p<3;p++){
					blocks[i][j][p]=false;
				}
			}
		}
		for(int i=0;i<9;i++){	// pre-process
			for(int j=0;j<9;j++){
				if(board[i][j]!='.'){
					int num=board[i][j]-'1';
					rows[num][i]=true;
					cols[num][j]=true;
					blocks[num][i/3][j/3]=true;
				}
			}
		}
		dfs(board,0,rows,cols,blocks);
    }
	
	public static boolean dfs(char[][] board, int pos, boolean [][] rows,
			boolean [][] cols,boolean [][][] blocks){
		if(pos>=81){return true;}
		int i=pos/9, j=pos%9;
		if(board[i][j]!='.'){
			return dfs(board,pos+1,rows,cols,blocks);
		}
		else{	// is '.'
			for(int num=0;num<9;num++){
				if(!rows[num][i] && !cols[num][j] && !blocks[num][i/3][j/3]){
					board[i][j]=(char) ('1'+num);
					rows[num][i]=true;
					cols[num][j]=true;
					blocks[num][i/3][j/3]=true;
					if(dfs(board,pos+1,rows,cols,blocks)){
						return true;
					}
					else{
						board[i][j]='.';
						rows[num][i]=false;
						cols[num][j]=false;
						blocks[num][i/3][j/3]=false;
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		char [][] A=new char [][]{
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};
		solveSudoku(A);
		for (int i=0;i<9;i++){
			String s="";
			for (int j=0;j<9;j++){
				s+=A[i][j];
			}
			System.out.println(s);
		}
	}

}
