import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString = br.readLine();
		int N = Integer.parseInt(inputString.split(" ")[0]);

		int[][] graph = new int[N + 1][N + 1];
		int INF = 2147483647;

		// init graph
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				if (i == j)
					continue;
				else
					graph[i][j] = INF;
			}
		}
//		// print graph
//		System.out.println("");
//		System.out.println("print graph");
//		for (int i = 0; i <= N; i++) {
//			for (int j = 0; j <= N; j++) {
//				System.out.printf("%d ", graph[i][j]);
//			}
//			System.out.println(" ");
//		}

		int M = Integer.parseInt(inputString.split(" ")[1]);

		// add graph info
		for (int i = 0; i < M; i++) {
			inputString = br.readLine();
			graph[Integer.parseInt(inputString.split(" ")[0])][Integer.parseInt(inputString.split(" ")[1])] = Integer
					.parseInt(inputString.split(" ")[2]);
		}

//		// print graph
//		System.out.println("");
//		System.out.println("print graph");
//		for (int i = 0; i <= N; i++) {
//			for (int j = 0; j <= N; j++) {
//				System.out.printf("%d ", graph[i][j]);
//			}
//			System.out.println(" ");
//		}

		int[] dist = new int[N + 1];
		for (int i = 0; i <= N; i++)
			dist[i] = INF;
		dist[1] = 0;

		for (int i = 1; i <= N - 1; i++) {
			for (int EdgeStart = 1; EdgeStart <= N; EdgeStart++) {
				for (int EdgeEnd = 1; EdgeEnd <= N; EdgeEnd++) {
					if (graph[EdgeStart][EdgeEnd] != INF) {
						if (dist[EdgeEnd] > dist[EdgeStart] + graph[EdgeStart][EdgeEnd])
							dist[EdgeEnd] = dist[EdgeStart] + graph[EdgeStart][EdgeEnd];
					}
				}
			}
		}
//		//print dist[i]
//		System.out.println("");
//		System.out.println("print dist");
//		for (int i = 1; i <= N; i++)
//			System.out.printf("%d ", dist[i]);
//		System.out.println(" ");

		for (int EdgeStart = 1; EdgeStart <= N; EdgeStart++) {
			for (int EdgeEnd = 1; EdgeEnd <= N; EdgeEnd++) {
				if (graph[EdgeStart][EdgeEnd] != INF) {
					if (dist[EdgeEnd] > dist[EdgeStart] + graph[EdgeStart][EdgeEnd]) {
						System.out.println("-1");
						return;
					}
				}
			}
		}
		
//		System.out.println("");
//		System.out.println("answer");
		for (int i = 2; i <= N; i++) {
			if (dist[i] == INF) {
				System.out.println("-1");
				continue;
			}
			System.out.println(dist[i]);
		}
	}

}
