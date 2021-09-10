package Week6_Graph;

import java.util.*;
import java.io.*;

public class Day3_Floyd_JJw {
	static int[][] route; 
	static int n,m;
	static int INF = 100000000;
  
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		route = new int[n+1][n+1];
		
		for(int i = 1 ; i < n+1 ; i++) {
			for(int j = 1 ; j < n+1 ; j++) {
				if(i == j) route[i][j] = 0;
				else route[i][j] = INF; // Integer.MAX_VALUE;
				
			}
		}
		
		for(int i = 0 ; i < m ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int fee = Integer.parseInt(st.nextToken());
			
			route[start][end] = Math.min(route[start][end], fee);
			
		}
		
		floyd();
		
		
		for(int i = 1 ; i < n+1 ; i++) {
			for(int j = 1 ; j < n+1 ; j++) {
				if(route[i][j] == Integer.MAX_VALUE) route[i][j] = 0;
				System.out.print(route[i][j]+ " ");
				
			}
			System.out.println();
		}

	}
	public static void floyd() {
		for(int i = 1; i < n+1 ; i++) { //trans point 
			for(int j = 1 ; j < n+1 ; j++) { //start
				for(int k = 1 ; k < n+1 ; k++) { // end
					route[j][k] = Math.min(route[j][i]+route[i][k], route[j][k]);
					
				}
				
				
			}
		}
	}

}
