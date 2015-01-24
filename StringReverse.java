import java.util.Arrays;

public class StringReverse {

	public static String getreverse(String s){
		if (s.length()==0 || s.length()==1){
			return s;
		}
		else{
			s=s+" ";
			char[] A = new char[s.length()];
			int i=0;
			for (int j=0;j<s.length();j++){
				char t=s.charAt(j);
				if (!(Character.isLetter(t) || Character.isDigit(t))){
					char[] st=check(s.substring(i,j));
					for (int k=0;k<st.length;k++){
						A[k+i]=st[k];
					}
					i=j+1;
					A[j]=t;
				}
			}
			String B=String.valueOf(A);
			return(B.substring(0,B.length()-1));
		}
	}
	
	public static char[] check(String s){
		if (s.length()==0 || s.length()==1){
			return s.toCharArray();
		}
		else{
			char[] A=new char[s.length()];
			int k=0;
			for (int i=0;i<s.length();i++){
				if (Character.isLetter(s.charAt(i))){
					k++;
				}
			}
			if(k>0){
				for (int i=0;i<s.length();i++){
					A[i]=s.charAt(s.length()-1-i);
				}
			}
			else{
				for (int i=0;i<s.length();i++){
					A=s.toCharArray();
				}
			}
			return A;
		}
		
	}
	
	public static void main(String[] args) {
//		String s="123 asf 23 asd28 ';s asdsss,123123";
		String s="  123 asf 23 asd28 ';s asdsss,123123";
		System.out.println(getreverse(s));
	}

}
