//Find the total area covered by two rectilinear rectangles in a 2D plane.
//Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
//Rectangle Area https://leetcode.com/problems/rectangle-area/
//Assume that the total area is never beyond the maximum possible value of int.

public class RectangleArea {

	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area=Math.abs(A-C)*Math.abs(B-D)+Math.abs(E-G)*Math.abs(F-H);
		int w=overlap(A, C, E, G);
        int h=overlap(B, D, F, H);
        return area-w*h;
    }
	
	public static int overlap(int a, int b, int c, int d){
		if(a>b){
			int tmp=b;
			b=a;
			a=tmp;
		}
		if(c>d){
			int tmp=d;
			d=c;
			c=tmp;
		}
		a=Math.max(a, c);
		b=Math.min(b, d);
		return a>b? 0 : b-a;
	}

	public static void main(String[] args) {
		System.out.println(computeArea(-3,0,3,4,0,-1,9,2));
		System.out.println(computeArea(0,0,0,0,-1,-1,1,1));
	}

}
