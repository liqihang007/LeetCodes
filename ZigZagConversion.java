//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//P   A   H   N
//A P L S I I G
//Y   I   R
//And then read line by line: "PAHNAPLSIIGYIR"
//Write the code that will take a string and make this conversion given a number of rows:
//string convert(string text, int nRows);
//convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
		
public class ZigZagConversion {

	public static String convert(String s, int nRows) {
        if(s.length()<=1 || nRows==1){return s;}
        else{
        	char[] A=new char[s.length()];
        	int k=0;
        	for(int i=0;i<nRows;i++){
        		int j=i;
        		if(i==0 || i==nRows-1){
        			while(j<s.length()){
            			A[k]=s.charAt(j);
            			j=j+2*(nRows-1);
            			k++;
        			}
        		}
        		else{
	        		boolean q=true;
	        		while(j<s.length()){
	        			A[k]=s.charAt(j);
	    				if(q){j=j+2*(nRows-1-i);q=false;} // down triangle
	    				else{j=j+2*(i);q=true;} // triangle
	        			k++;
	        		}
        		}
        	}
        	return String.valueOf(A);
        }
    }
	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING",3));
		System.out.println(convert("AB",1));
	}

}
