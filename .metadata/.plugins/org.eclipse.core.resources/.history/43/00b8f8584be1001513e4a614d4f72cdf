package CI346;

import java.util.concurrent.Callable;

public class explicitConcurrencyThreadPool implements Callable<Integer> {

	private int countVal = 0;
	
	public explicitConcurrencyThreadPool(int val){
		countVal = val;
	}
	
	public Integer call() {
		boolean isPrimeNumber = true;
		if (countVal % 2 == 0) 
		{
			if (countVal == 2) 
			{
				return 1;
			}
		} else {
			for (int b = 3; b < countVal; b += 2) 
			{
				if (countVal % b == 0) 
				{
					isPrimeNumber = false;
					break;
				}
			}
			if (isPrimeNumber) 
			{
				return 1;
			}
		}
		return 0;
	}

}
