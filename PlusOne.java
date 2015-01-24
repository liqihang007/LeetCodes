import java.util.Arrays;


public class PlusOne {

	public static int[] plusOne(int[] digits) {
		if(digits.length==1){
			if (digits[0]==9){
				int[] res={1,0};
				return res;
			}
			else{
				digits[0]+=1;
				return digits;
			}
		}
		else{
			return rec(digits, digits.length-1);
		}
	}
	
	public static int[] rec(int[] digits, int i){
		if (i==0){
			if(digits[0]==9){
				int[] res=new int[digits.length+1];
				for (int j=2;j<digits.length+1;j++){
					res[j]=digits[j-1];
				}
				res[0]=1;
				res[1]=0;
				return res;
			}
			else{
				digits[0]+=1;
				return digits;
			}
		}
		if (digits[i]==9){
			digits[i]=0;
			return rec(digits,i-1);
		}
		else{
			digits[i]+=1;
			return digits;
		}
	}
	
	public static void main(String[] args) {
		int[] A={8,9,9,9};
		System.out.println(Arrays.toString(plusOne(A)));
	}

}
