import java.util.*;

public class MajorityElement {

	public static int majorityElement(int[] num) {
        int myreturn=0;
        HashMap<Integer, Integer> set = new HashMap<Integer,Integer>();
        for (int i=0;i<num.length;i++){
        	if (set.containsKey(num[i])){
        		set.put(num[i], set.get(num[i])+1);
        	}
        	else{
        		set.put(num[i],1);
        	}
        }
        int maxnum=Collections.max(set.values());
        for (Map.Entry<Integer, Integer> entry : set.entrySet()){
        	if (entry.getValue()==maxnum){
        		myreturn = entry.getKey();
        	}
        }
        return myreturn;
    }
	
	public static void main(String[] args) {
		System.out.println(majorityElement(new int[]{1,2,3,4,3,2,3,3,1,3,3,3}));

	}

}
