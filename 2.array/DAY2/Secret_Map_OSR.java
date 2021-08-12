package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Secret_Map_OSR {
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			int num1 = arr1[i];
			int num2 = arr2[i];
			for (int j = n - 1; j >= 0; j--) {
				if (num1 % 2 == 1 || num2 % 2 == 1)
					map[i][j] = 1;

				num1 /= 2;
				num2 /= 2;
			}
		}

		for(int i = 0; i < n; i++) {
			answer[i] = "";
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 1)
					answer[i] += "#";
				else
					answer[i] += " ";
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int n;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();

		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		String[] secret = new String[n];

		for (int i = 0; i < n; i++)
			arr1[i] = in.nextInt();
		for (int i = 0; i < n; i++)
			arr2[i] = in.nextInt();

		secret = solution(n, arr1, arr2);

		for (String s: secret)
			System.out.println(s);

	}

}
