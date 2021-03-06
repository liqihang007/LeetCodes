//Given a collection of intervals, merge all overlapping intervals.
//For example,
//Given [1,3],[2,6],[8,10],[15,18],
//return [1,6],[8,10],[15,18].

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

import java.util.*;

public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<=1)
        	return intervals;
    	List<Interval> set=new ArrayList<Interval>();
    	Collections.sort(intervals, new Comparator<Interval>(){ // sort the first number
    		@Override
    		public int compare(Interval i1, Interval i2){
    			return Integer.compare(i1.start, i2.start);
    		}
    	});
    	int start=intervals.get(0).start;
    	int end=intervals.get(0).end;
    	for(int i=1;i<intervals.size();i++){
    		if(intervals.get(i).start <= end){
    			end=Math.max(end, intervals.get(i).end);
    		}
    		else{
    			set.add(new Interval(start,end));
    			start=intervals.get(i).start;
    			end=intervals.get(i).end;
    		}
    	}
    	set.add(new Interval(start,end));
    	return set;
    }

}
