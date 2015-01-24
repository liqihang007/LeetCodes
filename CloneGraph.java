//Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
//OJ's undirected graph serialization:
//Nodes are labeled uniquely.
//We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
//As an example, consider the serialized graph {0,1,2#1,2#2,2}.
//The graph has a total of three nodes, and therefore contains three parts as separated by #.
//First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
//Second node is labeled as 1. Connect node 1 to node 2.
//Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
//Visually, the graph looks like the following:
//       1
//      / \
//     /   \
//    0 --- 2
//         / \
//         \_/

import java.util.*;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

public class CloneGraph {
	private static HashMap<UndirectedGraphNode, UndirectedGraphNode> map;
	
	static class UndirectedGraphNode {
	      int label;
	      List<UndirectedGraphNode> neighbors;
	      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
		 }
		 
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if( node==null || node.neighbors.size()==0){return node;}
        int key=node.label;
        UndirectedGraphNode newnode= new UndirectedGraphNode(key);
        map=new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put(node, newnode);
//        dfs(node);  //	dsf
        bfs(node);	//	bsf
        return map.get(node);
    }
	
	public static void dfs(UndirectedGraphNode node){
		if(node==null){return;}
		for(UndirectedGraphNode neighbor : node.neighbors){
			if(!map.containsKey(neighbor)){
				UndirectedGraphNode newneighbor = new UndirectedGraphNode(neighbor.label);
				map.put(neighbor, newneighbor);
				dfs(neighbor);
			}
			map.get(node).neighbors.add(map.get(neighbor));
		}
	}

	public static void bfs(UndirectedGraphNode node){
		if(node==null){return;}
		ArrayList<UndirectedGraphNode> bsfset=new ArrayList<UndirectedGraphNode>();
		for(UndirectedGraphNode neighbor : node.neighbors){
			if(!map.containsKey(neighbor)){
				UndirectedGraphNode newneighbor = new UndirectedGraphNode(neighbor.label);
				map.put(neighbor, newneighbor);
				bsfset.add(neighbor);
			}
			map.get(node).neighbors.add(map.get(neighbor));
		}
		for(UndirectedGraphNode visitednodes : bsfset){
			bfs(visitednodes);
		}
	}
	
	public static void main(String[] args) {
		UndirectedGraphNode n0=new UndirectedGraphNode(0);
//		UndirectedGraphNode n1=new UndirectedGraphNode(1);
//		UndirectedGraphNode n2=new UndirectedGraphNode(2);
//		UndirectedGraphNode n3=new UndirectedGraphNode(3);
//		n2.neighbors.add(n2);
//		n1.neighbors.add(n2);
//		n1.neighbors.add(n3);
//		n0.neighbors.add(n1);
//		n0.neighbors.add(n2);
//		
		UndirectedGraphNode node=cloneGraph(n0);
		System.out.println("size is "+cloneGraph(n0).neighbors.size());
		for(int i=0;i<node.neighbors.size();i++){
			System.out.println(node.neighbors.get(i).label);
		}
	}

}
