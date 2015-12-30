//Count the number of prime numbers less than a non-negative number, n.

//Once we find a prime number i, then mark the composite numbers: 
//i*i, i*i+i, i*i+i*2 .. i*i+i*k < n

public class CountPrimes {

	public static int countPrimes(int n) {
		boolean isComposite[] = new boolean[n];// isComposite[i]: If i is a composite number
	    int count = 0;
	    for (int i = 2; i < n; i++) {  
	        if (!isComposite[i]) { 
	            count++; 
	            if (i < Math.sqrt(n))
	                for (int j = i * i; j < n; j += i)  
	                    isComposite[j] = true;// Mark j as a composite number
	        }
	    }
	    return count;
    }

	public static void main(String[] args) {
		System.out.println(countPrimes(7));
	}

}
