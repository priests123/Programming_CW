package CI346;

public class Main {
	public static void main(String[] args) 
	{
		int primeValue = 250000;
		noConcurrency.noConcurrencyPrime(primeValue);
		Thread t1 = new Thread(new explicitConcurrency(2, primeValue/2));
		Thread t2 = new Thread(new explicitConcurrency(primeValue/2, primeValue));
		long startTimer = System.nanoTime();
		t1.start();	
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			
		}
		long stopTimer = System.nanoTime();
		double tt = (double) (stopTimer - startTimer) / 1000000000;
		System.out.printf("The program took %.5f seconds to execute\n\n\n", tt);
		System.out.println("Value: " + explicitConcurrency.getCount());
	}
}

