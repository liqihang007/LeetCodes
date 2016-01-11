//You are given an integer array nums and you have to return a new counts array. 
//The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
//Example:
//Given nums = [5, 2, 6, 1]
//To the right of 5 there are 2 smaller elements (2 and 1).
//To the right of 2 there is only 1 smaller element (1).
//To the right of 6 there is 1 smaller element (1).
//To the right of 1 there is 0 smaller element.
//Return the array [2, 1, 1, 0].

/*Every node will maintain a val sum recording the total of number on it's left bottom side, 
dup counts the duplication. For example, [3, 2, 2, 6, 1], from back to beginning,we would have:
                1(0, 1)
                     \
                     6(3, 1)
                     /
                   2(0, 2)
                       \
                        3(0, 1)
When we try to insert a number, the total number of smaller number would be adding dup and 
sum of the nodes where we turn right. for example, if we insert 5, it should be inserted on 
the way down to the right of 3 as [5,3,2,2,6,1], the nodes where we turn right is 1(0,1), 2,(0,2), 3(0,1), 
so the answer should be (0 + 1)+(0 + 2)+ (0 + 1) = 4, if we next insert 7, 
as [7,5,3,2,2,6,1], the right-turning nodes are 1(0,1), 6(3,1), so answer should be (0 + 1) + (3 + 1) = 6
*/

import java.util.*;

public class CountofSmallerNumbersAfterSelf {
	
	class Node {
        Node left, right;
        int val, sum, dup = 1;
        public Node(int v, int s) {
            val = v;
            sum = s;
        }
    }
	
    public List<Integer> countSmaller(int[] nums) {
        int[] ans = new int[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0); // value, last node, ans[], index, sum of .left
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < ans.length; i++)
            res.add(ans[i]);
        return res;
    }
    
    private Node insert(int num, Node node, int[] ans, int i, int preSum) {
        if (node == null) { // for new node
            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.sum;
        } else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else { // node.val < num
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }

}
