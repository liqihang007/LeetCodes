//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//For example, given the following triangle
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

import java.util.*;

public class Triangle {
//	DP:
	public static int minimumTotal(List<List<Integer>> triangle) {
		int myreturn=0;
		if(triangle!=null && triangle.size()>=1){
			if(triangle.size()==1){
				return triangle.get(0).get(0);
			}
			else{
				int p=triangle.get(triangle.size()-1).size();
				int[][] sum=new int[p][p];
				for(int i=0;i<p;i++){
					sum[p-1][i]=triangle.get(triangle.size()-1).get(i);
				}
				for(int i=p-2;i>=0;i--){
					for (int j=i;j>=0;j--){
						sum[i][j]=triangle.get(i).get(j)+
								Math.min(sum[i+1][j],sum[i+1][j+1]);
					}
				}
				myreturn=sum[0][0];
			}
		}
		return myreturn;
	}
	
//	Recursive:
//	public static int minimumTotal(List<List<Integer>> triangle) {
//        int myreturn=0;
//        if (triangle!=null && triangle.size()>=1){
//        	if(triangle.size()==1){
//        		myreturn=triangle.get(0).get(0);
//        	}
//        	else{
//        		myreturn=getpath(triangle,0,0);
//        	}
//        	
//        }
//        return myreturn;
//    }
//
//	public static int getpath(List<List<Integer>> triangle, int level, int index){
//		int myreturn=0;
//		if(level>triangle.size()-1){
//			return myreturn;
//		}
//		else{
//			if(level==triangle.size()-1){
//				return triangle.get(level).get(index);
//			}
//			else{
//				return triangle.get(level).get(index)+
//						Math.min(getpath(triangle,level+1,index), getpath(triangle,level+1,index+1));
//			}
//		}
//	}
	
	public static void main(String[] args) {
		List<List<Integer>> triangle=new ArrayList<>();
		List<Integer> row1=new ArrayList<>();
		List<Integer> row2=new ArrayList<>();
		List<Integer> row3=new ArrayList<>();
		List<Integer> row4=new ArrayList<>();
		row1.add(2);
		triangle.add(row1);
		row2.add(3);
		row2.add(4);
		triangle.add(row2);
		row3.add(6);
		row3.add(5);
		row3.add(7);
		triangle.add(row3);
		row4.add(4);
		row4.add(1);
		row4.add(8);
		row4.add(3);
		triangle.add(row4);
		System.out.println(triangle);
		System.out.println(minimumTotal(triangle));
	}
}
