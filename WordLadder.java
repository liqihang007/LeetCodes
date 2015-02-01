//Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
//Only one letter can be changed at a time
//Each intermediate word must exist in the dictionary
//For example, Given:
//start = "hit"
//end = "cog"
//dict = ["hot","dot","dog","lot","log"]
//As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//return its length 5.
//Note:
//Return 0 if there is no such transformation sequence.
//All words have the same length.
//All words contain only lowercase alphabetic characters.

/*
1. This question is find shortest path, so we shall choose BFS over DFS.
2. Since finding an element in HashSet is O(1) time, we can generate all the possible strings of distance = 1 and check if they are in the dictionary. 
	In this way, we reduce time complexity from O(m x n) to O(m x 26).
3. If a word is found from the dictionary, remove it.
 */

public class WordLadder {
	
	public int ladderLength(String start, String end, Set<String> dict) {
		if (start.equals(end)) {return 1;}
	    LinkedList<String> words = new LinkedList<String>();
	    LinkedList<Integer> nums = new LinkedList<Integer>();
	    words.add(start);
	    nums.add(1);
	    while (!words.isEmpty()) {
	        String word = words.remove();
	        int num = nums.remove();
	        char[] charArr = word.toCharArray();
	        for (int i = 0; i < charArr.length; i++) {
	            char originChar = charArr[i];
	            for (char j = 'a'; j <= 'z'; j++) {
	                charArr[i] = j;
	                String newWord = new String(charArr);
	                if (newWord.equals(end))
	                    return num + 1;
	                if (dict.contains(newWord)) {
	                    dict.remove(newWord);
	                    words.add(newWord);
	                    nums.add(num + 1);
	                }
	            }
	            charArr[i] = originChar;
	        }
	    }
	    return 0;
    }
	
	public static void main(String[] args) {
		
	}
}
