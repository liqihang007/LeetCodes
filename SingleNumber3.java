//Given an array of integers, every element appears twice except for two. Find them.

import java.util.*;

public class SingleNumber3 {

	public static void singleNumber(int[] A) {
        int res=0;
        for(int i : A){
        	res^=A[i];
        }
//        res=res^A[i];b3=b2&i;b2=(b2|(b1&i))&~b3;b1=(b1|i)&~bit3;
        String bistr=Integer.toBinaryString(res);
        List<Integer>list1=new ArrayList<Integer>();
        List<Integer>list2=new ArrayList<Integer>();
        for(int i=0;i<bistr.length();i++){
        	if(bistr.charAt(bistr.length()-1-i)=='1'){
        		for(int j : A){
        			String tmp=Integer.toBinaryString(j);
                	if(tmp.length()>i && tmp.charAt(tmp.length()-1-i)=='1'){
                		list1.add(j);
                	}
                	else{
                		list2.add(j);
                	}
                }
        		break;
        	}
        }
        int res1=0;
        for(int i : list1){
        	res1^=i;
        }
        int res2=0;
        for(int i : list2){
        	res2^=i;
        }
        System.out.println(res1);
        System.out.println(res2);
    }
	
	public static void main(String[] args) {
		int[]A={1,3,1,2,4,5,6,4,5,2,3,9}; // 6 and 9
		singleNumber(A);
	}
}
