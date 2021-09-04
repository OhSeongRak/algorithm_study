package HashTable;

import java.util.Hashtable;

public class Nice_Pairs_OSR {

	public static int reverse(int n) {
		int r = 0;

		while (n > 0) {
			r = r * 10 + n % 10;
			n /= 10;
		}
		return r;
	}

	public static int countNicePairs(int[] nums) {

		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();

		int cnt = 0;
		int sum = 0;
		
		for (Integer k : nums) {
			cnt = ht.getOrDefault(k - reverse(k), 0);
			sum += (sum + cnt) % 1000000007;
			
			ht.put(k - reverse(k), cnt + 1);
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1 };
		// int[] nums = {1, 1, 1, 1, 1};

		System.out.println(countNicePairs(nums));
	}

}
