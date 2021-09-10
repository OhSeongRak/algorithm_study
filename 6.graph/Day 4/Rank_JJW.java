class Solution {
    static int n;
	static int[][] boxing;
	static int[] rank;
	public int solution(int n, int[][] results) {
		int answer = 0;
		
		boxing = new int[n+1][n+1];
		rank = new int[n+1];
		
		for(int i = 0 ; i < results.length ; i++) {
			int winner = results[i][0];
			int loser = results[i][1];
			
			boxing[winner][loser] = 1;
			boxing[loser][winner] = -1;
		}
		
		
		for(int i = 1 ; i < n+1 ; i++) {// traspoint
			for(int j = 1 ; j < n+1 ; j++) {//start
				for(int k = 1; k < n+1 ; k++) { // end
					if(boxing[j][i] == 1 && boxing[i][k] == 1) {
						//A > B + B > C => A >C
						boxing[j][k] = 1; //winner(A)
						boxing[k][j] = -1; //loser(C)
					}
					if(boxing[j][i] == -1 && boxing[i][k] == -1) {
						// A < B + B < C => A < C
						boxing[j][k] = -1; // lower(C)
						boxing[k][j] = 1; // winner(A)
					}
				}
			}
		}
        //순위를 매길 수 있는 기준 : 자기 자신을 제외하고 모든 선수와 경기를 했을 경우!
        
		for(int i = 1; i < n+1 ;i++) {
			for(int j = 1 ; j < n+1 ; j++) {
				if(i != j && boxing[i][j] != 0) rank[i]++;
			}
		}

		int count=0;
		for(int i = 1; i < n+1 ; i++) {
//			for(int j = 1; j < n+1 ; j++) {
//				System.out.print(boxing[i][j]+ " ");
//			}
			
			//System.out.println("  = "+ rank[i]);
			if(rank[i] == n-1) count++;
			
		}
        
		
		return count;
		
	}
}
