import java.util.*;

public class TwoSum3 {

	List<Integer>list=new ArrayList<Integer>();
	HashSet<Integer>hash=new HashSet<Integer>();
	public interface TwoSum {
	    /**
	     * Stores @param input in an internal data structure.
	     */
	    void store(int input);

	    /**
	     * Returns true if there is any pair of numbers in the internal data 
	structure which
	     * have sum @param val, and false otherwise.
	     * For example, if the numbers 1, -2, 3, and 6 had been stored,
	     * the method should return true for 4, -1, and 9, but false for 10, 5, 
	and 0
	     */
	    boolean test(int val);
	    
	}
	
	public void store(int input){
		list.add(input);
		hash.add(input);
	}
	
	public boolean test(int val){
		if(hash.contains(-val)){
			return true;
		}
		else{return false;}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
