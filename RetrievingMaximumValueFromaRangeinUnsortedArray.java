//Given an unsorted array nums[] in the size of n, and two pointers, i and j. 
//Find the maximum value between a[i] to a[j]. The function would be called frequently, 
//so you can preprocess the inputs and your query function needs to run very fast.

import java.util.*;

public class RetrievingMaximumValueFromaRangeinUnsortedArray {

/*
    nums[] -> input array, eg: 10, 6, 9, 5, 2, 7, 8, 1
    tree[] -> segment tree, eg:
           10
       10       8
     10   9   7   8
    10 6 9 5 2 7 8 1
    as:[10, 10, 8, 10, 9, 7, 8, 10, 6, 9, 5, 2, 7, 8, 1]
  	build tree: log(N)
  	find max: log(N)
*/
	int tree[];
	
	public int findMax(int[] nums, int i, int j){
		if (i > j) {
			int tmp = j;
			j = i;
			i = tmp;
		}
		i = Math.max(0, i);
		j = Math.min(nums.length-1, j);
		if (tree == null){
			// I'm getting stuck to compute the size of the B-tree, maybe we can optimize this later
			int treesize = 2 << (int)Math.ceil(Math.log(nums.length) / Math.log(2));
			tree = new int[treesize - 1];
			buildTree(tree, nums, 1, 0, nums.length-1);
		}
		return getMin(tree, 1, 0, tree.length-1, i, j);
	}
	
	public void buildTree(int[] tree, int[] nums, int node, int a, int b) {
	    if (a == b)
	        tree[node - 1] = nums[a];
	    else {
	        int left = 2 * node; // left child
	        int right = left + 1; // right child
	        int mid = (a + b) / 2;
	        buildTree(tree, nums, left, a, mid); 
	        buildTree(tree, nums, right, mid+1, b); 
	        tree[node - 1] = Math.max(tree[left - 1], tree[right - 1]); 
	    }
	}
	
	public static int getMin(int[]tree, int node, int a, int b, int i, int j) {
	    if (b<i || a>j) // out of boundary
	        return Integer.MIN_VALUE; // return MIN_VALUE since getMin will compare with other returns 
	    else if (i>=a && b>=j) // inside the range and return the root of the subtree
	        return tree[node-1];
	    int left = 2*node;
	    int right = left+1;
	    int mid = (a+b)/2;
	    return Math.max(getMin(tree, left, a, mid, i, j), getMin(tree, right, mid+1, b, i, j)); 
	}
		
}
