package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
	int w;
	int e;

	Node(int w, int e) {
		this.w = w;
		this.e = e;
	}
}

public class Diameter_of_the_tree_OSR {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int maxDist = 0;
	static Node maxNode;
	static ArrayList<Node>[] tree;
	static boolean[] visited;

	static void dfs(Node node, int dist) {
		visited[node.w] = true;

		for (Node tmp : tree[node.w]) {
			// �湮���� �ʾҴٸ� dfs
			if (visited[tmp.w] == false) {
				visited[tmp.w] = true;
				dfs(tmp, dist + tmp.e);
				// ���߿� �ٽ� Ȱ���ϱ� ���� false�� �ʱ�ȭ
				visited[tmp.w] = false;
			}
		}

		if (dist > maxDist) {
			maxDist = dist;
			maxNode = node;
		}

		visited[node.w] = false;

	}

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		if(N == 1) {
			System.out.println(0);
			return;
		}
		
		for (int i = 1; i <= N; i++)
			tree[i] = new ArrayList<Node>();

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			tree[parent].add(new Node(child, edge));
			tree[child].add(new Node(parent, edge));
		}

		for (Node root : tree[1]) {
			if (visited[root.w] == false) {
				visited[root.w] = true;
				dfs(root, root.e);
				visited[root.w] = false;
			}
		}

		 maxDist = 0;
		 dfs(maxNode, 0);

		System.out.println(maxDist);
	}

}
