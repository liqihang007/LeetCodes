//Given a BST, write a function that returns true if there is a triplet that sums to 0, returns false otherwise.

import java.util.*;

public class BinarySearchTree3Sum {
	class Node{
		int val;
		Node left;
		Node right;
//		Node parent;
		public Node(int x){
			this.val=x;
			this.left=null;
			this.right=null;
//			this.parent=?
		}
	}
	
	public boolean BinarySearchTree3Sum(Node root, int tar){
		if(root==null){return false;}
		List<Integer>bstList=new ArrayList<Integer>();
		convert(root, bstList);
		if(bstList.size()<3){return false;}
		int[]bstArr=new int[bstList.size()];
		for(int i=0;i<bstList.size();i++){
			bstArr[i]=bstList.get(i);
		}
		return check3sum(bstArr, tar);
	}
	
	public void convert(Node node, List<Integer>bst){
		if(node==null){return;}
		convert(node.left, bst);
		bst.add(node.val);
		convert(node.right, bst);
	}
	
	public boolean check3sum(int[]num, int tar){
		for(int i=0;i<num.length-2;i++){
			int left=i+1;
			int right=num.length-1;
			while(left<right){
				if(num[left]+num[right]+num[i]==tar){
//					if need output, store i, left, right here
					return true;
				}
				if(num[left]+num[right]+num[i]>tar){
					right--;
				}
				if(num[left]+num[right]+num[i]<tar){
					left++;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
//		int[] A={-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
//		System.out.println(x);
	}
}
