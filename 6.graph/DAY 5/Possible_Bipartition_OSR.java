package Graph;

import java.util.*;

public class Possible_Bipartition_OSR {

	public static boolean possibleBipartition(int n, int[][] dislikes) {

		if(n < 3) return true;
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		int[] team = new int[n + 1]; // ���� ���� ����
		boolean[] visited = new boolean[n + 1];

		for (int i = 0; i < n + 1; i++)
			graph.add(new ArrayList<Integer>());

		// �׷��� ����
		for (int i = 0; i < dislikes.length; i++) {
			graph.get(dislikes[i][0]).add(dislikes[i][1]);
			graph.get(dislikes[i][1]).add(dislikes[i][0]);
		}

		// 1~n���� Ȯ�� (�׷����� ������ �ִ� ��츦 Ȯ��)
		for (int i = 1; i <= n; i++) {
			// �̹� �湮�ߴٸ� Ȯ���� �ʿ� ����.
			if(visited[i] == true)
				continue;
			
			q.add(i);
			team[i] = i;
			
			//bfs
			while (!q.isEmpty()) {
				int v = q.poll();
				int opposeV = (-1) * team[v]; // v�� �ݴ� ��

				for (int next : graph.get(v)) {
					if (team[next] == team[v]) // v�� ���� ���ٸ� false
						return false;

					// next�� ���� 0�̸� v�� �ݴ��� �־���
					if(team[next] == 0)
						team[next] = opposeV;

					// �湮���� �ʾҴٸ� q�� ���� ( q�� �־���� Ȯ�������״� �湮 ó�� ��! )
					if (visited[next] == false) {
						visited[next] = true;
						q.add(next);
					}

				}
			}
			
		}

		return true;
	}

	public static void main(String[] args) {
		int[][] dislikes = { { 1, 2 }, { 4, 5 }, { 3, 4 }, { 3, 5 } };
		int n = 5;

		System.out.println(possibleBipartition(n, dislikes));

	}

}
