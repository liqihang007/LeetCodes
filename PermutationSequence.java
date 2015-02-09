//The set [1,2,3,...,n] contains a total of n! unique permutations.
//By listing and labeling all of the permutations in order,
//We get the following sequence (ie, for n = 3):
//"123"
//"132"
//"213"
//"231"
//"312"
//"321"
//Given n and k, return the kth permutation sequence.
//Note: Given n will be between 1 and 9 inclusive.

public class PermutationSequence {

	public String getPermutation(int n, int k) {
        String res="";
        boolean[] used=new boolean[n];
        int fac=1;
        k--;
        for(int i=1;i<n;i++)
        	fac*=i;
        for(int i=0;i<n;i++){
        	int ind=k/fac;
        	k=k%fac;
        	for(int j=0;j<n;j++){
        		if(!used[j]){
        			if(ind==0){
	        			used[j]=true;
	        			res+=(char)(j+'1');
	        			break;
        			}
        			else
        				ind--;
        		}
        	}
        	if(i<n-1)
            	fac/=(n-1-i);
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.println(new PermutationSequence().getPermutation(3,5));
	}
}
