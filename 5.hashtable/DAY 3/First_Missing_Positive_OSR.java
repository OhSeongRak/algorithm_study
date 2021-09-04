package HashTable;

import java.util.Hashtable;

public class First_Missing_Positive_OSR {
	public static int firstMissingPositive(int[] nums) {

		Hashtable<Integer, Integer> ht = new Hashtable<>();

		for (Integer k : nums)
			ht.put(k, 1);

		int n = 1;

		while (ht.containsKey(n))
			n++;

		return n;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 0 };

		System.out.print(firstMissingPositive(nums));

	}

}
