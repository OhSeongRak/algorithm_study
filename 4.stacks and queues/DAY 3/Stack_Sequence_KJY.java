import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Stack_Sequence_KJY {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<String> arrayList = new ArrayList<String>();
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0 ; i < n ; i++) {
			queue.add(Integer.parseInt(br.readLine()));
		}
		//
		for( int num = 1 ; num <= n ; num++) {
			stack.push(num);
			arrayList.add("+");
			while (!queue.isEmpty()&&!stack.isEmpty()&&stack.peek().intValue() == queue.peek().intValue()) {
				stack.pop();
				queue.poll();
				arrayList.add("-");
			}
		}
		if (!queue.isEmpty())
			System.out.println("NO");
		else {
			for( String i : arrayList) {
				System.out.println(i);
			}
		}
		

	}

}
