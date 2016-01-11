//Given a 2D board and a word, find if the word exists in the grid.
//The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//For example, Given board =
//[
//  ["ABCE"],
//  ["SFCS"],
//  ["ADEE"]
//]
//word = "ABCCED", -> returns true,
//word = "SEE", -> returns true,
//word = "ABCB", -> returns false.

import java.util.*;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        if(word.length() == 0)
            return true;
        for(int i = 0; i< board.length; i++){
            for(int j=0; j< board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean rst = find(board, i, j, word, 0);
                    if(rst)
                        return true;
                }
            }
        }
        return false;
    }
    
    private static boolean find(char[][] board, int i, int j, String word, int start){
        if(start == word.length())
            return true;
        if (i < 0 || i>= board.length ||
            j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)){
            return false;
        }
        board[i][j] = '#'; // should remember to mark it
        boolean rst = find(board, i-1, j, word, start+1)
                    || find(board, i, j-1, word, start+1)
                    || find(board, i+1, j, word, start+1)
                    || find(board, i, j+1, word, start+1);
        board[i][j] = word.charAt(start);
        return rst;
    }
	
	public static void main(String[] args) {
		char[][] board= new char[3][4];
		board[0][0]='a';
		board[0][1]='b';
		board[0][2]='c';
		board[0][3]='e';
		board[1][0]='s';
		board[1][1]='f';
		board[1][2]='e';
		board[1][3]='s';
		board[2][0]='a';
		board[2][1]='d';
		board[2][2]='e';
		board[2][3]='e';
		System.out.println(exist(board, "abceseeefs"));
		
	}
}
