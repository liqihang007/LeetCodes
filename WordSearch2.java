//Given a 2D board and a list of words from the dictionary, find all words in the board.
//Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells 
//are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
//For example,
//Given words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//Return ["eat","oath"].

import java.util.*;

public class WordSearch2 {
	
	public List<String> findWords(char[][] board, String[] words) {
	    Set<String> res = new HashSet<>();
	    TrieNode root = buildTrie(words);
	    for(int i = 0; i < board.length; i++) {
	        for(int j = 0; j < board[0].length; j++) {
	            dfs(board, i, j, root, res);
	        }
	    }
	    return new ArrayList<String>(res);
	}

	public void dfs(char[][] board, int i, int j, TrieNode p, Set<String> res) {
	    char c = board[i][j];
	    if(c == '#' || p.next[c - 'a'] == null) return;
	    p = p.next[c - 'a'];
	    if(p.word != null) res.add(p.word);
	    board[i][j] = '#';
	    if(i > 0) dfs(board, i - 1, j ,p, res); 
	    if(j > 0) dfs(board, i, j - 1, p, res);
	    if(i < board.length - 1) dfs(board, i + 1, j, p, res); 
	    if(j < board[0].length - 1) dfs(board, i, j + 1, p, res); 
	    board[i][j] = c;
	}

	public TrieNode buildTrie(String[] words) {
	    TrieNode root = new TrieNode();
	    for(String w : words) {
	        TrieNode p = root;
	        for(char c : w.toCharArray()) {
	            int i = c - 'a';
	            if(p.next[i] == null) p.next[i] = new TrieNode();
	            p = p.next[i];
	       }
	       p.word = w;
	    }
	    return root;
	}

	class TrieNode {
	    TrieNode[] next = new TrieNode[26];
	    String word;
	}
	
//	public static List<String> findWords(char[][] board, String[] words) {
//		List<String>res=new ArrayList<String>();
//		if(board==null || board.length==0 || board[0].length==0 || words.length==0)
//            return res;
//        for(int i=0; i< board.length; i++){
//            for(int j=0; j<board[0].length; j++){
//            	for(int k=0; k<words.length; k++){
//            		if(board[i][j] == words[k].charAt(0)){
//            			dfs(res, board, i, j, words[k], 0);
//            		}
//                }
//            }
//        }
//        return res;
//    }
//    
//    private static void dfs(List<String> res, char[][] board, int i, int j, String word, int start){
//    	if(i<0 || i>=board.length || j<0 || j>=board[0].length)
//            return;
//    	if(start==word.length()-1 && board[i][j]==word.charAt(start)){
//            res.add(word);
//            return;
//        }
//        if(board[i][j]!=word.charAt(start))
//            return;
//        board[i][j]='#'; // should remember to mark it
//        dfs(res, board, i-1, j, word, start+1);
//        dfs(res, board, i, j-1, word, start+1);
//        dfs(res, board, i+1, j, word, start+1);
//        dfs(res, board, i, j+1, word, start+1);
//        board[i][j]=word.charAt(start);
//    }
//    
//    public static void main(String[] args) {
//		char[][] board= new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//		String []words=new String[]{"oath","pea","eat","rain"};
//		System.out.println(findWords(board, words));
//	}
	
}
