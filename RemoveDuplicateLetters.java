//Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. 
//You must make sure your result is the smallest in lexicographical order among all possible results.
//Example:
//Given "bcabc"
//Return "abc"
//Given "cbacdcbc"
//Return "acdb"

public class RemoveDuplicateLetters {
	public static String removeDuplicateLetters(String s) {
		int[] res = new int[26]; // will contain number of occurences of character (i+'a')
        boolean[] visited = new boolean[26]; // will contain if character ('a' + i) is present in current result Stack
        char[] ch = s.toCharArray();
        for(char c : ch)  // count number of occurences of character 
            res[c-'a']++;
        StringBuilder sb = new StringBuilder();; // answer stack
        int index;
        for(char c : ch){ 
            index = c - 'a';
            res[index]--;   // decrement number of characters remaining in the string to be analysed
            if(visited[index]) // if character is already present in stack, dont bother
                continue;
            // if current character is smaller than last character in stack which occurs later in the string again
            // it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
            while( (sb.length() > 0) && c < sb.charAt(sb.length()-1) && res[sb.charAt(sb.length()-1)-'a']!=0){ 
                visited[sb.charAt(sb.length()-1) - 'a'] = false;
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(c); // add current character and mark it as visited
            visited[index] = true;
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("bcabc"));
		System.out.println(removeDuplicateLetters("cbacdcbc"));
	}
}
