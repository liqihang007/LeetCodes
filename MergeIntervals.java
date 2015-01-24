import java.util.*;

//public class Interval {
//     int start;
//     int end;
//     Interval() { start = 0; end = 0; }
//     Interval(int s, int e) { start = s; end = e; }
//}

public class MergeIntervals {

	public static List<Interval> merge(List<Interval> intervals) {
        
        if(intervals.size()<=1){
        	return intervals;
        }
        else{
        	List<Interval> set=new ArrayList<Interval>();
        	Collections.sort(intervals, new Comparator<Interval>(){
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

	public static void main(String[] args) {
		
	}

}
