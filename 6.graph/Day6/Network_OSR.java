package Graph;

import java.util.*;

public class Network_OSR {
	public static int solution(int n, int[][] computers) {

		boolean[] visited = new boolean[n];
		Queue<Integer> q = new LinkedList<>();
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			if (visited[i] == true)
				continue;

			q.add(i);
			while (!q.isEmpty()) {
				int k = q.poll();
				visited[k] = true;

				for (int j = 0; j < n; j++) {
					if (computers[k][j] == 1 && visited[j] == false) {
						visited[j] = true;
						q.add(j);
					}
				}
			}

			cnt++;
		}

		return cnt;
	}

	public static void main(String[] args) {
		int[][] com = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };

		System.out.println(solution(com.length, com));

	}

}
