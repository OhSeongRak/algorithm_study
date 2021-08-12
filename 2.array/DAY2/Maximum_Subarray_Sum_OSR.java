package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maximum_Subarray_Sum_OSR {

	public static long maximumSum(List<Long> a, long m) {
		int l = 0, r = 1, pos = 1, N = a.size();
		
		for (int i = 1; i < N; i++) {
			for (int j = i; j < N; j++)
				a.add(a.get(l++) + a.get(r++));
			l = ++pos;
		}

		long max = 0;
		for (int i = 0; i < a.size(); i++)
			max = Math.max(max, a.get(i) % m);

		return max;
	}

	public static void main(String[] args) {
		int q, n, m;
		Scanner in = new Scanner(System.in);

		q = in.nextInt();
		n = in.nextInt();
		m = in.nextInt();
		List<Long> a = new ArrayList<>();

		for (int i = 0; i < q; i++) {
			for (int j = 0; j < n; j++)
				a.add(in.nextLong());

			System.out.println(maximumSum(a, m));
		}

	}

}
