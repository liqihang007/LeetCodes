//Given a digit string, return all possible letter combinations that the number could represent.
//A mapping of digit to letters (just like on the telephone buttons) is given below.
//Input:Digit string "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//Note: Although the above answer is in lexicographical order, your answer could be in any order you want.

import java.util.*;

public class LetterCombinationsofaPhoneNumber {

	public static List<String> letterCombinations(String digits) {
		if(digits==null || digits.length()==0){
			List<String> res = new ArrayList<String>();
			res.add("");
			return res;
		}
		List<String> res = getletter(digits.charAt(0));
		for(int i=1;i<digits.length();i++){
			List<String> temp = new ArrayList<String>();
			List<String> num = getletter(digits.charAt(i));
			for(int p=0;p<res.size();p++){
				String s=res.get(p);
				for(int q=0;q<num.size();q++){
					temp.add(s+num.get(q));
				}
			}
			res=temp;
		}
		return res;
    }
	
	public static List<String> getletter(char c){
		List<String> res=new ArrayList<String>();
		if(c=='2'){res.add("a");res.add("b");res.add("c");}
		if(c=='3'){res.add("d");res.add("e");res.add("f");}
		if(c=='4'){res.add("g");res.add("h");res.add("i");}
		if(c=='5'){res.add("j");res.add("k");res.add("l");}
		if(c=='6'){res.add("m");res.add("n");res.add("o");}
		if(c=='7'){res.add("p");res.add("q");res.add("r");res.add("s");}
		if(c=='8'){res.add("t");res.add("u");res.add("v");}
		if(c=='9'){res.add("w");res.add("x");res.add("y");res.add("z");}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(letterCombinations(""));
		System.out.println(letterCombinations("23"));
	}

}
