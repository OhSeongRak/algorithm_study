import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack <Integer> stack = new Stack<Integer>();
        for ( int index = 0 ; index <asteroids.length;index++) {
        	
        	if (stack.size() == 0) 
        		stack.push(asteroids[index]);
        	else {
        		if ( asteroids[index]>0)
        			stack.push(asteroids[index]);
        		else {
        			while(true) {
        				if (stack.size()==0 || stack.peek()<0) {
        					stack.push(asteroids[index]);
        					break;
        				}
        				if( stack.peek() + asteroids[index] <0) {
        					stack.pop();
        					continue;
        				}
        				else if (stack.peek() + asteroids[index]==0) {
        					stack.pop();
        					break;
        				}
        				else
        					break;
        				
        			}
        		}
        	}	
        }
        int[] result = new int[stack.size()];
        for( int index = stack.size()-1 ; index >= 0 ; index--)
        	result[index] = stack.pop();
        return result;
    }
}