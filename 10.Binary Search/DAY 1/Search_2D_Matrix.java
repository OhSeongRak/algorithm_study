package Week10_Binary_Search;

public class Day1_Search_2D_Matrix {
	public static boolean searchMatrix(int[][] matrix, int target) {


		int n = matrix.length;
		int m = matrix[0].length;
		
		int r = 0;
		int c = m-1;
		
		while(r < n && c >= 0) {
			if(matrix[r][c] > target) c--; //위로 이동
			else if(matrix[r][c] < target) r++; //오른쪽으로 이동
			else return true;
		}
		return false;
		
	}
	public static void main(String[] args) {
//		int[][] matrix = { {1,4,7,11,15},
//							{2,5,8,12,19},
//							{3,6,9,16,22},
//							{10,13,14,17,24},
//							{18,21,23,26,30} };
//		int target = 20;
		
//		int[][] matrix = { {-1,3} };
//		int target = 3;
		
		int[][] matrix = { {1,4}, {2,5} };
		int target = 2;
		
		System.out.println(searchMatrix(matrix, target));
		
	}
	

}
