//Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
//The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
//A partially filled sudoku which is valid.
//Note: A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

import java.util.*;

public class ValidSudoku {

	public static boolean isValidSudoku(char[][] board) {
        if(board==null || board.length!=9 || board[0].length!=9){return false;}
        else{
        	for (int i=0;i<9;i++){ // for rows
        		HashSet<Character> hash = new HashSet<Character>();
        		for (int j=0;j<9;j++){
        			if(board[i][j]!='.'){
        				if(Character.isDigit(board[i][j])){
        					if(hash.contains(board[i][j])){
        						return false;
        					}
        					else{
        						hash.add(board[i][j]);
        					}
        				}
        				else{
        					return false;
        				}
        			}
        		}
        	}
        	for (int i=0;i<9;i++){ // for cols
        		HashSet<Character> hash = new HashSet<Character>();
        		for (int j=0;j<9;j++){
        			if(board[j][i]!='.'){
        				if(Character.isDigit(board[j][i])){
        					if(hash.contains(board[j][i])){
        						return false;
        					}
        					else{
        						hash.add(board[j][i]);
        					}
        				}
        				else{
        					return false;
        				}
        			}
        		}
        	}
        	for (int x=0;x<3;x++){ // for 9 blocks
        		for (int y=0;y<3;y++){
        			HashSet<Character> hash = new HashSet<Character>();
	        		for (int i=x*3;i<x*3+3;i++){
	        			for (int j=y*3;j<y*3+3;j++){
		        			if(board[i][j]!='.'){
		        				if(Character.isDigit(board[i][j])){
		        					if(hash.contains(board[i][j])){
		        						return false;
		        					}
		        					else{
		        						hash.add(board[i][j]);
		        					}
		        				}
		        				else{
		        					return false;
		        				}
		        			}
	        			}
	        		}
        		}
        	}
        	return true;
        }
    }

	public static void main(String[] args) {
		char [][] A=new char [9][9];
		String[] S=new String[]{"....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"};
		for (int i=0;i<9;i++){
			A[i] = S[i].toCharArray();
			System.out.println(S[i]);
		}
		System.out.println(isValidSudoku(A));
	}
}
