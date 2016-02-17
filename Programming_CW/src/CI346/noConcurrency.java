package CI346;

public class noConcurrency {
	public static void noConcurrencyPrime(int primeValue) {
		int primeCount = 0;
		long startTimer = System.nanoTime();
		for (int i = 2; i < primeValue; i++) {
			boolean isPrimeNumber = true;
			if (i % 2 == 0) 
			{
				if (i == 2) 
				{
					primeCount++;
				}
			} else {
				for (int j = 3; j < i; j += 2) 
				{
					if (i % j == 0) 
					{
						isPrimeNumber = false;
						break;
					}
				}
				if (isPrimeNumber) 
				{
					primeCount++;
				}
			}
		}
		long stopTimer = System.nanoTime();
		double tt = (double) (stopTimer - startTimer) / 1000000000;
		System.out.println("There are " + primeCount
				+ " prime numbers between 1 and " + primeValue);
		System.out.printf("The program took %.5f seconds to execute\n\n\n", tt);
	}
}