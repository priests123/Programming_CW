package CI346;

public class noConcurrency {
	
	static int primeCount = 0;
	
	public static void noConcurrencyPrime(int primeStart, int primeEnd) 
	{
		for (int a = primeStart; a < primeEnd; a++) {
			boolean isPrimeNumber = true;
			if (a % 2 == 0) 
			{
				if (a == 2) 
				{
					primeCount++;
				}
			} else {
				for (int b = 3; b < a; b += 2) 
				{
					if (a % b == 0) 
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
	}
	
	public static int getCount()
	{
		return primeCount;
	}
	
}
