import java.util.Arrays;
import java.util.HashSet;

public class ALL_Sort {

//	quicksort:
	public static int[] quicksort(int[]A, int p, int q){
		if(q>p){
			int m=partition(A,p,q);
			A=quicksort(A,0,m-1);
			A=quicksort(A,m+1,q);
		}
		return A;
	}
	public static int partition(int[]A, int p, int q){
		int i=p-1, temp;
		for (int j=p;j<=q-1;j++){
			if(A[j]<=A[q]){
				i=i+1;
				temp=A[j];
				A[j]=A[i];
				A[i]=temp;
			}
		}
		temp=A[q];
		A[q]=A[i+1];
		A[i+1]=temp;
		return i+1;
	}

//	
	
//	main	
	public static void main(String[] args) {
		int a = 1;
		int b = a;     // copying a value
		int[] s = {42};
		int[] t = s;
		s[0]=23;
		System.out.println(b);
		System.out.println(Arrays.toString(t));
//		String s1 = new String("Sycyhelless");
//		String s2 = new String("Sydney");
//		HashSet<Character> h1 = new HashSet<Character>(), h2 = new HashSet<Character>();
//		for(int i = 0; i < s1.length(); i++)                                            
//		{
//		  h1.add(s1.charAt(i));
//		}
//		for(int i = 0; i < s2.length(); i++)
//		{
//		  h2.add(s2.charAt(i));
//		}
//		h1.retainAll(h2);
//		Character[] res = h1.toArray(new Character[0]);
//		System.out.println(Arrays.toString(res));
//		System.out.println(s1.in);
		
//		int[]A=new int[10000];
//		for(int i=0;i<A.length;i++){
//			A[i]=(int)((Math.random()*Math.random()+Math.random())*10);
//		} 
//		System.out.println(Arrays.toString(A));
//		System.out.println(Arrays.toString(quicksort(A,0,A.length-1)));
	}

}
