import java.math.BigDecimal;

public class Interviews {

	public BigDecimal getCalculatedAvailableBalance() {
		BigDecimal result = new BigDecimal("0.00");
		System.out.println("The calculated result is " + result);
		return result;
	}
	
	public BigDecimal getCalculatedAvailableBalance(BigDecimal currentBalance, BigDecimal totalDebits, BigDecimal totalCredits) {
		BigDecimal result = currentBalance.subtract(totalDebits).add(totalCredits);
		System.out.println("The calculated result is " + result);
		return result;
	}

	public static void main(String[] args) {
		new Interviews().getCalculatedAvailableBalance();
	    new Interviews().getCalculatedAvailableBalance(new BigDecimal("1250.00"), new BigDecimal("250.00"), new BigDecimal("500.00"));
	}
} 


