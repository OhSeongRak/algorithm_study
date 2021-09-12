package Graph;

import java.util.*;

public class Floyd_OSR {

	static int n, m;
	static Scanner sc = new Scanner(System.in);

	public static void solution(int[][] flyd) {

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int c = sc.nextInt();

			flyd[x][y] = Math.min(flyd[x][y], c);
		}

		for (int k = 1; k < n + 1; k++) {
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					flyd[i][j] = Math.min(flyd[i][j], flyd[i][k] + flyd[k][j]);
				}
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (flyd[i][j] == 1_000_000)
					System.out.print(0 + " ");
				else
					System.out.print(flyd[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {

		n = sc.nextInt();
		m = sc.nextInt();

		int[][] flyd = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (i == j) {
					flyd[i][j] = 0;
					continue;
				}
				flyd[i][j] = 1_000_000;
			}
		}

		solution(flyd);

	}

}
