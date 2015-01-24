
public class StrStr {

	public static String strStr(String haystack, String needle) {
		String myreturn=null;
		if(haystack!=null && needle!=null && needle.length()<=haystack.length()){
			if(needle.length()==0){
				myreturn=haystack;
			}
			else{
				for (int i=0;i<haystack.length()-needle.length()+1;i++){
					if (haystack.substring(i,i+needle.length()).equals(needle)){
						myreturn=haystack.substring(i);
						break;
					}
				}
			}
		}
		return myreturn;
    }
	
	public static void main(String[] args) {
		String s1="aaa";
		String s2="a";
		System.out.println("-> "+strStr(s1,s2));
	}
}
