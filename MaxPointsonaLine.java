//Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

import java.util.*;

public class MaxPointsonaLine {
	
	static class Point {
		int x;
	    int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
	
	private static boolean isOnLine(Point a, Point b, Point c) {
	    return (b.y - a.y)*(c.x - a.x) == (c.y - a.y)*(b.x - a.x);
	}
	
	public static int maxPoints(Point[] points){
		if (points.length < 3) {
	        return points.length;
	    }
	    int max = 0;
	    for (int a = 0; a<points.length-2; a++) {
	        boolean[] checked = new boolean[points.length];
	        for (int b = a+1; b<points.length; b++) {

	            // Do not check the same line
	            if (checked[b]) continue;

	            // The point-b should differ from point-a
	            while (b < points.length && points[b].x == points[a].x && points[b].y == points[a].y) {
	                b++;
	            }

	            // Count all point between point-a and point-b 
	            // witch have the same coordinates as point-a
	            int count = b == points.length ? 1 : 2;
	            for (int i=a+1; i<b; i++) {
	                if (points[i].x == points[a].x && points[i].y == points[a].y) {
	                    count++ ;
	                }
	            }

	            // Count point-c if it lies on the point-a-point-b-line.
	            for (int c = b+1; c<points.length; c++) {
	                if (isOnLine(points[a], points[b], points[c])) {
	                    count++ ;
	                    checked[c] = true;
	                }
	            }
                max=Math.max(count,max);
	        }
	    }
	    return max;
	}

	
//	static class Line{
//		float a;
//		float b;
//		public Line(Point A, Point B){
//			if(A.x==B.x && A.y==B.y){
//				this.a= 0.0f;
//				this.b= 0.0f;
//			}
//			else{
//				if(A.x==B.x){
//					this.a=Float.MAX_VALUE;
//				}
//				else{
//					this.a=(B.y-A.y)/(B.x-A.x);
//				}
//				if(this.a==Float.MAX_VALUE){
//					this.b=A.x;
//				}
//				else{
//					this.b=A.y-this.a*A.x;
//				}
//			}
//		}
//		public int hashCode(){
//			return String.valueOf(this.a).hashCode()*String.valueOf(this.b).hashCode();
//		}
//		public boolean equals(Object obj) {   
//	       if (this == obj) {               
//	              return true;                  
//	       }         
//	       if (!(obj instanceof Line)) {  
//	             return false;               
//	       }    
//	       
//	       Line p = (Line) obj;  
//	      
//	       if (String.valueOf(this.a).equals(String.valueOf(p.a)) 
//	    		   && String.valueOf(this.b).equals(String.valueOf(p.b))) {              
//	           return true ;                  
//	       }
//	       else{           
//	           return false ;                
//	       }       
//	    }
//	}
//	
//	public static int maxPoints(Point[] points) {
//        if(points.length<=2){return points.length;}
//        for(int i=0;i<points.length;i++){
//        	points[i]=new Point(points[i].x, points[i].y){
//        		@Override
//        		public int hashCode(){
//        			return String.valueOf(this.x).hashCode()*String.valueOf(this.y).hashCode();
//        		}
//        		public boolean equals(Object obj) {
//        			Point p=(Point) obj;
//        			if(this.x==p.x && this.y==p.y){
//        				return true;
//        			}
//        			else{
//        				return false;
//        			}     
//        	    }
//        	};
//        }
//        HashMap <Line, HashSet<Integer>> lines = new HashMap <Line, HashSet<Integer>>();
//        HashMap <Point, HashSet<Integer>> dupoints = new HashMap <Point, HashSet<Integer>>();
//		for(int i=0;i<points.length-1;i++){
//        	for(int j=i+1;j<points.length;j++){
//        		if(points[i].equals(points[j])){ // same point
//        			if(dupoints.containsKey(points[i])){
//        				HashSet<Integer> temp = dupoints.get(points[i]);
//        				temp.add(i);
//        				temp.add(j);
//        				dupoints.put(points[i], temp);
//        			}
//        			else{
//        				HashSet<Integer> temp = new HashSet<Integer>();
//        				temp.add(i);
//        				temp.add(j);
//        				dupoints.put(points[i], temp);
//        			}
//        			continue;
//        		}
//        		Line line=new Line(points[i],points[j]);
//    			if(lines.containsKey(line)){
//    				HashSet<Integer> temp = lines.get(line);
//    				temp.add(i);
//    				temp.add(j);
//    				lines.put(line, temp);
//    			}
//    			else{
//    				HashSet<Integer> temp = new HashSet<Integer>();
//    				temp.add(i);
//    				temp.add(j);
//    				lines.put(line, temp);
//    			}
//        	}
//        }
//        int res=0;
//        if(lines.size()>0){
//	        for(Line linekey : lines.keySet()){
//	        	System.out.println(linekey.a+" "+linekey.b+" "+lines.get(linekey).size());
//	        	for(Point point : dupoints.keySet()){
//	        		if(linekey.a*point.x+linekey.b==point.y || 
//	        				(linekey.a==Float.MAX_VALUE && linekey.b==point.x)){
//	        			HashSet<Integer> temp = lines.get(linekey);
//	        			temp.addAll(dupoints.get(point));
//	        			lines.put(linekey, temp);
//	        		}
//	        	}
//	        	if(lines.get(linekey).size()>res){
//	        		res=lines.get(linekey).size();
//	        	}
//	        }
//	        return res;
//	    }
//        else{
//        	return dupoints.get(points[0]).size();
//        }
//    }
	
	public static void main(String[] args){
		Point p1=new Point(84,250);
		Point p2=new Point(0,0);
		Point p3=new Point(1,0);
		Point p4=new Point(0,-70);
		Point p5=new Point(0,-70);
		Point p6=new Point(1,-1);
		Point p7=new Point(21,10);
		Point p8=new Point(42,90);
		Point p9=new Point(-42,-230);

		Point [] points=new Point[]{p1,p2,p3,p4,p5,p6,p7,p8,p9};
		System.out.println(maxPoints(points));
	}

}
