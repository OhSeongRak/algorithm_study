import java.util.*;

class Solution {

	class Graph {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

		Graph(int n) {
			for (int i = 0; i <= n; i++) {
				ArrayList<Integer> sub_graph = new ArrayList<Integer>();
				sub_graph.add(i);
				graph.add(sub_graph);
			}
		}

		void addEdge(int num1, int num2) {
			graph.get(num1).add(num2);
			graph.get(num2).add(num1);
		}

		int BFS(int start) {
			int count=0;
			int max=0;
			Queue<Integer> queue = new LinkedList<Integer>();
			boolean[] visited = new boolean[graph.size()];
			Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();

			queue.add(start);
			ht.put(start,0);
			
			while (!queue.isEmpty()) {
				int tmp = queue.poll();
				if (visited[tmp] == false) {
					visited[tmp] = true;
				}
				for (int i = 0; i < graph.get(tmp).size(); i++) {
					if(visited[graph.get(tmp).get(i)] == false){
						visited[graph.get(tmp).get(i)]=true;
						queue.add(graph.get(tmp).get(i));
						ht.put(graph.get(tmp).get(i),ht.get(tmp)+1);
					}
				}
			}
			
			for(int key : ht.keySet()) {
//				System.out.printf("%d %d\n",key,ht.get(key));
				if(ht.get(key) > max) {
					count=1;
					max = ht.get(key);
				}
				else if (ht.get(key) == max) {
					count++;
				}
				else {
					continue;
				}
			}
			return count;

		}
	}

	public int solution(int n, int[][] edge) {

		Graph gp = new Graph(n);
		for (int index = 0; index < edge.length; index++)
			gp.addEdge(edge[index][0], edge[index][1]);


		return gp.BFS(1);
	}
}
