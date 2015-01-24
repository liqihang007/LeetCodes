//Given two binary strings, return their sum (also a binary string).
//For example,
//a = "11"
//b = "1"
//Return "100".

import java.util.*;

public class AddBinary {

	public static String addBinary(String a, String b) {
        if(a==null || a.length()==0){return b;}
        if(b==null || b.length()==0){return a;}
        int asize=a.length();
        int bsize=b.length();
        if (asize>bsize){
        	for(int i=0;i<asize-bsize;i++){
        		b="0"+b;
        	}
        }
        else{
        	for(int i=0;i<bsize-asize;i++){
        		a="0"+a;
        	}
        }
        a="0"+a;
        b="0"+b;
//        System.out.println(a);
//        System.out.println(b);
        boolean [] carry=new boolean [a.length()];
    	for(int i=0;i<carry.length;i++){
    		carry[i]=false;
    	}
        char[] alist=a.toCharArray();
        char[] blist=b.toCharArray();
        char[] res=new char [a.length()];
        for(int i=carry.length-1;i>=1;i--){
        	if(alist[i]=='1' && blist[i]=='1'){
        		carry[i-1]=true;
        		if(carry[i]==true){res[i]='1';}
        		else{res[i]='0';}
        	}
        	else{
        		if(alist[i]=='0' && blist[i]=='0'){
            		if(carry[i]==true){res[i]='1';}
            		else{res[i]='0';}
            	}
        		else{
            		if(carry[i]==true){
            			res[i]='0';
            			carry[i-1]=true;
            		}
            		else{res[i]='1';}
        		}
        	}
        }
        if(carry[0]==true){
        	res[0]='1';
        }
//        System.out.println(Arrays.toString(carry));
//        System.out.println(Arrays.toString(res));
        return new String(res).trim();
    }
	
	public static void main(String[] args) {
		String a="1";
		String b="1";
		System.out.println(addBinary(a,b));
	}

}
