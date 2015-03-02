//Rotate an array of n elements to the right by k steps.
//For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
//Could you do it in-place with O(1) extra space?
		
public class RotateArray {

	public void rotate(int[] nums, int k) {
		int n = nums.length;
        k %= n;
        int toSwap = k;
        int swapped = 0;
        int j = -1;
        for (int i = n - 1; i >= 0; i -= swapped) {
            j = i;
            while (j - toSwap >= 0 && i - j < toSwap) {
                swap(nums, j - toSwap, j);
                j--;
            }
            swapped = i - j;
            if (swapped == 0) {
                return;
            }
            if (swapped != toSwap) {
                toSwap -= swapped;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t; 
    }

	public static void main(String[] args) {

	}
}
