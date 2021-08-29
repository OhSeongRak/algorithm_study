package StackQueue;

public class Trapping_Rain_Water_OSR {

	public static int trap(int[] height) {
		int sum = 0;
		int idx = 0;

		while (idx < height.length - 1) {
			
			if (height[idx] <= height[idx + 1])
				idx++;

			else {
				int k = idx + 1;

				while (k < height.length && height[idx] > height[k])
					k++;

				// 끝까지 갔는데도 자신보다 크거나 같은 블록이 없을 경우
				if (k == height.length) {
					// System.out.println("나보다 작은거 없음, idx: " + idx);
					height[idx]--;
					continue;
				}

				// idx = 1, k =3, h = 1
				int h = height[idx]; // 2, k = 블록크기3의 인덱스
				for (idx = idx + 1; idx < k; idx++) {
					// System.out.println("idx: " + idx + ", sum: " + (h - height[idx]));
					sum += h - height[idx];
				}
			}

		}

		return sum;
	}

	public static void main(String[] args) {
		// int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int[] height = { 4, 2, 3 };

		System.out.println(trap(height));

	}

}
