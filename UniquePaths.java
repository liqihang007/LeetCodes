
public class UniquePaths {

	public static int uniquePaths(int m, int n) 
    {
		if(m==0 || n==0)
		{
			return 0;
		}
		if(m==1 || n==1)
		{
			return 1;
		}
		else
		{
			int[][] table=new int[m][n];
			for (int i=0;i<m;i++)
			{
				table[i][0]=1;
			}
			for (int j=0;j<n;j++)
			{
				table[0][j]=1;
			}
			for (int i=1;i<m;i++)
			{
				for (int j=1;j<n;j++)
				{
					table[i][j]=table[i-1][j]+table[i][j-1];
				}
			}
			return table[m-1][n-1];
		}
    }
	
	public static void main(String[] args) 
	{
//		int[][] xx=new int[][]{{1,2,3,4,2,4},{2,4,1,3,4,1},{1,2,2,1,4,5}};
//		int[][] xx=new int[][]{{1}};
		int x=uniquePaths(3,3);
		System.out.println(x);

	}

}
