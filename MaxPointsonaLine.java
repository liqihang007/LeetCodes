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
