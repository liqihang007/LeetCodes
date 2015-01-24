import java.util.*;

public class WordSearch {

	public static boolean exist(char[][] board, String word) {
		boolean result=false;
        if (board==null || word==null || word.length()==0 || board.length==0 || board[0].length==0){
        	result=false;
        }
        else{
        	for (int i=0;i<board.length;i++){
        		for (int j=0;j<board[0].length;j++){
    				Set <Integer> used = new HashSet<Integer>();
    				result=search(board,i,j,word,0,used);
    				if (result==true){
    					return result;
    				}
        		}
        	}
        }
        return result;
    }
	
	public static boolean search(char[][] board, int x, int y, String word, int match, Set<Integer> used){
		boolean myreturn=false;
		if (match>=word.length()){
			myreturn= true;
		}
		else{
			if (x<0 || x>=board.length || y<0 || y>=board[0].length){
				myreturn= false;
			}
			else{
				if (board[x][y]==word.charAt(match)){
					match++;
					if (used.contains(x*board[0].length+y)){
						myreturn= false;
//						System.out.println("used");
					}
					else{
						used.add(x*board[0].length+y);
//						System.out.println(used+" "+x+" "+y+" "+(x*board[0].length+y)+" "+board[0].length);
//						System.out.println(used);
						myreturn= search(board,x,y+1,word,match,used) || 
								search(board,x,y-1,word,match,used) ||
								search(board,x+1,y,word,match,used) ||
								search(board,x-1,y,word,match,used);
						used.remove(x*board[0].length+y);
					}
				}
			}
		}
		return myreturn;
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
