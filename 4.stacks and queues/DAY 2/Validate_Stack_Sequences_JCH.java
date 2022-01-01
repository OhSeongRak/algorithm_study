import java.util.Stack;

class Solution3 {
	
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
    	
    	for(int i = 0; i<pushed.length; i++) {
        	stack.push(pushed[i]);
        	if(pushed[i]==popped[idx]) {
        		stack.pop();
        		idx++;
        	}
        	int tmp = stack.size();
        	
        	for(int j = 0; j<tmp;j++) {
	        	if(stack.empty()==false && stack.peek() == popped[idx]) {
	        		stack.pop();
	        		idx++;
	        	}
        	}
        	
        }
    	int tmp2 = stack.size();
    	
    	for(int i = 0; i<tmp2;i++) {
    		if(stack.peek()==popped[idx]) {
    			stack.pop();
    			idx++;
    			
    			
    		}
    		else {
    			break;
    		}
    	}
    	
    	if(stack.empty()==false) return false;
    	else return true;
    }
}

public class Validate_Stack_Sequences_JCH {

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		int[]a = new int[] {2,3,0,1};
		int[]b = new int[] {0,3,2,1};
		
		System.out.println(s.validateStackSequences(a, b));

		

	}

}
