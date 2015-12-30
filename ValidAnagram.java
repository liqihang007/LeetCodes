//Given two strings s and t, write a function to determine if t is an anagram of s.
//For example,
//s = "anagram", t = "nagaram", return true.
//s = "rat", t = "car", return false.
//Note:
//You may assume the string contains only lowercase alphabets.

public class ValidAnagram {

	public static boolean isAnagram(String s, String t) {
		if(s==null && t==null)
			return true;
		char []S = s.toCharArray();
		char []T = t.toCharArray();
		Arrays.sort(S);
		Arrays.sort(T);
		if(S.length!=T.length)
			return false;
		for(int i=0;i<S.length;i++)
			if(S[i]!=T[i])
				return false;
		return true;
    }
	
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram","nagaram"));
		System.out.println(isAnagram("a","b"));
	}

}
