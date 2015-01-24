import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	
	public static int[] twoSum(int[] numbers, int target) {
		int [] results=new int[2];
		HashMap<Integer, Integer> hash= new HashMap<Integer, Integer>();
		for (int i=0;i<numbers.length;i++){
			
			int key=target-numbers[i];
			if (hash.containsKey(key)){
				int x=hash.get(key)+1;
				int y=i+1;
				if (x>y){
					int temp=x;
					x=y;
					y=temp;
				}
				results[0]=x;
				results[1]=y;
				return results;
			}
			else{
				hash.put(numbers[i], i);
			}
		}
		return results;
    }

	public static void main(String[] args) {
		int[] A= new int[] {150,24,79,50,88,345,2};
		System.out.println(Arrays.toString(twoSum(A, 200)));
	}

}
