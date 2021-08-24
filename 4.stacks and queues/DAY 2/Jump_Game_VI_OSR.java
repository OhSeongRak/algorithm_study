package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;


public class Jump_Game_VI_OSR {

	public static int maxResult(int[] nums, int k) {

		Deque<Integer> stack = new ArrayDeque<>();
		stack.add(nums[nums.length - 1]);

		for (int i = nums.length - 2; i > 0; i--) {
			if (nums[i] > 0) {
				int tmp = stack.getLast();
				stack.removeAll(stack);
				stack.add(nums[i] + tmp);
			} else {
				stack.addFirst(nums[i] + stack.getLast());

				if (stack.size() > k) {
					stack.pollLast();

					// 이 부분에서 최대값을 구해야 함(실패)
					for(int j = 0; j < k - 1; j++) {
						if(stack.getFirst() >= stack.getLast())
							stack.pollLast();
						
					}

				}
			}

		}

		return stack.getLast() + nums[0];
	}

	public static void main(String[] args) {
		int[] nums = { 1, -1, -2, 4, -7, 3 };
		int k = 2;

		System.out.print(maxResult(nums, k));
	}

}
