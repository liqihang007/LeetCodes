//Serialization is the process of converting a data structure or object into a sequence of bits so that 
//it can be stored in a file or memory buffer, or transmitted across a network connection link to be 
//reconstructed later in the same or another computer environment.
//Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your 
//serialization/deserialization algorithm should work. 
//You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized 
//to the original tree structure.For example, you may serialize the following tree
//    1
//   / \
//  2   3
//     / \
//    4   5
//as "[1,2,3,null,null,4,5]"

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

public class SerializeandDeserializeBinaryTree {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    serializeHelper(root,result);
	    return result.toString();
	}

	private void serializeHelper(TreeNode root, ArrayList<Integer> result){
	    if (root == null) {
	        result.add(null);
	        return;
	    }
	    result.add(root.val);
	    serializeHelper(root.left,result);
	    serializeHelper(root.right,result);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
	    String[] strArray = data.substring(1,data.length()-1).split(", ");
	    Deque<String> strList = new LinkedList<String>(Arrays.asList(strArray)); 
	    return deserializeHelper(strList);
	}

	private TreeNode deserializeHelper(Deque<String> strList){
	    if (strList.size() == 0) return null;
	    String str = strList.pop();
	    if (str.equals("null")) return null;
	    TreeNode currentRoot = new TreeNode(Integer.parseInt(str));
	    currentRoot.left = deserializeHelper(strList);
	    currentRoot.right = deserializeHelper(strList);
	    return currentRoot;
	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));
}
