//Given a set of edges, build a tree out of these edges.
//For example:
//            2
//           / \
//          1   3
//             /|\
//            4 5 6
//(3,4) (2,1) (3,6) (3,5) (2,3)
//You can assume that the edges form a single valid tree. No duplicate edges, no cycles, etc.

import java.util.*;

public class BuildTreebasedonEdges {

	public class Edge {
		public final int parent;
		public final int child;
		Edge(int parent, int child) {
		    this.parent = parent;
		    this.child = child;
		}
	}
		  
	class TreeNode{
		int val;
		TreeNode parent;
		List<TreeNode> children;
		TreeNode(int x){
			this.val=x;
			this.parent=null;
			children=new ArrayList<TreeNode>();
		}
	}
	
	public TreeNode buildtree(List<Edge> edges){
		HashMap<Integer, TreeNode> hash=new HashMap<Integer, TreeNode>();
		for(int i=0;i<edges.size();i++){
			TreeNode parent=new TreeNode (edges.get(i).parent);
			TreeNode child=new TreeNode (edges.get(i).child);
			if(hash.containsKey(parent.val))
				parent=hash.get(parent.val);
			if(hash.containsKey(child.val))
				child=hash.get(child.val);
			child.parent=parent;
			parent.children.add(child);
			hash.put(parent.val, parent);
			hash.put(child.val, child);
		}
		for(int i:hash.keySet()){
			if(hash.get(i).parent==null)
			return hash.get(i);
		}
		return null;
	}

}
