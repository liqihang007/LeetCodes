//Given an index k, return the kth row of the Pascal's triangle.
//For example, given k = 3,
//Return [1,3,3,1].

import java.util.*;

public class PascalsTriangle2 {

	public static List<Integer> getRow(int rowIndex) {  // row[i]= row[i-1]<<1 + row[i-1]>>1
		List<Integer> rowlist = new ArrayList<Integer>();
		if(rowIndex>=0){
			rowlist.add(1);
			for (int i=1;i<rowIndex+1;i++){
				int[] row=new int[i+1];
				int[] rowL=new int[i+1];
				int[] rowR=new int[i+1];
				for (int j=0;j<rowlist.size();j++){
					rowL[j]=rowlist.get(j);
					rowR[j+1]=rowlist.get(j);
				}
				rowL[i]=0;
				rowR[0]=0;
				List<Integer> rowlistnew = new ArrayList<Integer>();
				for (int j=0;j<i+1;j++){
					row[j]=rowL[j]+rowR[j];
					rowlistnew.add(row[j]);
				}
				rowlist=rowlistnew;
			}
		}
        return rowlist;
    }
	public static void main(String[] args) {
		System.out.println(getRow(6));
	}

}
