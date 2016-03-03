package CI346;

import java.util.HashSet;

public class implicitConcurrency {
	
	public static  boolean calculatePrimes(int a) {
		int currNum = a;			
		HashSet<Integer> values = new HashSet<Integer>();
		while(currNum != 1 && values.add(currNum)){
			int squaredTotal = 0;
			while(currNum > 0){
				int digit =  currNum % 10;
				squaredTotal = squaredTotal + (digit*digit);
				currNum = currNum / 10;
			}
			currNum = squaredTotal;
		}
		if(currNum == 1){
			if (a % 2 == 0){return false;}else{
				for (int b = 3; b < a; b += 2){
					if (a % b == 0){
						return false;
					}
				}
				if(a != 1)
					return true;	
			}
		}
		return false;
	}
}
