//input: I am opt for a top yam for Amy, May, and Tommy.
//output: a adn amy for i mmoty opt
	
import java.util.*;

public class SortSortedWords {

	public static String SortSortedWords(String in){
		String s = in.replaceAll("[-+.^:,]" , "");
		s = s.toLowerCase();
		String [] sarr = s.split(" ");
		Set <String> set = new HashSet<String>();
		for (int i=0; i < sarr.length; i++){
			char[] chars = sarr[i].toCharArray();
	        Arrays.sort(chars);
	        set.add(new String(chars));
		}
		String [] resarr = set.toArray(new String[set.size()]);
		Arrays.sort(resarr);
		s = "";
		for (int i=0; i < resarr.length; i++){
			s += resarr[i] + " ";
		}
		return s.trim();
	}
	
	public static void main(String[] args) {
		String s = "I am opt for a top yam for Amy, May, and Tommy.";
		String res = SortSortedWords(s);
		System.out.println(res);
	}
}
