package Week4_Stacks_and_Queues;
import java.util.*;

public class Validate_Stack_Sequences_JJW {

	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		
		int lenA = pushed.length;
		int lenB = popped.length;
		int idxA = 0;
		int idxB = 0;
		
		Stack<Integer> stack = new Stack<>();
		
		
		
		//popped에서의 원소와 같기 전까지 계속 push
		while(idxA < lenA && idxB < lenB) {
//			System.out.println("idXA :" +idxA + " pushed[] :" +pushed[idxA] );
//			System.out.println("idxB :"+idxB + " popped[] :"+popped[idxB]);
			stack.push(pushed[idxA]);
			idxA++;
			//System.out.println(stack);
			while(stack.isEmpty()!=true && stack.peek() == popped[idxB]) {
				stack.pop();
				idxB++;
			}//isEmpty() 비어있지 않을 떄 중요!
			//System.out.println(stack);
			
		}
		
		
		boolean res = true;
		if(stack.isEmpty() == false) res = false;
		
		return res;

		
		//first try
//		while(idxB < lenB) {
//			System.out.println("idXA :" +idxA + " pushed[] :" +pushed[idxA] );
//			System.out.println("idxB :"+idxB + " popped[] :"+popped[idxB]);
//			
//			stack.push(pushed[idxA]);
//			idxA++;
//			System.out.println(stack);
//			
//
//			
//			if(stack.peek() == popped[idxB]) {
//				//값이 같다면
//				stack.pop();
//				//1 2 3 
//				idxB++;
//			
//			}
//			System.out.println(idxB);
//			System.out.println(stack);
//		}
		
//       best code(ver.py)
//       class Solution: 
//           def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool: 
//               answer = [] 
//               while pushed or popped:
//                 try: 
//                   if not answer or answer[-1] != popped[0]:
//                     i = pushed.index(popped[0]) 
//                     answer = answer + pushed[:i+1] 
//                     pushed = pushed[i+1:] 
//                   answer.pop() 
//                   popped = popped[1:] 
//                 except: 
//                     return False
//               return True

//           출처: https://dobuzi.tistory.com/3 [Dobuzi's coding]
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] pushed = {1,2,3,4,5};
		int[] popped = {4,5,3,2,1};
		
		boolean answer = validateStackSequences(pushed, popped);
		
		System.out.println(answer);
		
	}

}
