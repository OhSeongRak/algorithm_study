package StackQueue;

public class Asteroid_Collision_OSR {
	public int[] asteroidCollision(int[] asteroids) {

		int[] survive = new int[asteroids.length];
		int curPos = 0;
		int top = -1;

		while (curPos < asteroids.length) {
			// asteroids의 값이 양수일 경우 => 스택
			if (top == -1 || asteroids[curPos] > 0)
				survive[++top] = asteroids[curPos++];
			// asteroids의 값이 음수일 경우
			else {
				// 둘 다 음수일 경우 => 스택
				if(survive[top] < 0)
					survive[++top] = asteroids[curPos++];
				// 스택에 있는 값이 더 클 경우
				else if(survive[top] > Math.abs(asteroids[curPos]))
					curPos++;
				else if(survive[top] < Math.abs(asteroids[curPos]))
						top--;
				else {
					top--;
					curPos++;
				}		
			}
		}
		
		int[] ans = new int[top + 1];
		
		for(int i = 0; i < top + 1; i++)
			ans[i] = survive[i];
			
		return ans;
	}

	public static void main(String[] args) {

	}
}
