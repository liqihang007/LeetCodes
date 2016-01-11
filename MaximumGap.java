//Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
//Try to solve it in linear time/space.
//Return 0 if the array contains less than 2 elements.
//You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

/*The idea is to build a prefix tree based on the bits from high to low. Then visit all the leaves in order.
For example: [4, 2, 1 ,7], which is also [100, 010, 001, 111], can form a trie below. 
If you traverse the leaves from left to right, you get [1,2,4,7].
root
|	\
0     1
| \   | \
0  1  0  1
|  |  |  |
1  0  0  1
*/

public class MaximumGap {
	private class Trie {
        Trie[] nexts = new Trie[10];
    }

    int maxGap = 0;
    Integer prev = null;

    public int maximumGap(int[] nums) {
        Trie root = new Trie();

        // Build trie, takes O(n)
        for(int num : nums) appendNum(root, num, 1000000000);

        // dfs of the trie, takes O(n)
        maxGap = 0;
        prev = null;
        maxGapSearch(root, 0);
        return maxGap;
    }

    private void appendNum(Trie root, int num, int mask) {
        if(mask > 0) {
            int digit = num / mask;    // Can be 0, 1, 2, ..., 9
            if(root.nexts[digit] == null) 
            	root.nexts[digit] = new Trie();
            appendNum(root.nexts[digit], num % mask, mask / 10);
        }
    } 

    private void maxGapSearch(Trie root, int num) {
        if(root != null) {
            boolean isLeave = true;
            for(int i = 0; i < 10; i++) {
                if(root.nexts[i] != null) {
                    isLeave = false;
                    maxGapSearch(root.nexts[i], num * 10 + i);
                }
            }

            if(isLeave) {
                if(prev != null) maxGap = Math.max(num - prev, maxGap);
                prev = num;
            }
        }
    }
}
