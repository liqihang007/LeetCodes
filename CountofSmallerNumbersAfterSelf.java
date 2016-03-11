//You are given an integer array nums and you have to return a new counts array. 
//The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
//Example:
//Given nums = [5, 2, 6, 1]
//To the right of 5 there are 2 smaller elements (2 and 1).
//To the right of 2 there is only 1 smaller element (1).
//To the right of 6 there is 1 smaller element (1).
//To the right of 1 there is 0 smaller element.
//Return the array [2, 1, 1, 0].



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
	
    /*Before I actually get into the solution, let me first ask the question: given two integers, how would you determine which one is larger and which is smaller?
    Oh, you would say, use the built-in relational operators that come with the programming languages. True, it will give you the right answer, at a relatively higher level. But now imagine you were the computer, how would you actually do the comparison? Remember now all you can see are two series of binary bits representing the two integers. You have no better ways but start from the most significant bit and check bit by bit towards the least significant bit. The first bit will tell you the sign of the two numbers and you know positive numbers (with sign bit value of 0) will be greater than negative numbers (with sign bit value 1). If they have the same sign, then you continue to the next bit with the idea in mind that numbers with bit value 1 will be greater than those with bit value 0. You compare the two series of binary bits in this manner until at some point you can distinguish them or end up with no more bits to check(means the two integers are equal).
        What if we have an array of integers? It doesn't matter. We can proceed in the same way. First check the sign of each integer and partition them into two groups: positive integers and negative ones. Then for each group, we partition the integers further into two groups depending on the next-bit value: those with bit value 1 and those with bit value 0 (To unify sign partition and other bits partition, we will call the two groups after every partition as "highGroup" and "lowGroup" to indicate that all the integers in the highGroup will be greater than those in the lowGroup). And so on until we either have no numbers to partition or no bits to check. (Here we assume the integers have finite length of bits)
            Now let's turn to our problem: for each integer in an array, count the number of integers to its right that are smaller than it. Based on the analysis above, we divide the integers into highGroup and lowGroup according to either the sign bit or other-bits. Since for each integer in the array, we only care about integers to its right, it would be better if we do the partition from right to left of the array. For each integer in the highGroup currently being checked, we know it will be greater than all those in the lowGroup accumulated so far. We proceed in this fashion until either the group is empty or have no more bits to check.
            Notes:
            To unify sign bit partition and other-bits partition, we used a variable called "highBit" to distinguish these two cases.
            we store the indices of the elements instead of the elements themselves as it's easier to set the results;
            I reversed the order of the elements when adding them to the list due to list performance consideration.
            The time complexity can be analyzed as follows:
            Let T(n) be the total run time and after the partition, we have bn number in one group and (1-b)n in the other with 0 <= b <= 1. Now the original problem is divided into two smaller subproblems with size given by bn and (1-b)n. And the solution to the original problem can be obtained by combining the solutions to the two subproblems in O(n) time, then we have:
            T(n) = T(bn) + T((1-b)n) + O(n)
            The solution to the characteristic equation b^x + (1-b)^x = 1 is x = 1 so the runtime complexity will be O(nlogn) according to the master theorem (one tricky scenario is b = 0 or b = 1. In this case the runtime is essentially linear provided the total number of bits in each integer is constant). By the way the space complexity is apparently O(n) due to the partition.*/
            
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);
        List<Integer> index = new ArrayList<>(nums.length);
        
        for (int i = nums.length - 1; i >= 0; i--) {
            res.add(0);
            index.add(i);
        }
        
        countSmallerSub(nums, index, 1 << 31, res);
        
        return res;
    }
    
    private void countSmallerSub(int[] nums, List<Integer> index, int mask, List<Integer> res) {
        if (mask != 0 && index.size() > 1) {
            List<Integer> highGroup = new ArrayList<>(index.size());
            List<Integer> lowGroup = new ArrayList<>(index.size());
            
            int highBit = (mask < 0 ? 0 : mask);
            
            for (int i = 0; i < index.size(); i++) {
                if ((nums[index.get(i)] & mask) == highBit) {
                    res.set(index.get(i), res.get(index.get(i)) + lowGroup.size());
                    highGroup.add(index.get(i));
                } else {
                    lowGroup.add(index.get(i));
                }
            }
            
            countSmallerSub(nums, lowGroup, mask >>> 1, res);
            countSmallerSub(nums, highGroup, mask >>> 1, res);
        }
    }

    
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
//    public List<Integer> countSmaller(int[] nums) {
//        int[] ans = new int[nums.length];
//        Node root = null;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            root = insert(nums[i], root, ans, i, 0); // value, last node, ans[], index, sum of .left
//        }
//        List<Integer> res = new ArrayList<Integer>();
//        for (int i = 0; i < ans.length; i++)
//            res.add(ans[i]);
//        return res;
//    }
//    
//    private Node insert(int num, Node node, int[] ans, int i, int preSum) {
//        if (node == null) { // for new node
//            node = new Node(num, 0);
//            ans[i] = preSum;
//        } else if (node.val == num) {
//            node.dup++;
//            ans[i] = preSum + node.sum;
//        } else if (node.val > num) {
//            node.sum++;
//            node.left = insert(num, node.left, ans, i, preSum);
//        } else { // node.val < num
//            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
//        }
//        return node;
//    }

}
