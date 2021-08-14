import java.util.ArrayList;
import java.util.List;

public class Triangle_BotToTop_KJY {
	
	public static int func(List<List<Integer>> Triangle, int index, int row,int[][] memorization) {

		// exist memorization
		if (memorization[row][index] != (-10^5)) {
			return memorization[row][index];
		}
		
		// top
		if (row == 0) {
			memorization[row][index]= Triangle.get(row).get(index);
			return memorization[row][index];
		}
		
		// that line left
		if (index == 0) {
			memorization[row][index] =func(Triangle, index, row - 1,memorization) + Triangle.get(row).get(index);
			return memorization[row][index];
		}
		
		// that line right
		if (index == Triangle.get(row).size() - 1) {
			memorization[row][index]=func(Triangle, index - 1, row - 1,memorization) + Triangle.get(row).get(index);
			return memorization[row][index];
		}
		
		// that line middle
		memorization[row][index]=Math.min(func(Triangle, index - 1, row - 1,memorization), func(Triangle, index, row - 1,memorization))
				+ Triangle.get(row).get(index);
		return memorization[row][index];

	}

	public static int minimumTotal(List<List<Integer>> triangle) {

		int[][] memorization = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
		for(int i =0 ; i<triangle.size();i++)
			for(int j = 0 ; j< triangle.get(triangle.size()-1).size();j++)
				memorization[i][j] = -10^5;
		
		int answer = 10 ^ 4;

		for (int index = 0; index < triangle.size(); index++) {
			int value = func(triangle, index, triangle.size() - 1,memorization);
			if (answer > value)
				answer = value;
		}
		return answer;
	}

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();

		ArrayList<Integer> triangle0 = new ArrayList<Integer>();
		triangle0.add(2);
		triangle.add(triangle0);

		triangle0 = new ArrayList<Integer>();
		triangle0.add(3);
		triangle0.add(4);
		triangle.add(triangle0);

		triangle0 = new ArrayList<Integer>();
		triangle0.add(6);
		triangle0.add(5);
		triangle0.add(7);
		triangle.add(triangle0);

		triangle0 = new ArrayList<Integer>();
		triangle0.add(4);
		triangle0.add(1);
		triangle0.add(8);
		triangle0.add(3);
		triangle.add(triangle0);

		System.out.println(triangle);
		System.out.println(minimumTotal(triangle));
	}

}
