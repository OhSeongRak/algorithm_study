package StackQueue;

public class Fish_OSR {
	public static int solution(int[] A, int[] B) {

		int[] surviveA = new int[A.length]; // 살아남은 물고기(스택)
		int[] surviveB = new int[A.length]; // 해당 물고기의 위치
		int curPos = 0;
		int top = -1;

		// 0: 아래로(왼쪽), 1: 위로(오른쪽)
		while (curPos < A.length) {
			// 물고기가 위로가는 경우 => 스택
			if (top == -1 || B[curPos] == 1) {
				surviveA[++top] = A[curPos++]; // 스택에 물고기 넣음
				surviveB[top] = B[curPos - 1]; // 위치 갱신함
			}
			// 물고기가 아래로 가는 경우
			else {
				// 둘 다 아래로 갈 경우 => 스택
				if (surviveB[top] == 0) {
					surviveA[++top] = A[curPos++];
					surviveB[top] = B[curPos - 1];
				}
				// 올라가는 물고기가 더 큰 경우
				else if (surviveA[top] > A[curPos])
					curPos++;
				// 내려가는 물고기가 더 큰 경우
				else if (surviveA[top] < A[curPos])
					top--;
			}
		}


		return top + 1;
	}

	public static void main(String[] args) {
		int[] A = { 3, 5, 10, 11, 8, 9, 4, 5, 6 };
		int[] B = { 1, 1, 0, 1, 0, 0, 1, 0, 0 };

		solution(A, B);
	}

}
