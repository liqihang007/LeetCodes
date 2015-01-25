//Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
//Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

public class StrStr {

//	public static String strStr(String haystack, String needle) { // return the substring
//		String myreturn=null;
//		if(haystack!=null && needle!=null && needle.length()<=haystack.length()){
//			if(needle.length()==0){
//				myreturn=haystack;
//			}
//			else{
//				for (int i=0;i<haystack.length()-needle.length()+1;i++){
//					if (haystack.substring(i,i+needle.length()).equals(needle)){
//						myreturn=haystack.substring(i);
//						break;
//					}
//				}
//			}
//		}
//		return myreturn;
//    }
	
	public static int strStr(String haystack, String needle) { // return the index
		int res=-1;
		if(haystack!=null && needle!=null && needle.length()<=haystack.length()){
			if(needle.length()==0){
				res=0;
			}
			else{
				for (int i=0;i<haystack.length()-needle.length()+1;i++){
					if (haystack.substring(i,i+needle.length()).equals(needle)){
						res=i;
						break;
					}
				}
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		String s1="aaa";
		String s2="a";
		System.out.println("-> "+strStr(s1,s2));
	}
}
