class Solution {
    
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<>();
        int count=0;
    
        for(int i = 0 ; i < asteroids.length ; i++){
            
            if(asteroids[i] > 0){ //양수라면 그냥 add 
                stack.add(asteroids[i]);
                count++;
            } 
            else{//음수일 경우
                while(stack.isEmpty() != true && 
                      stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])){
                      //peek와 계속 비교하는데(=isEmpty() == false인 경우 + peek된 값이 양수이면서 절대값이 peek보다 커서 충돌하는 경우) pop
                    stack.pop();
                    count--;
                }
                
                if(stack.isEmpty() == true || stack.peek() < 0){
                    stack.add(asteroids[i]);
                    count++;
                }//비어있으면서 첫 값이 음수일 경우에는 add 
                //ex) [-2,-1,1,2]
         
                else if (stack.peek() == Math.abs(asteroids[i])){
                    stack.pop();
                    count--;
                }//절대값이 같으면 pop
            }
        }
        
        int[] answer = new int[count];
        for(int i = count-1 ; i >= 0 ; i--){
            answer[i] = stack.pop();
        }//배열에 stack을 넣어줌
        return answer; 
    }
   
}
