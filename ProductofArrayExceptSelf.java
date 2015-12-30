//Given an array of n integers where n > 1, nums, return an array output such that output[i] 
//is equal to the product of all the elements of nums except nums[i].
//Solve it without division and in O(n).
//For example, given [1,2,3,4], return [24,12,8,6].
//Follow up:
//Could you solve it with constant space complexity? 
//(Note: The output array does not count as extra space for the purpose of space complexity analysis.)
		
public class ProductofArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int left=1, right=1;
        int []res=new int[n];
        for(int i=0;i<n;i++){
        	res[i]=left;
        	left*=nums[i];
        }
        for(int i=n-1;i>=0;i--){
        	res[i]*=right;
        	right*=nums[i];
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
