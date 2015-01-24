import java.util.ArrayList;
import java.util.List;


public class PascalsTriangle2 {

	public static List<Integer> getRow(int rowIndex) {
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
