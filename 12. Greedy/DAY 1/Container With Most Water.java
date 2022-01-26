package Week12_Greedy;

public class Day1_Container_With_Most_Water {
	public static int maxArea(int[] height) {
		
		int n = height.length;	
		int start = 0, end = n-1;
		int vol = 0, max = Integer.MIN_VALUE;
		
		while(start < end) {
//			System.out.println(height[start] + "," + height[end] + " / "+ ( end-start));
			vol = Math.min(height[start], height[end]) * (end-start);
			max = Math.max(max, vol);
			if(height[start] <= height[end]) start++;
			else end--;
		}
		
		return max;
	}
	public static void main(String[] args) {
//		int [] height = { 1,8,6,2,5,4,8,3,7};
		int[] height = {1,1};
		System.out.println(maxArea(height));

	}

}
