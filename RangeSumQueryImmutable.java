//Given an integer array nums, find the sum of the elements between indices i and j (i<=j), inclusive.
//Example:
//Given nums = [-2, 0, 3, -5, 2, -1]
//sumRange(0, 2) -> 1
//sumRange(2, 5) -> -1
//sumRange(0, 5) -> -3
//Note:
//You may assume that the array does not change.
//There are many calls to sumRange function.
//Your NumArray object will be instantiated and called as such:
//NumArray numArray = new NumArray(nums);
//numArray.sumRange(0, 1);
//numArray.sumRange(1, 2);

public class RangeSumQueryImmutable {
	
	int [] A;
	
	public NumArray(int[] nums) {
		A=new int[nums.length+1];
        if(nums.length>0){
        	A[1]=nums[0];
        	for(int i=1;i<nums.length;i++){
        		A[i+1]=A[i]+nums[i];
        	}
        }
    }

    public int sumRange(int i, int j) {
        if(i<=j && i>=0 && j<A.length)
        	return A[j+1]-A[i];
        else
        	return 0;
    }
    

}
