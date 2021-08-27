import java.util.Stack;

class Solution {
	public static int trap(int[] height) {
		int answer=0;
		
		// i에서 만들어지는 answer
		int[] answerArray = new int[height.length];
		
		
		// 0~i 까지의 blackBlock 총합 
		int[] blackBlockSum = new int[height.length];
		int sum = 0;
		for(int i = 0 ; i < height.length ; i++) {
			sum += height[i];
			blackBlockSum[i]=sum;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int index = 0;
		while (index < height.length-1) {
			if(height[index] > height[index+1]) {
				break;
			}
			index++;
		}
		
		System.out.printf("첫 하강하기 직전 index = %d \n",index);
		stack.add(index);
		index++;
		
		for(;index<height.length;index++) {
			// 새로운 놈이 작거나 같으면 stack 에 add 
			if ( height[stack.peek()] >= height[index]) {
				stack.add(index);
			}
			// 새로운 놈이 크면
			else {
				while(true) {
					if(stack.size()==1 ||height[stack.peek()]>=height[index]) {
						break;
					}
					else 
						answerArray[stack.pop()]=0;
				}
				System.out.printf("왼쪽 막대기의 index = %d \n",stack.peek());
				int length = index - stack.peek() -1;
				answerArray[index]= length*Math.min(height[stack.peek()],height[index])-(blackBlockSum[index-1]-blackBlockSum[stack.peek()]);
				//새로운놈이 작거나 같으면
				if(height[stack.peek()] >= height[index]) {
					stack.add(index);
				}
				//새로운놈이 크면
				else {
					stack.pop();
					stack.add(index);
				}
				
			}
		}
		
		// height 와 answerArray 출력
		for(int i = 0 ; i< height.length ; i++) {
			System.out.printf("%d ",height[i]);
		}
		System.out.println("");
		
		for(int i = 0 ; i< height.length ; i++) {
			System.out.printf("%d ",answerArray[i]);
		}
		System.out.println("");
		
		
//		//스택 출력
//		System.out.print("스택상황 은 ");
//		int size =stack.size();
//		for(int i = 0 ; i < size;i++) {
//			System.out.printf("%d ",stack.pop());
//		}
//		System.out.println(" ");
		
		for( int i = 0; i< answerArray.length;i++) {
			answer+=answerArray[i];
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int[] height1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };//6
		System.out.println(trap(height1));
		int[] height2 = { 4, 2, 0, 3, 2, 5 };//9
		System.out.println(trap(height2));
//		int[] height3 = { 4, 2, 3 };
//		System.out.println(trap(height3));
		int[] height4 = { 5, 2, 1, 2, 1, 5 };//14
		System.out.println(trap(height4));
//		int[] height5 = { 0, 7, 1, 4, 6 };
//		System.out.println(trap(height5));
		int[] height6 = {2,0,2};//2
		System.out.println(trap(height6));
		int[] height7 = {5,5,1,7,1,1,5,2,7,6};
		System.out.println(trap(height7));
		int[] height8= {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height8));
	}
}
