package String;

import java.util.Scanner;

public class Array_rotation {
	static int x, y, N;

	public static int[][] solution(int[][] arr) {

		int border = Math.min(x, y) / 2;

		for (int r = 0; r < N; r++) {
			for (int b = 0; b < border; b++) {
				int width  = y - 2 * b - 1; // 7 -> 5
				int height = x - 2 * b - 1; // 7 -> 5
				int yi = y - b - 1;
				int xi = x - b - 1;
				int tmp = arr[b][b];
				
				// 위
				//System.out.println(r + " " + b);
				for(int i = 0; i < width; i++) 
					arr[b][b + i] = arr[b][b + i + 1];				
				// 오른쪽
				for(int i = 0; i < height; i++)
					arr[b + i][yi] = arr[b + i + 1][yi];
				// 아래
				for(int i = width; i > 0; i--)
					arr[height][i] = arr[height][i - 1];
				// 왼쪽
				for(int i = height; i > 0; i--)
					arr[i][b] = arr[i - 1][b];
				
				arr[b + 1][b] = tmp;
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
