package Graph;

import java.util.*;

public class Possible_Bipartition_OSR {

	public static boolean possibleBipartition(int n, int[][] dislikes) {

		if(n < 3) return true;
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		int[] team = new int[n + 1]; // 팀에 대한 정보
		boolean[] visited = new boolean[n + 1];

		for (int i = 0; i < n + 1; i++)
			graph.add(new ArrayList<Integer>());

		// 그래프 연결
		for (int i = 0; i < dislikes.length; i++) {
			graph.get(dislikes[i][0]).add(dislikes[i][1]);
			graph.get(dislikes[i][1]).add(dislikes[i][0]);
		}

		// 1~n까지 확인 (그래프가 끊어져 있는 경우를 확인)
		for (int i = 1; i <= n; i++) {
			// 이미 방문했다면 확인할 필요 없음.
			if(visited[i] == true)
				continue;
			
			q.add(i);
			team[i] = i;
			
			//bfs
			while (!q.isEmpty()) {
				int v = q.poll();
				int opposeV = (-1) * team[v]; // v와 반대 팀

				for (int next : graph.get(v)) {
					if (team[next] == team[v]) // v와 팀이 같다면 false
						return false;

					// next의 팀이 0이면 v와 반대팀 넣어줌
					if(team[next] == 0)
						team[next] = opposeV;

					// 방문하지 않았다면 q에 저장 ( q에 넣어놓고 확인해줄테니 방문 처리 해! )
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
