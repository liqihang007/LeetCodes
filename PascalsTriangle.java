import java.util.*;

public class PascalsTriangle {

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(numRows>0){
			List<Integer> rowlist = new ArrayList<Integer>();
			rowlist.add(1);
			result.add(rowlist);
			for (int i=1;i<numRows;i++){
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
				result.add(rowlistnew);
				rowlist=rowlistnew;
			}
		}
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println(generate(2));
	}

}
