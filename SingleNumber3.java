//Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
//Find the two elements that appear only once.
//For example:
//Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
		
import java.util.*;

public class SingleNumber3 {

	public static int[] singleNumber(int[] nums) {
        int tmp=0;
        for(int i : nums)
        	tmp^=i;
        String bistr=Integer.toBinaryString(tmp);
        List<Integer>list1=new ArrayList<Integer>();
        List<Integer>list2=new ArrayList<Integer>();
        for(int i=0; i<bistr.length(); i++){
        	if(bistr.charAt(bistr.length()-1-i)=='1'){
        		for(int j : nums){
        			String tmps=Integer.toBinaryString(j);
                	if(tmps.length()>i && tmps.charAt(tmps.length()-1-i)=='1')
                		list1.add(j);
                	else
                		list2.add(j);
                }
        		break;
        	}
        }
//        System.out.println(list1);
//        System.out.println(list2);
        int res1=0;
        for(int i : list1)
        	res1^=i;
        int res2=0;
        for(int i : list2)
        	res2^=i;
        int[]res=new int[2];
        res[0]=res1;
        res[1]=res2;
//        System.out.println(res1);
//        System.out.println(res2);
        return res;
    }
	
	public static void main(String[] args) {
		int[]a={1,3,1,2,4,5,6,4,5,2,3,9}; // 6 and 9
		System.out.println(Arrays.toString(singleNumber(a)));
		int[]b={1,2}; // 6 and 9
		System.out.println(Arrays.toString(singleNumber(b)));
	}
}
