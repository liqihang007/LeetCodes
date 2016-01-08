import java.util.Arrays;

//Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//For example,
//Given [3,2,1,5,6,4] and k = 2, return 5.
//Note: 
//You may assume k is always valid, 1 <= k <= array's length.

/*The basic idea is to use Quick Select algorithm to partition the array with pivot:
Put numbers < pivot to pivot's left
Put numbers > pivot to pivot's right
Then
if indexOfPivot == k, return A[k]
else if indexOfPivot < k, keep checking left part to pivot
else if indexOfPivot > k, keep checking right part to pivot
until get the kth smallest number. Because we throw away half of the array, 
so the time complexity is O(nlgn) in average; O(n^2) in the worst case, 
if the pivot can only partition one element each time.*/

// refer to AllSortAlgorithms

public class KthLargestElementinanArray {

	public int findKthLargest(int[] nums, int k) {
        if(nums.length==1) return nums[0];
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

}
