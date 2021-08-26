package StackQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Stack_Sequence_OSR {
	public static void solution(int[] popped, int n) {

		int[] pushed = new int[n];
		List<Character> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++)
			pushed[i] = i + 1;
		
		Stack<Integer> stack = new Stack<>();
		int stackLen = pushed.length;
		int popIdx = 0;
		
		for(int i = 0; i < stackLen; i++) {
			stack.push(pushed[i]);
			list.add('+');
			// 스택의 맨 위가 popped의 값과 같다면(empty도 아니고) pop한다.
			while(stack.isEmpty() == false && stack.peek() == popped[popIdx]) {
				stack.pop();
				list.add('-');
				popIdx++;
			}				
		}
		
		for(int i = popIdx; i < stackLen; i++) {
			if(stack.pop() != popped[i]) {
				System.out.println("NO");
				return;
			}
		}
		
		for(Character k : list)
			System.out.println(k);
			
	}
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		int[] popped = new int[n];
		
		for(int i = 0; i < n; i++)
			popped[i] = sc.nextInt();
		
		solution(popped, n);
	}

}
