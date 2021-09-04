import java.util.Hashtable;

class Solution {
	public static int countNicePairs(int[] nums) {
		long answer = 0;

		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		for (int index = 0; index < nums.length; index++) {

			String stringNum = Integer.toString(nums[index]);
			StringBuffer sb = new StringBuffer(stringNum);
			String numReverse = sb.reverse().toString();
			int intNum = Integer.parseInt(numReverse);

			ht.put(nums[index] - intNum, ht.getOrDefault(nums[index] - intNum, 0) + 1);

		}

		for (int key : ht.keySet()) {
			answer += (long) ht.get(key) * (ht.get(key) - 1) / 2;

		}
		return (int) (answer % (Math.pow(10, 9) + 7));
	}

}
