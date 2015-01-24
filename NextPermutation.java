import java.util.*;

public class NextPermutation {

	public static void nextPermutation(int[] num) {
        if(num.length>1){
	        int i=num.length-1,j=i-1;
			while(num[j]>=num[i]){
				i--;j--;
				if(j<0){
					break;
				}
			}
			if (j<0){
				Arrays.sort(num);
			}
			else{
				int diff=Integer.MAX_VALUE;
				int which=j;
				for(int k=j+1;k<num.length;k++){
					if(num[k]>num[j] && num[k]-num[j]<diff){
						diff=num[k]-num[j];
						which=k;
						System.out.println(diff+" "+which);
					}
				}
				int temp=num[which];
				num[which]=num[j];
				num[j]=temp;
				int[] temparray=new int[num.length-1-j];
				for(int k=0;k<temparray.length;k++){
					temparray[k]=num[j+k+1];
				}
				Arrays.sort(temparray);
				for(int k=0;k<temparray.length;k++){
					num[j+k+1]=temparray[k];
				}
			}
        }
    }
	
	public static void main(String[] args) {
		int[]A=new int[]{5,1,1};
		nextPermutation(A);
		System.out.println(Arrays.toString(A));
	}

}
