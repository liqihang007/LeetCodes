//Given a set of n jobs with [start time, end time, cost], find a subset so that no 2 jobs overlap and the cost is maximum.
//Let's assume the input is already sorted by start_time.

import java.util.*;

public class SchedulingJobsWithMaxCost {
	
	class Job{
		int start;
		int finish;
		int cost;
		public Job(int start, int finish, int cost){
			this.start=start;
			this.finish=finish;
			this.cost=cost;
		}
	}
	
	public int schedulingJobsWithMaxCost_DP(Job[] jobs) { // DP
	    int size=jobs.length;
	    int[] dp = new int[size];
	    dp[size - 1] = jobs[size - 1].cost;
	    for (int k = size - 2; k >= 0; k--) {
	        int next = findNextJob(jobs, k); // find next available job after kth one
	        int includeK = jobs[k].cost;
	        if (next < size) {
	            includeK += dp[next]; // include job[k]
	        }
	        int excludeK = dp[k + 1]; // exclude job[k]
	        dp[k] = Math.max(includeK, excludeK);
	    }
	    return dp[0];
	}

	public int findNextJob(Job[] jobs, int k) {
	    int finishTime = jobs[k].finish;
	    int next = k + 1;
	    while (next < jobs.length) {
	        if (jobs[next].start < finishTime) {next++;} 
	        else {break;}
	    }
	    return next;
	}
	
//	public int schedulingJobsWithMaxCost_Rec(Job[] jobs) {	// recursion
//		if(jobs==null || jobs.length==0){return 0;}
//		return recursion(jobs,0);
//	}
//	
//	public int recursion(Job[] jobs, int k) {
//	    if (k >= jobs.length) {return 0;}
//	    int next = findNextJob(jobs, k);
//	    int includeK = jobs[k].cost + recursion(jobs, next);
//	    int excludeK = recursion(jobs, k + 1);
//	    return Math.max(includeK, excludeK);
//	}
	
	public static void main(String[] args) {
		
	}
}
