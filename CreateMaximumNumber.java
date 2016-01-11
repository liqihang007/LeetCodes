//Given two arrays of length m and n with digits 0-9 representing two numbers. 
//Create the maximum number of length k <= m + n from digits of the two. 
//The relative order of the digits from the same array must be preserved. Return an array of the k digits. 
//You should try to optimize your time and space complexity.
//Example 1:
//nums1 = [3, 4, 6, 5]
//nums2 = [9, 1, 2, 5, 8, 3]
//k = 5
//return [9, 8, 6, 5, 3]
//Example 2:
//nums1 = [6, 7]
//nums2 = [6, 0, 4]
//k = 5
//return [6, 7, 6, 0, 4]
//Example 3:
//nums1 = [3, 9]
//nums2 = [8, 9]
//k = 3
//return [9, 8, 9]

/*Solution
To solve this problem, first let's look at simpler version:
Easy Version No. 1
Given one array of length n, create the maximum number of length k.
The solution to this problem is Greedy with the help of stack. The recipe is as following
Easy Version No. 2
Given two array of length m and n, create maximum number of length k = m + n.
OK, this version is a lot closer to our original problem with the exception that we will use all the digits we have.
Still, for this version, Greedy is the first thing come to mind. We have k decisions to make, each time will just 
need to decide ans[i] is from which of the two. It seems obvious, we should always choose the larger one right? 
This is correct, but the problem is what should we do if they are equal?
This is not so obvious. The correct answer is we need to see what behind the two to decide. For example,
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
ans = [6, 7, 6, 0, 4]
We decide to choose the 6 from nums1 at step 1, because 7 > 0. What if they are equal again? 
We continue to look the next digit until they are not equal. If all digits are equal then choose any one is ok.
The procedure is like the merge in a merge sort. However due to the "look next until not equal", 
the time complexity is O(nm).
Final Solution
Now let's go back to the real problem. First, we divide the k digits required into two parts, 
i and k-i. We then find the maximum number of length i in one array and the maximum number of 
length k-i in the other array using the algorithm in section 1. Now we combine the two results 
in to one array using the algorithm in section 2. After that we compare the result with the result
we have and keep the larger one as final answer.
The algorithm is O((m+n)^3) in the worst case. It runs in 22 ms.
*/

public class CreateMaximumNumber {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
	    int n = nums1.length;
	    int m = nums2.length;
	    int[] ans = new int[k];
	    for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
	        int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
	        if (greater(candidate, 0, ans, 0)) ans = candidate;
	    }
	    return ans;
	}
	private int[] merge(int[] nums1, int[] nums2, int k) {
	    int[] ans = new int[k];
	    for (int i = 0, j = 0, r = 0; r < k; ++r)
	        ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
	    return ans;
	}
	public boolean greater(int[] nums1, int i, int[] nums2, int j) {
	    while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
	        i++;
	        j++;
	    }
	    return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
	}
	public int[] maxArray(int[] nums, int k) {
	    int n = nums.length;
	    int[] ans = new int[k];
	    for (int i = 0, j = 0; i < n; ++i) {
	        while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
	        if (j < k) ans[j++] = nums[i];
	    }
	    return ans;
	}
}
