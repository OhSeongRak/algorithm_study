package StackQueue;

import java.util.Stack;

public class Validate_Stack_Sequences_OSR {

	public static boolean validateStackSequences(int[] pushed, int[] popped) {

		Stack<Integer> stack = new Stack<>();
		int stackLen = pushed.length;
		int popIdx = 0;
		
		for(int i = 0; i < stackLen; i++) {
			stack.push(pushed[i]);
			// 스택의 맨 위가 popped의 값과 같다면(empty도 아니고) pop한다.
			while(stack.isEmpty() == false && stack.peek() == popped[popIdx]) {
				stack.pop();
				popIdx++;
			}				
		}
		
		for(int i = popIdx; i < stackLen; i++) {
			if(stack.pop() != popped[i])
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		int[] pushed = { 1, 2, 3, 4, 5 };
		int[] popped = { 4, 5, 3, 2, 1 };

		System.out.print(validateStackSequences(pushed, popped));

	}

}
