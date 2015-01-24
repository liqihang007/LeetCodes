//Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//For example:
//    1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
    
import java.util.*;

public class ExcelSheetColumnTitle {

	public static String convertToTitle(int n) {
		if(n<=0){return "";}
        int mod=(n-1)%26;
        char res= (char) (mod+65);
        return convertToTitle((n-1)/26)+String.valueOf(res);
    }
	
	public static void main(String[] args) {
		System.out.println(convertToTitle(27));
	}

}
