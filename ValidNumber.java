//Validate if a given string is numeric.
//Some examples:
//"0" => true
//" 0.1 " => true
//"abc" => false
//"1 a" => false
//"2e10" => true
//Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

import java.util.*;

public class ValidNumber {

	public static boolean isNumber(String s) {
        if(s.length()==0 || s==null){
        	return false;
        }
        else{
        	int x=0,y=s.length()-1;
        	for(int i=0;i<s.length();i++){
        		if(s.charAt(i)!=' '){
        			x=i;break;
        		}
        	}
        	for(int i=s.length()-1;i>=0;i--){
        		if(s.charAt(i)!=' '){
        			y=i;break;
        		}
        	}
        	System.out.println(x+" "+y);
        	if(x>y){return false;}
        	else{
        		String snew=s.substring(x,y+1);
        		System.out.println(snew);
        		return checknum(snew) || checksci(snew);
        	}
        }
    }
	
	public static boolean checknum(String s){
		boolean res=true;
    	int point=0;
    	int hasnum=0;
    	for(int i=0;i<s.length();i++){
    		if(i==0){
    			if((s.charAt(i)=='+' || s.charAt(i)=='-') && i!=s.length()-1){continue;}
			}
    		if(s.charAt(i)=='1' ||
				s.charAt(i)=='2' ||
				s.charAt(i)=='3' ||
				s.charAt(i)=='4' ||
				s.charAt(i)=='5' ||
				s.charAt(i)=='6' ||
				s.charAt(i)=='7' ||
				s.charAt(i)=='8' ||
				s.charAt(i)=='9' ||
				s.charAt(i)=='0' ||
				s.charAt(i)=='.' ){
    			hasnum++;
				if(s.charAt(i)=='.'){
					point++;
				}
    		}
    		else{
    			res = false;
    			break;
    		}
    	}
    	hasnum-=point;
    	if(point>=2 || hasnum<=0 || (point==1 && s.length()==1)){res=false;}
    	System.out.println("check 1 is "+res);
    	return res;
	} 
	
	public static boolean checksci(String s){
		int e=-1;
		boolean res=true;
		if(s.length()<=1){res=false;}
    	for(int i=0;i<s.length();i++){
    		if(s.charAt(i)=='e'){
    			e=i;
    		}
    	}
    	System.out.println(e);
    	if(e<1 || e>=s.length()-1){res=false;} // check left part
    	else{
    		if(e==1){
    			if(s.charAt(0)=='1' ||
	    				s.charAt(0)=='2' ||
	    				s.charAt(0)=='3' ||
	    				s.charAt(0)=='4' ||
	    				s.charAt(0)=='5' ||
	    				s.charAt(0)=='6' ||
	    				s.charAt(0)=='7' ||
	    				s.charAt(0)=='8' ||
	    				s.charAt(0)=='9' ||
	    				s.charAt(0)=='0'){}
    			else{
    				res=false;
    			}
    		}
    		else{
	    		int pointL=0;		
	    		for(int i=0;i<e;i++){
	        		if(i==0){
	        			if((s.charAt(i)=='+' || s.charAt(i)=='-') && i!=s.length()-1){continue;}
	        			if(s.charAt(i)=='.' && e==i+1){
	        				res=false;
	        				break;
	        			}
	    			}
	        		if(s.charAt(i)=='1' ||
	    				s.charAt(i)=='2' ||
	    				s.charAt(i)=='3' ||
	    				s.charAt(i)=='4' ||
	    				s.charAt(i)=='5' ||
	    				s.charAt(i)=='6' ||
	    				s.charAt(i)=='7' ||
	    				s.charAt(i)=='8' ||
	    				s.charAt(i)=='9' ||
	    				s.charAt(i)=='0' ||
	    				s.charAt(i)=='.' ){
	    				if(s.charAt(i)=='.'){
	    					pointL++;
	    				}
	        		}
	        		else{
	        			res = false;
	        			break;
	        		}
	    		}
    		}

    		System.out.println("check 2L is "+res);
    		for(int i=e+1;i<s.length();i++){ // check right part
        		if(i==e+1){
        			if((s.charAt(i)=='+' || s.charAt(i)=='-') && i!=s.length()-1){continue;}
//        			if(s.charAt(i)=='0' && i==s.length()-1){
//        				res=false;
//        				break;
//        			}
    			}

        		System.out.println("check 222 is "+s.charAt(i));
        		if(s.charAt(i)=='1' ||
    				s.charAt(i)=='2' ||
    				s.charAt(i)=='3' ||
    				s.charAt(i)=='4' ||
    				s.charAt(i)=='5' ||
    				s.charAt(i)=='6' ||
    				s.charAt(i)=='7' ||
    				s.charAt(i)=='8' ||
    				s.charAt(i)=='9' ||
    				s.charAt(i)=='0'){
    			
        		}
        		else{
        			res = false;
        			break;
        		}
    		}
    	}
    	System.out.println("check 2R is "+res);
    	return res;
	}
	
//	public boolean isNumber(String s) {
//        char[] c=s.trim().toCharArray();
//
//	    if (c.length==0) return false;
//	
//	    int i=0,num=0;
//	    if (c[i]=='+'||c[i]=='-') i++;
//	
//	    for(;i<c.length&&(c[i]>='0'&&c[i]<='9');i++) num++;
//	    if (i<c.length&&c[i]=='.')i++;
//	    for(;i<c.length&&(c[i]>='0'&&c[i]<='9');i++) num++;
//	
//	    if (num==0) return false;
//	
//	    if (i==c.length) return true;
//	    else if (i<c.length&&c[i]!='e') return false;
//	    else i++;
//	
//	    num=0;
//	    if (i<c.length&&(c[i]=='+'||c[i]=='-')) i++;
//	
//	    for(;i<c.length&&(c[i]>='0'&&c[i]<='9');i++) num++;
//	    if (num==0) return false;
//	
//	    if (i==c.length) return true;
//	    else return false;
//	}
	
	public static void main(String[] args) {
		System.out.println(isNumber("1123.e0"));
	}

}
