//Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
//Example:
//(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
//(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
//Note:
//You may assume all input has valid answer.
//Follow Up:
//Can you do it in O(n) time and/or in-place with O(1) extra space?

import java.util.*;

/*Once again I sort and then spread the numbers like in this example with nums=[0,1,...,9]:
Small half:    4 . 3 . 2 . 1 . 0 .
Large half:    . 9 . 8 . 7 . 6 . 5
----------------------------------
Together:      4 9 3 8 2 7 1 6 0 5
Just write the numbers 9, 8, 7, etc at indexes 1, 3, 5, etc. 
Use modulo to wrap around for the second round (the even indexes).*/

public class WiggleSort2 {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums); // from small to large
	    int n = nums.length, mid = n%2==0? n/2-1 : n/2;
	    int[] temp = Arrays.copyOf(nums, n);
	    int index = 0;
	    for(int i=0;i<=mid;i++){
	        nums[index] = temp[mid-i]; // insert from back
	        if(index+1<n)
	            nums[index+1] = temp[n-i-1];
	        index += 2;
	    }
    }
}
