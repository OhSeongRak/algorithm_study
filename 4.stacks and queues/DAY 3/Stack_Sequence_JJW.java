package Week4_Stacks_and_Queues;

import java.util.*;
import java.io.*;

public class Stack_Sequence_JJW {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		int order = 0 ;
		
		while(n-- > 0) {
			int num = Integer.parseInt(br.readLine());
			if(num > order) {
				for(int i = order+1 ; i <= num ; i++) {
					stack.push(i);
					//System.out.println("+");
					sb.append("+").append('\n');
				}
				order = num;
				
			}
			//4 - > 1 , 2, 3, 4
			
			else if(stack.peek() != num) {
				System.out.println("NO"); 
				break;
				
			}
			
			stack.pop(); // 1,2,3
			//System.out.println("-");
			sb.append("-").append('\n');

			//System.out.println("first : "+first);
			//System.out.println(stack);
		}
		System.out.println(sb);
	}
		

}
