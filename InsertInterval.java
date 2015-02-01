//Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//You may assume that the intervals were initially sorted according to their start times.
//Example 1:
//Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
//Example 2:
//Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
//This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

import java.util.*;

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

public class InsertInterval{

	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> res= new ArrayList<Interval>();
		if(intervals==null || intervals.size()==0){
			res.add(newInterval);
			return res;
		}
		intervals.add(newInterval);
		Collections.sort(intervals, new Comparator<Interval>(){
		     public int compare(Interval o1, Interval o2){
		         if(o1.start == o2.start)
		             return 0;
		         return o1.start < o2.start ? -1 : 1;
		     }
		});
		int bg=intervals.get(0).start;
		int end=intervals.get(0).end;
		for(int i=1;i<intervals.size();i++){
			if(intervals.get(i).start>end){
				res.add(new Interval(bg,end));
				bg=intervals.get(i).start;
				end=intervals.get(i).end;
			}
			end=Math.max(intervals.get(i).end, end);
		}
		res.add(new Interval(bg,end));
		return res;
    }
	
	public static void main(String[] args) {
		ArrayList<Interval> test=new ArrayList<Interval>();
		test.add(new Interval(1,2));
		test.add(new Interval(3,5));
		test.add(new Interval(6,7));
		test.add(new Interval(8,10));
		test.add(new Interval(12,16));
		test=insert(test,new Interval(4,9));
		for(int i=0;i<test.size();i++){
			System.out.println("["+test.get(i).start+" "+test.get(i).end+"]");
		}
	}

}
