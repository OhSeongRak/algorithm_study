package Graph;

public class Rank_OSR {

	public static int solution(int n, int[][] results) {
		int answer = 0;
		boolean[][] visited = new boolean[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++)
			visited[i][i] = true;

		for (int i = 0; i < results.length; i++)
			visited[results[i][0]][results[i][1]] = true;

		for (int k = 1; k < n + 1; k++) {
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					if (visited[i][k] && visited[k][j])
						visited[i][j] = true;
				}
			}
		}
		
		
		for(int i = 1; i < n + 1; i++) {
			for(int j = 1; j < n + 1; j++) {
				if(visited[i][j] == true)
					System.out.print(1 + " ");
				else
					System.out.print(0 + " ");
			}
			System.out.println();
		}
		for (int i = 1; i < n + 1; i++) {
			int cnt = 0;
			for (int j = 1; j < n + 1; j++) {
				if(visited[i][j] || visited[j][i])
					cnt++;
			}
			if(cnt == n)
				answer++;
		}

		return answer;
	}

	public static void main(String[] args) {
		//int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 7 }, { 7, 5 }, { 5, 6 } };
		int[][] results = {{1, 2}};
		int n = 2;

		System.out.print(solution(n, results));
	}

}
