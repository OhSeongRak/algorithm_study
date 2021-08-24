import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
       Stack<Integer> stack = new Stack<Integer>();
       int size = pushed.length;
       int pushedIndex = 0;
       int poppedIndex = 0;
       
       while(pushedIndex<size) {
    	   stack.push(pushed[pushedIndex]);
    	   pushedIndex++;
    	   
    	   while (stack.size()!=0 && stack.peek() == popped[poppedIndex])
    	   {
    		   stack.pop();
    		   poppedIndex++;
    		   if(poppedIndex == size)
    			   return true;
    	   }
       }
       return false;
    }
}
