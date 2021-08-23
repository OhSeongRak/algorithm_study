package algorithm_study;
import java.util.Stack;

class Solution {
 public int solution(int[] A, int[] B) {
     int num=0;
     Stack<Integer> stack = new Stack<>();
     for(int i = 0 ; i < B.length;i++){
         if(B[i]==1){
             stack.push(A[i]);
         }
         else{
             if(stack.size()==0)
                 num++;
             else{
                 while(A[i]>stack.peek()) {
                	 stack.pop();
                	 if(stack.size()==0) {
                		 num++;
                		 break;
                	 }
                 }
             }
         }
     }
     num+=stack.size();


     return num;
 }
}
