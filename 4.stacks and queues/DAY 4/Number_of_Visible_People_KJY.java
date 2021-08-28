import java.util.Stack;

public class Number_of_Visible_People_KJY {
	public static int[] canSeePersonsCount(int[] heights) {
		
		int[] answer = new int[heights.length];
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.add(heights[heights.length-1]);
		
		for(int index = heights.length-2 ; index>=0 ;index--) {
			while(!stack.isEmpty()) {
				if(stack.peek() > heights[index]) {
					answer[index]++;
					break;
				}
				else {
					answer[index]++;
					stack.pop();
				}
			}
			stack.add(heights[index]);
		}
		
		return answer;
		
    }
	

}