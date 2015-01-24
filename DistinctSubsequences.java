
public class DistinctSubsequences {

	public static int numDistinct(String S, String T) 
	{
        if(S==null || T==null || T.length()>S.length())
        {
        	return 0;
        }
        else
        {
        	int m=T.length(), n=S.length();
        	int[][] table=new int[m][n];
        	for (int i=0;i<m;i++)
        	{
        		for(int j=0;j<n;j++)
        		{
        			table[i][j]=0;
        		}
        	}
        	if(S.charAt(0)==T.charAt(0))
        	{
        		table[0][0]=1;
        	}
        	else
        	{
        		table[0][0]=0;
        	}
        	for (int i=1;i<n;i++)
        	{
        		if(T.charAt(0)==S.charAt(i))
        		{
        			table[0][i]=table[0][i-1]+1;
        		}
        		else
        		{
        			table[0][i]=table[0][i-1];
        		}
        	}
        	for (int i=1;i<m;i++)
        	{
        		for(int j=i;j<n;j++)
        		{
        			if(S.charAt(j)==T.charAt(i))
        			{
        				table[i][j]=table[i-1][j-1]+table[i][j-1];
        			}
        			else
        			{
        				table[i][j]=table[i][j-1];
        			}
        		}
        	}
        	return table[m-1][n-1];
        }
    }
	
	public static void main(String[] args) 
	{
		String s1="acasdvvadasd";
		String s2="aasd";
		System.out.println(numDistinct(s1,s2));
		
	}

}
