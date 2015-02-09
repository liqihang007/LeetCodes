//Given an input string, reverse the string word by word.
//For example,
//Given s = "the sky is blue",
//return "blue is sky the".
//input "I wish you a merry Christmas" 
//output "Christmas merry a you wish I" 
//Constrains: O(1) additional memory

import java.util.*;

public class ReverseWordsinaString {

	public String reverseWords(String s) {
		s=s.trim();
		s=s.replaceAll("\\s+", " ");
		char[]chars=s.toCharArray();
        int start=0, end;
        for(int i=0;i<chars.length;i++){
            if(chars[i]==' ' || i==chars.length-1){
                end=chars[i]==' '?i-1:i;
                while(end>start){
                    char tmp=chars[start];
                    chars[start]=chars[end];
                    chars[end]=tmp;
                    start++;
                    end--;
                }
                start=i+1;
            }
        }
        start=0;
        end=chars.length-1;
        while(start<end){
            char tmp=chars[start];
            chars[start]=chars[end];
            chars[end]=tmp;
            start++;
            end--;
        }
        return new String(chars);
	}
	
	public static void main(String[] args) {
		System.out.println(new ReverseWordsinaString().reverseWords("   b     a     "));
	}

}
