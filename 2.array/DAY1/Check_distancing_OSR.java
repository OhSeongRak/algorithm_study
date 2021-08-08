package String;

import java.util.ArrayList;
import java.util.Scanner;

public class Check_distancing_OSR {

	public static int distance(Integer[] pos1, Integer[] pos2) {
		return (Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]));
	}

	public static int[] solution(String[][] space) {

		int[] answer = { 1, 1, 1, 1, 1 };
		int x1, x2, y1, y2;
		int n = 0;

		while (n < 5) {
			ArrayList<Integer[]> pPos = new ArrayList<>();

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (space[n][i].charAt(j) == 'P')
						pPos.add(new Integer[] { i, j });
				}
			}

			for (int i = 0; i < pPos.size(); i++) {
				System.out.println(pPos.get(i)[0] + " " + pPos.get(i)[1]);
			}
			System.out.println("----------------------");

			for (int i = 0; i < pPos.size() - 1; i++) {
				x1 = pPos.get(i)[0];
				y1 = pPos.get(i)[1];
				for (int j = i + 1; j < pPos.size(); j++) {
					x2 = pPos.get(j)[0];
					y2 = pPos.get(j)[1];
					// 맨해튼 거리가 1일 경우
					if (distance(pPos.get(i), pPos.get(j)) == 1) {
						answer[n] = 0;
						break;
						// 거리가 2일 경우
					} else if (distance(pPos.get(i), pPos.get(j)) == 2) {
						// 같은 행인 경우
						if (x1 == x2) {
							// 사이 값이 O인 경우 거리두기 지키기 않음
							if (space[n][x1].charAt(y2 - 1) == 'O') {
								answer[n] = 0;
								break;
							}
						} else if (y1 == y2) {
							if (space[n][x2 - 1].charAt(y1) == 'O') {
								answer[n] = 0;
								break;
							}
						}
						// 대각선인 경우
						else {
							if (space[n][x1].charAt(y2) == 'O' || space[n][x2].charAt(y1) == 'O') {
								answer[n] = 0;
								break;
							}
						}
					}
				}
				if (answer[n] == 0)
					break;
			}

			n++;
		}

//		for(int k: answer)
//			System.out.println(k);

		return answer;
	}

	public static void main(String[] args) {
//		String[][] space = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
//				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
//				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
//
//		Integer[] x1 = {0,0};
//		Integer[] x2 = {0,2};
//
//		System.out.println(distance(x1,x2));
//		System.out.println(solution(space));

		String[][] space = new String[5][5];
		int[] list = new int[5];
		
		Scanner in = new Scanner(System.in);

		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				space[i][j] = in.next();
		
		list = solution(space);
		for(int k : list)
			System.out.println(k);
	}

}
