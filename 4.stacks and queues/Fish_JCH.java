import java.util.Stack;

class Solution {
    public int solution(int[] A, int[] B) {
        
        int upStream =0;
        Stack<Integer> stack = new Stack<>();
              
        for(int i = 0; i <A.length; i++){     
            
        	if(B[i] == 1)   stack.push(A[i]);	//downStream
           
            if(B[i] == 0){	//upStream
                if(stack.size() == 0){ //downStream�� �����Ƿ� upStream ����
                    upStream ++;   
                }
                else{
                    while(stack.size() > 0){   //downStream���� -> ũ��� 
                       if(stack.peek() > A[i]){ //downStream�� Ŭ ��� break
                             break;
                      }
                       else{ 
                           stack.pop();   //upStream�� Ŭ ��� pop
                      }
                    }
                     if(stack.size() == 0){ //downStream�� �����Ƿ� upStream ����
                         upStream++;
                     }      
                }
            }
           
        }                   
        return upStream + stack.size();
    }
}

public class Fish_JCH {
	public static void main(String[] args) {
	int []a = new int [5];
	int []b = new int [5];
	
	a[0] = 4;
	a[1] = 3;
	
	a[2] = 2;
	a[3] = 1;
	a[4] = 5;
	
	
	b[0] = 1;
	b[1] = 0;
	b[2] = 1;
	b[3] = 1;
	b[4] = 1;
	
	Solution s = new Solution();
	System.out.println(s.solution(a, b));
	
	
	}
}
