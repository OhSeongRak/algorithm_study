class Solution {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        Stack<Integer> stack = new Stack<>();
		int count = 0 ;
		
		
		int N = B.length;
		//1234
		//
		for(int i = 0 ; i < N; i++) {
			
			if(B[i] == 1) {
				stack.add(A[i]);//하류 방향일때 add
				count++;
				//System.out.println(stack);
			}
			else {
				//상류 방향일 때 비교하면서
				
				
				while(stack.isEmpty() != true ) {

					//System.out.println("A : " + A[i]);
					if(stack.peek() > A[i])//하류 방향의 물고기 크기가 더 클 때
						break;
					
					else {

						//System.out.println(stack);
						stack.pop();
						count--;
						
					}
				}
				if(stack.isEmpty() == true ) {

					//System.out.println(stack);
					count++;
				}
				
			}
		}
		//count ? -> stack에 add한 값은 하류 방향일 때이므로 성립 X
		//System.out.println(count);
		return count;
    }
}
