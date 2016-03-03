package CI346;

import java.util.HashSet;
import java.util.concurrent.Callable;

public class explicitConcurrencyThreadPool implements Callable<Integer> {

	private int countVal = 0;

	public Integer call() {
		int currNum = countVal;			
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
			if (countVal % 2 == 0){return 0;}else{
				for (int b = 3; b < countVal; b += 2){
					if (countVal % b == 0){
						return 0;
					}
				}
				if(countVal != 1)
					return 1;
			}
		}
		return 0;
	}

	public explicitConcurrencyThreadPool(int val){
		countVal = val;
	}
	
}
