package StackQueue;

import java.util.Stack;

public class Number_of_Visible_People {

	public static int[] canSeePersonsCount(int[] heights) {

		Stack<Integer> stack = new Stack<>();
		
		int[] answer = new int[heights.length];
		int curHeight;
		
		for (int i = 0; i < heights.length - 1; i++) {
			curHeight = heights[i];
			
			for(int j = i + 1; j < heights.length; j++) {
				if(curHeight <= heights[j]) {
					stack.push(heights[j]);
					break;
				}
				else {
					if(stack.isEmpty() == true || stack.peek() < heights[j])
						stack.push(heights[j]);
				}
					
			}
			

			answer[i] = stack.size();
			
//			System.out.print("i :"+ i + " ,");
//			int s = stack.size();
//			for(int k = 0; k < s; k++)
//				System.out.print(stack.pop() + " ");
//			System.out.println();
			
			stack.removeAll(stack);
		}

		return answer;
	}

	public static void main(String[] args) {

		int[] heights = { 10, 6, 8, 5, 11, 9 };
		int[] answer = new int[heights.length];

		answer = canSeePersonsCount(heights);

		for (int k : answer)
			System.out.println(k);
	}

}
