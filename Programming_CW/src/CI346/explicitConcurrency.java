package CI346;

import java.util.HashSet;

public class explicitConcurrency implements Runnable{
	
	int start = 0;
	int end = 0;
	static int countOfHappyPrime = 0;

	public explicitConcurrency(int startNumber, int endNumber) {
		start = startNumber;
		end = endNumber;
	}

	@Override
	public void run() {
		for(int a = start; a <= end; a++){
			int currNum = a;			
			HashSet<Integer> values = new HashSet<Integer>();
			//while not 1 and not already stored in HashSet, if number matches one in HashSet, not happy number
			while(currNum != 1 && values.add(currNum)){
				int squaredTotal = 0;
				//while loop adds the squared digits together to get sum of squared digits
				while(currNum > 0){
					int digit =  currNum % 10;
					squaredTotal = squaredTotal + (digit*digit);
					currNum = currNum / 10;
				}
				currNum = squaredTotal;
			}
			if(currNum == 1){
				// inside if determines if happy number is also prime
				boolean isPrimeNumber = true;
				if (a % 2 == 0){}else{
					for (int b = 3; b < a; b += 2){
						if (a % b == 0){
							isPrimeNumber = false;
							break;
						}
					}
					if (isPrimeNumber){
						if(a != 1)
							addcountOfHappyPrime();	
					}
				}
			}
		}
	}
	
	public static synchronized void addcountOfHappyPrime(){
		countOfHappyPrime++;
	}
	
	public static int getCountOfHappyPrime(){
		return countOfHappyPrime;
	}
	
}
