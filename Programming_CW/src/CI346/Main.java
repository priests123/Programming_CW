package CI346;


import java.util.stream.Stream;

public class Main {
	
	public static void main(String[] args) throws InterruptedException 
	{
		int primeStart = 2;
		int primeEnd = 250000;
		long startTimer = 0;
		long endTimer = 0;
		
		System.out.printf("The range of numbers is between %d and %d\n\n", primeStart, primeEnd);
		
		
		//NO CONCURRENCY
		
		startTimer = System.nanoTime();
		noConcurrency.noConcurrencyPrime(primeStart, primeEnd);
		endTimer = System.nanoTime();
		System.out.printf("The no concurrency program took %s seconds to complete and found %d prime numbers\n\n\n", calculateTimeTaken(startTimer, endTimer), noConcurrency.getCount());
		
		
		//EXPLICIT CONCURRENCY
		
		Thread t1 = new Thread(new explicitConcurrency(primeStart, primeEnd/2));
		Thread t2 = new Thread(new explicitConcurrency(primeEnd/2, primeEnd));
		startTimer = System.nanoTime();
		t1.start();	
		t2.start();
		t1.join();
		t2.join();
		endTimer = System.nanoTime();
		System.out.printf("The explicit concurrency program took %s seconds to complete and found %d prime numbers\n\n\n", calculateTimeTaken(startTimer, endTimer), explicitConcurrency.getCount());
		
		
		//IMPLICIT CONCURRENCY
		
		startTimer = System.nanoTime();
		long count = Stream.iterate(primeStart , a -> a+1).parallel().limit(primeEnd - primeStart)
				.filter(b -> implicitConcurrency.calculatePrimes(b)).count();
		endTimer = System.nanoTime();
		System.out.printf("The implicit concurrency program took %s seconds to complete and found %d prime numbers\n\n\n", calculateTimeTaken(startTimer, endTimer), count);	
	}
	
	public static String calculateTimeTaken(long startTime, long endTime)
	{
		double timeTaken = (double) (endTime - startTime) / 1000000000;
		return String.format("%.5f", timeTaken);
	}
	
}

