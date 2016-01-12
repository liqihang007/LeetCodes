//Rotate an array of n elements to the right by k steps.
//For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
//Could you do it in-place with O(1) extra space?

/*The basic idea is that, for example, nums = [1,2,3,4,5,6,7] and k = 3, first we reverse [1,2,3,4], it becomes[4,3,2,1]; then we reverse[5,6,7], it becomes[7,6,5], finally we reverse the array as a whole, it becomes[4,3,2,1,7,6,5] ---> [5,6,7,1,2,3,4].

Reverse is done by using two pointers, one point at the head and the other point at the tail, after switch these two, these two pointers move one position towards the middle.*/

public class RotateArray {

    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2)
            return;
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(int[] nums, int i, int j){
        int tmp = 0;
        while(i < j){
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
    
//	public void rotate(int[] nums, int k) {
//		int n = nums.length;
//        k %= n;
//        int toSwap = k;
//        int swapped = 0;
//        int j = -1;
//        for (int i = n - 1; i >= 0; i -= swapped) {
//            j = i;
//            while (j - toSwap >= 0 && i - j < toSwap) {
//                swap(nums, j - toSwap, j);
//                j--;
//            }
//            swapped = i - j;
//            if (swapped == 0) {
//                return;
//            }
//            if (swapped != toSwap) {
//                toSwap -= swapped;
//            }
//        }
//    }
//
//    private void swap(int[] nums, int i, int j) {
//        int t = nums[i];
//        nums[i] = nums[j];
//        nums[j] = t; 
//    }

	public static void main(String[] args) {

	}
}
