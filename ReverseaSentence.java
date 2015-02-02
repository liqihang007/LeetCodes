//You given a sentence of english words and spaces between them. 
//Nothing crazy: 
//1) no double spaces 
//2) no empty words 
//3) no spaces at the ends of a sentence
//Example: 
//input "I wish you a merry Christmas" 
//output "Christmas merry a you wish I" 
//Constrains: O(1) additional memory

import java.util.*;

public class ReverseaSentence {

	public String reverseaSentence(String s) {
		char[] chars = s.toCharArray();
		int start = 0;
		for (int i=0; i<chars.length; i++) {
			if (chars[i] == ' ' || i == chars.length-1) {
				int end = chars[i] == ' ' ? i - 1 : i;
				while (end > start) {
					char temp = chars[start];
					chars[start] = chars[end];
					chars[end] = temp;
					start++;
					end--;
				}
				start = i + 1;
			}
		}
		for (int i = 0; i < chars.length / 2; i++) {
			char temp = chars[i];
			chars[i] = chars[chars.length-1-i];
			chars[chars.length-1-i] = temp;
		}
		return chars.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
