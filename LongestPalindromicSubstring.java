//Given a string S, find the longest palindromic substring in S. 
//You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

import java.util.*;

public class LongestPalindromicSubstring {

//	public static String longestPalindrome(String s) {  // Manacher
//		if(s.length()<=2){return s;}
//		char[] str = new char[s.length()*2+3];
//		str[0]='$';
//		str[1]='#';
//		for(int i=0;i<s.length();i++){
//			str[(i+1)*2]=s.charAt(i);
//			str[(i+1)*2+1]='#';
//		}
//		str[str.length-1]='%';
//		int[] p = new int[str.length+1];
//        int id = 0, mx = 0;
//        for (int i = 1; i < str.length-1; i++) {
//            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 0;
//            while (str[i + 1 + p[i]] == str[i - 1 - p[i]])
//                p[i]++;
//            if (i + p[i] > mx) {
//                mx = i + p[i];
//                id = i;
//            }
//        }
//        int len = 0;
//        int mid = 0;
//
//        for (int i = 1; i < str.length-1; i++) {
//            if (p[i] > len) {
//            	len = p[i];
//                mid = i;
//            }
//        }
//        return s.substring((mid-1-len)/2, (mid-1-len)/2+len);
//	}
	
//	public static String longestPalindrome(String s) {   // check mid and range
//		if(s.length()<=3){return s;}
//		String sn="#";
//		for(int i=0;i<s.length();i++){
//			sn=sn+s.charAt(i)+"#";
//		}
//		int len=0,mark=0,mid=0;
//		for(int i=0;i<sn.length();i++){
//			for(int j=0;(i-j>0)&&(i+j<sn.length());j++){
//				if(sn.charAt(i-j)!=sn.charAt(i+j)){
//					{break;}
//				}
//				mark=j*2+1;
//			}
//			if(mark > len){
//				len=mark;
//				mid=i;
//			}
//			for(int j=0;(i-j>0)&&(i+j+1<sn.length());j++){
//				if(sn.charAt(i-j)!=sn.charAt(i+j+1)){
//					{break;}
//				}
//				mark=(j)*2+2;
//			}
//			if(mark > len){
//				len=mark;
//				mid=i;
//			}
//		}
//		String res="";
//		for(int i=mid-len/2+1;i<=mid+len/2;i+=2){ // if mid==#,len must be odd, otherwise must be even
//			res+=sn.charAt(i);
//		}
//		return res;
//	}
	
	public static String longestPalindrome(String s) {    // DP
        if(s.length()<=3){return s;}
        String sr=new StringBuilder(s).reverse().toString();
        int[][] tab=new int[s.length()][s.length()];
        int l=0,end=0;
        for(int i=0;i<s.length();i++){
        	if(sr.charAt(0)==s.charAt(i)){
        		tab[0][i]=1;
        	}
        	else{
        		tab[0][i]=0;
        	}
        	if(s.charAt(0)==sr.charAt(i)){
        		tab[i][0]=1;
        	}
        	else{
        		tab[i][0]=0;
        	}
        }
        for(int i=1;i<s.length();i++){
        	for(int j=1;j<s.length();j++){
        		if(s.charAt(j)==sr.charAt(i)){
        			tab[i][j]=tab[i-1][j-1]+1;
        			if(tab[i][j]>l){
        				l=tab[i][j];
        				end=j;
        			}
        		}
        	}
        }
        return s.substring(end-l+1,end+1);
	}
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome("abb"));
		System.out.println(longestPalindrome("asdabcdefgfedcbaikcspsl"));
		System.out.println(longestPalindrome("asdabcdefggfedcbaikcspsl"));
//		System.out.println(longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}

}
