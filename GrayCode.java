//The gray code is a binary numeral system where two successive values differ in only one bit.
//Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
//For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
//00 - 0
//01 - 1
//11 - 3
//10 - 2
//Note:
//For a given n, a gray code sequence is not uniquely defined.
//For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

import java.util.*;

public class GrayCode {

	public static List<Integer> grayCode(int n) {
		if(n==0){
			List<Integer> res =new ArrayList<Integer>();
			res.add(0);
			return res;
		}
		List<String> set = new ArrayList<>();
		if(n>=1){
			set.add("0");
			set.add("1");
		}
		for(int i=1;i<n;i++){
			int size=set.size();
			for(int j=size-1;j>=0;j--){
				set.add(new String(set.get(j)));
			}
			for(int j=0;j<(set.size())/2;j++){
				set.set(j,"0"+set.get(j));
			}
			for(int j=(set.size())/2;j<set.size();j++){
				set.set(j,"1"+set.get(j));
			}
		}
		List<Integer> res = new ArrayList<>();
		for(int j=0;j<set.size();j++){
			int s=convert(set.get(j));
			res.add(s);
		}
		return res;
    }

	public static int convert(String s) {
		int res=0;
		for(int i=0;i<s.length();i++){
			res+=Character.getNumericValue(s.charAt(i))*Math.pow(2, s.length()-i-1);
		}
		return res;
	}
	
//	public List<Integer> grayCode(int n) {
//        List<Integer> res = new LinkedList<Integer>();
//        for(int i = 0;i<Math.pow(2, n);i++)
//        {
//            int i2 = i>>1;
//            int x = i^i2;
//            res.add(x);
//        }
//        return res;
//    }
//	
	public static void main(String[] args) {
		System.out.println(grayCode(3));
	}

}
