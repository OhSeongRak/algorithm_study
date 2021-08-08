package String;

import java.util.Scanner;

public class Array_rotation_OSR {
	static int x, y, N;

	public static int[][] solution(int[][] arr) {

		int border = Math.min(x, y) / 2;

		for (int r = 0; r < N; r++) {
			for (int s = 0; s < border; s++) {
	            int T = s;
	            int B = x - 1 - s;
	            int R = y - 1 - s;
	            int L = s;

	            int tmp = arr[s][s];        
	            for (int i = L; i < R; i++)    arr[T][i] = arr[T][i + 1];
	            for (int i = T; i < B; i++)    arr[i][R] = arr[i + 1][R];
	            for (int i = R; i > L; i--)    arr[B][i] = arr[B][i - 1];
	            for (int i = B; i > T; i--)    arr[i][L] = arr[i - 1][L];
	            arr[T + 1][L] = tmp;
			}
		}

		return arr;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		x = in.nextInt();
		y = in.nextInt();
		N = in.nextInt();

		int[][] arr = new int[x][y];
		
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++)
				arr[i][j] = in.nextInt();
		
		arr = solution(arr);

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
		
	}

}
