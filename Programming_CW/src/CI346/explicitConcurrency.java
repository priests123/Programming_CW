package CI346;

public class explicitConcurrency implements Runnable{
	private static int primeCount = 0;
	int start = 0;
	int end = 0;
	static long startTimer = 0;
	static long stopTimer = 0;
	
	public explicitConcurrency(int startValue, int endValue) {
		start = startValue;
		end = endValue;
	}

	@Override
	public void run() {
		for (int i = start; i < end; i++) {
			boolean isPrimeNumber = true;
			if (i % 2 == 0) 
			{
				if (i == 2) 
				{
					addCount();
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
					addCount();
				}
			}
		}
	}
	
	public static int getCount(){
		return primeCount;
	}
	
	public static synchronized void addCount(){
		primeCount++;
	}
	
	public static synchronized void setStartTime(long currTime){
		startTimer = currTime;
	}
	
	public static synchronized void setEndTime(long currTime){
		stopTimer = currTime;
	}
}
