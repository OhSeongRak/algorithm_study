import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int answer =0;
	public static void main(String[] args) throws IOException {

		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int computerNum = Integer.parseInt(s);
		
		for(int i = 0 ; i <= computerNum ; i++) {
			ArrayList<Integer> head = new ArrayList<Integer>();
			head.add(i);
			graph.add(head);
		}
		
		boolean[] visited = new boolean[computerNum+1];
		
		s = br.readLine();
		int numConnectedComputerPairs = Integer.parseInt(s);
		for(int i = 0 ; i< numConnectedComputerPairs; i++) {
			s = br.readLine();
			String[] sArray = s.split(" ");
			int computerNumber1 = Integer.parseInt(sArray[0]);
			int computerNumber2 = Integer.parseInt(sArray[1]);
			graph.get(computerNumber1).add(computerNumber2);
			graph.get(computerNumber2).add(computerNumber1);
		}		
		
		//DFS
		DFS(graph,1,visited);
		
		System.out.println(answer-1);
		
	}
	public static void DFS(ArrayList<ArrayList<Integer>> graph,int num,boolean[] visited) {
		visited[num]=true;
		answer++;
		for(Integer value : graph.get(num)) {
			if ( visited[value] == false)
				DFS(graph,value,visited);
		}
	}
}
