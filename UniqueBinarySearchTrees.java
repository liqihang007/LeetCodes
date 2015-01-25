//Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
//For example, Given n = 3, there are a total of 5 unique BST's.
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3

// Catalan number
//F(0) = 1
//F(n) = F(0) * F(n-1) + F(1) * F(n-2) + F(2) * F(n-3) + ... + F(n-2) * F(1) + F(n-1) * F(0)

public class UniqueBinarySearchTrees { 

	public static int numTrees(int n) {
        if(n==0){return 0;}
        int[]A=new int[n+1];
        A[0]=1;
        A[1]=1;
        for(int i=2;i<n+1;i++){
        	int temp=0;
        	for(int j=0;j<i;j++){
        		temp+=A[j]*A[i-j-1];
        	}
        	A[i]=temp;
        }
        return A[n];
    }

	public static void main(String[] args) {
		System.out.println(numTrees(4));
	}

}
