package CI346;

public class explicitConcurrency implements Runnable{
	
	private static int primeCount = 0;
	int start = 0;
	int end = 0;

	public explicitConcurrency(int startValue, int endValue) {
		start = startValue;
		end = endValue;
	}

	@Override
	public void run() {
		for (int a = start; a < end; a++) {
			boolean isPrimeNumber = true;
			if (a % 2 == 0) 
			{
				if (a == 2) 
				{
					addCount();
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
					addCount();
				}
			}
		}
	}
	
	public static int getCount()
	{
		return primeCount;
	}
	
	public static synchronized void addCount()
	{
		primeCount++;
	}
	
}
