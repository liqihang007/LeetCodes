// n jobs, each one has some dependent job, you have to begin job i after all its dependent jobs done.
// eg. n=5
//1->2,3
//3->4
//then return 4,3,2,1,5, or 5,4,3,2,1, otherwise null

import java.util.*;

public class SchedulingJobsWithDependency {

	public int[] schedulingJobsWithDependency(Map<Integer, List<Integer>> deps, int n) {
	    int[] ans = new int[n];
	    int[] depCount = new int[n];
	    // size of jobs that job i depends on, eg, i depends on job 2, 3and 5, thus depCount[i-1] = 3
	    Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
	    // graph would be reversed version of deps, used for topology sorting
	    // eg. 2 would point to 1, 3 would points to 1, 5 would points to 1
	    for (int i : deps.keySet()) {
	        depCount[i - 1] = deps.get(i).size();
	        for (int j : deps.get(i)) {	// add (j, i) pair from deps into graph
	            if (!graph.containsKey(j)) {
	                graph.put(j, new ArrayList<Integer>());
	            }
	            graph.get(j).add(i);
	        }
	    }

	    int sorted = 0;
	    while (sorted != n) {
	        int p = 0;	// first find a 'p' so that depCount[p] = 0
	        while (p < n && depCount[p] != 0) {p++;}
	        if (p == n) {break;}
	            // unable to find a new node to sort, sorting failed, then return null
	        int val = p + 1; // job's id, p is the index, the id should be +1
	        ans[sorted] = val;
	        sorted++;
	        depCount[p] = -1; // job p+1 is done
	        if (graph.containsKey(val)) {
	            for (int i : graph.get(val)) {
	                depCount[i - 1]--;	// release the jobs depends on job p+1
	            }
	        }
	    }
	    if (sorted == n)
	        return ans;
	    else
	        return null;
	}
	
	public static void main(String[] args) {
		
	}

}
