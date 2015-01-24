
public class UniquePathsII {

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) 
    {
		if (obstacleGrid==null)
		{
			return 0;
		}
		int m=obstacleGrid.length, n=obstacleGrid[0].length;
//		if(m==0 || n==0)
//		{
//			return 0;
//		}
		if(m==1 && n==1)
		{
			if(obstacleGrid[0][0]==0)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		else
		{
			int[][] table=new int[m][n];
			for (int i=0;i<m;i++)
			{
				for (int j=0;j<n;j++)
				{
					table[i][j]=0;
				}
			}
			for (int i=0;i<m;i++)
			{
				if (obstacleGrid[i][0]==0)
				{
					table[i][0]=1;
				}
				else
				{
					break;
				}
			}
			for (int j=0;j<n;j++)
			{
				if (obstacleGrid[0][j]==0)
				{
					table[0][j]=1;
				}
				else
				{
					break;
				}
			}
			for (int i=1;i<m;i++)
			{
				for (int j=1;j<n;j++)
				{
					if(obstacleGrid[i][j]!=1)
					{
						if(obstacleGrid[i-1][j]==1 || table[i-1][j]==0)
						{
							if(obstacleGrid[i][j-1]==1 || table[i][j-1]==0)
							{
								table[i][j]=0;
							}
							else
							{
								table[i][j]=table[i][j-1];
							}
							table[i][j]=Math.max(table[i-1][j],table[i][j-1]);
						}
						else
						{
							if(obstacleGrid[i][j-1]==1 || table[i][j-1]==0)
							{
								table[i][j]=table[i-1][j];
							}
							else
							{
								table[i][j]=table[i-1][j]+table[i][j-1];
							}
						}
					}
				}
			}
//			System.out.println(table[0][0]+""+table[0][1]+""+table[0][2]+""+table[0][3]);
//        	System.out.println(table[1][0]+""+table[1][1]+""+table[1][2]+""+table[1][3]);
//        	System.out.println(table[2][0]+""+table[2][1]+""+table[2][2]+""+table[2][3]);
			return table[m-1][n-1];
		}
    }

	public static void main(String[] args) 
	{
		int[][] xx=new int[][]{{0,1}};
//		int[][] xx=new int[][]{{1}};
		int x=uniquePathsWithObstacles(xx);
		System.out.println(x);

	}
}
