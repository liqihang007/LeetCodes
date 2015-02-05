//Binary search is a famous question in algorithm.
//For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
//If the target number does not exist in the array, return -1.
//Example
//If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
		
public class BinarySearch {

	public static int binarySearch(int[] nums, int target) {
        return bst(nums,target,0,nums.length);
    }
    
    public static int bst(int[] nums, int tar, int a, int b){
        while(a<b){
            int mid=(a+b)/2;
            if(tar<=nums[mid]){
                b=mid;
            }
            else{
                a=mid+1;
            }
        }
        if(nums[a]==tar)
            return a;
        else
            return -1;
    }
    
	public static void main(String[] args) {
		System.out.println(binarySearch(new int[]{1, 2, 3, 3, 4, 5, 10},1));
	}

}
