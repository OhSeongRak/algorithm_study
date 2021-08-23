package StackQueue;

public class Fish_OSR {
	public static int solution(int[] A, int[] B) {

		int[] surviveA = new int[A.length]; // ��Ƴ��� �����(����)
		int[] surviveB = new int[A.length]; // �ش� ������� ��ġ
		int curPos = 0;
		int top = -1;

		// 0: �Ʒ���(����), 1: ����(������)
		while (curPos < A.length) {
			// ����Ⱑ ���ΰ��� ��� => ����
			if (top == -1 || B[curPos] == 1) {
				surviveA[++top] = A[curPos++]; // ���ÿ� ����� ����
				surviveB[top] = B[curPos - 1]; // ��ġ ������
			}
			// ����Ⱑ �Ʒ��� ���� ���
			else {
				// �� �� �Ʒ��� �� ��� => ����
				if (surviveB[top] == 0) {
					surviveA[++top] = A[curPos++];
					surviveB[top] = B[curPos - 1];
				}
				// �ö󰡴� ����Ⱑ �� ū ���
				else if (surviveA[top] > A[curPos])
					curPos++;
				// �������� ����Ⱑ �� ū ���
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
