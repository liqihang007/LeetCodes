//Topological ordering of a directed graph is a linear ordering of its vertices such that for every directed edge uv from vertex u to vertex v, u comes before v in the ordering.
//A topological ordering is possible if and only if the graph has no directed cycles, that is, if it is a directed acyclic graph (DAG).

/*
L <- Empty list that will contain the sorted elements
S <- Set of all nodes with no incoming edges
while S is non-empty do
    remove a node n from S
    add n to tail of L
    for each node m with an edge e from n to m do
        remove edge e from the graph
        if m has no other incoming edges then
            insert m into S
if graph has edges then
    return error (graph has at least one cycle)
else 
    return L (a topologically sorted order)
*/

import java.util.*;

public class TopologicalSort {

	class Node {
	    public String data;
	    public int dist;
	    public int DegreeIn;
	    LinkedList<Node> neighbor = new LinkedList<Node>();
	    public void addAdjNode(final Node Child) {
	    	neighbor.add(Child);
	        Child.DegreeIn++;
	    }
	    public Node(String data) {
	        this.data = data;
	    }
	    public int getDegreeIn() {
	        return DegreeIn;
	    }
	    public void setDegreeIn(int DegreeIn) {
	        this.DegreeIn = DegreeIn;
	    }
	    public LinkedList<Node> getNeighbor() {
	        return neighbor;
	    }
	}
	
	class Edge{
		private int dist;
		private Node src;
		private Node dest;
		public Edge(int dist, Node src, Node dest) {
		    this.dist = dist;
		    this.src = src;
		    this.dest = dest;
		    src.addAdjNode(dest);
		}
	}
	
	private int vertices;
	private Set<Node> nodes = new HashSet<Node>();
	private Set<Edge> edges = new HashSet<Edge>();
	public TopologicalSort (int vertices) {
	    this.vertices = vertices;
	}
	public void addVertex(Node node){
	    this.nodes.add(node);
	}
	public void addNodes (Set<Node> nodeList) {
	    this.nodes =  nodeList;
	}
	public void addEdge(Edge eg ){
	    this.edges.add(eg);
	}
	public  Set  topologicalSort() {
	    Queue<Node> q = new LinkedList<Node>();
	    Set<Node> topoSort = new LinkedHashSet<Node>();
	    int vertexProcessesCtr = 0;
	    for(Node m : this.nodes){
	        addToQueueToposort(m,topoSort,vertexProcessesCtr,q);
	    }
	    while(!q.isEmpty()) {
	        Node m = q.poll();
	        for(Node child : m.neighbor){
	            int indeq = child.getDegreeIn()-1;
	            child.setDegreeIn(indeq);
	            addToQueueToposort(child,topoSort,vertexProcessesCtr,q);
	        }
	    }
	    if(vertexProcessesCtr > this.vertices) {
	        System.out.println();
	    }
	    return topoSort;
	}
	
	private void addToQueueToposort(Node node, Set topoSort, int vertexProcessesCtr, Queue<Node> q) {
	    if(node.getDegreeIn()==0){
	        q.add(node);
	        ++vertexProcessesCtr;
	        topoSort.add(node);
	    }
	} 
	
	public static void main(String[] args) {
		
	}

}
