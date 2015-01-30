//Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
//Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

public class StrStr {

	public static int strStr(String haystack, String needle) { // return index
		if(haystack==null || needle==null){return -1;}
		int i,j;
		for(i=0;i<haystack.length()-needle.length()+1;i++){
			for(j=0;j<needle.length();j++){
				if(haystack.charAt(i+j)!=needle.charAt(j)){
					break;
				}
			}
			if(j==needle.length()){
				return i;
			}
		}
		return -1;
	}
	
	public static String strStr(String haystack, String needle) { // return substring
		if(haystack==null || needle==null){return null;}
		int i,j;
		for(i=0;i<haystack.length()-needle.length()+1;i++){
			for(j=0;j<needle.length();j++){
				if(haystack.charAt(i+j)!=needle.charAt(j)){
					break;
				}
			}
			if(j==needle.length()){
				return haystack.substring(i);
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		String s1="abasydvasdadaebvypitdhrwbadfa"; // 8
		String s2="sdadaebvypitdh";
		System.out.println(strStr(s1,s2));
	}
}
