package Week8_Heap_and_Priority_Queue;

import java.util.ArrayList;
import java.util.List;

public class Day1_Super_Ugly_Number {
	public static int nthSuperUglyNumber(int n, int[] primes) {
		
		List<Integer> l = new ArrayList<>();
		l.add(1);
		
		int size = primes.length;
		

		int num = 2;
		
		while(l.size() < n) {
			int temp = num;
			for(int i = 0 ; i < size ; i++) {
				while(num % primes[i] == 0) {
					num/=primes[i];
					if(num==1) l.add(temp);
				}
			}
			
				

			num = temp;
			num++;
		}
		System.out.println(l);
		return l.get(n-1);
		 
	}
	
	public static void main(String[] args) {

		int n = 15;
		int[] primes = {3,5,7,11,19,23,29,41,43,47};
		System.out.println(nthSuperUglyNumber(n,primes));
	}

}
