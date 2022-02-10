package Week14_Dynamic_Programming;

public class Day1_Minimum_Path_Sum {
    public static int minPathSum(int[][] grid) {
    	int answer = 0;

    	int[][] dp = new int[grid.length][grid[0].length];
    	
    	dp = grid;
//    	for(int i = 0 ; i < grid.length ; i++) {
//    		for(int j = 0 ; j < grid[i].length ; j++) {
//    			System.out.print(dp[i][j] + " ");
//    		}
//    		System.out.println();
//    	}
    	
    	for(int i = 0 ; i < grid.length ; i++) {
    		for(int j = 0 ; j < grid[i].length ; j++) {
    			
    			if(i == 0 && j != 0) {
    				dp[i][j] +=  dp[i][j-1];
    			}
    			else if(j == 0 && i != 0) {
    				dp[i][j] += dp[i-1][j];
    			}
    			
    			if(i != 0  && j != 0) {
    				dp[i][j] = Math.min(dp[i-1][j] + dp[i][j] , dp[i][j-1] + dp[i][j]);
    				
    			}
    		}
    	}
//    	System.out.println();
//    	for(int i = 0 ; i < grid.length ; i++) {
//    		for(int j = 0 ; j < grid[i].length ; j++) {
//    			System.out.print(dp[i][j] + " ");
//    		}
//    		System.out.println();
//    	}
    	return dp[grid.length-1][grid[0].length-1];
    }
 
	public static void main(String[] args) {
//		int[][] grid = { {1,3,1}, {1,5,1}, {4,2,1} };
		int[][] grid = { {1,2,3}, {4,5,6}};
		System.out.println(minPathSum(grid));

	}

}
