package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sum_of_two_arrays_OSR {

	public static int lowerBound(int val, int s, int e, ArrayList<Integer> b) {
		int mid;

		while (s < e) {
			mid = (s + e) / 2;
			if (b.get(mid) >= val)
				e = mid;
			else
				s = mid + 1;
		}
		return e;
	}

	public static int upperBound(int val, int s, int e, ArrayList<Integer> b) {
		int mid;

		while (s < e) {
			mid = (s + e) / 2;
			if (b.get(mid) > val)
				e = mid;
			else
				s = mid + 1;
		}
		return e;
	}

	public static long solution(int[] A, int[] B, int T) {
		long cnt = 0;
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		int l = 0, r = 1, pos = 1;

		for (int i = 0; i < A.length; i++)
			a.add(A[i]);

		for (int i = 0; i < B.length; i++)
			b.add(B[i]);

		for (int i = 1; i < A.length; i++) {
			for (int j = i; j < A.length; j++)
				a.add(a.get(l++) + a.get(r++));
			r = ++pos;
			l++;
		}

		l = 0;
		r = 1;
		pos = 1;
		for (int i = 1; i < B.length; i++) {
			for (int j = i; j < B.length; j++)
				b.add(b.get(l++) + b.get(r++));
			r = ++pos;
			l++;
		}
		
		Collections.sort(b);

		for (int i = 0; i < a.size(); i++) {
			int val = T - a.get(i);
			int lb = lowerBound(val, 0, b.size(), b);
			int ub = upperBound(val, 0, b.size(), b);
			cnt += ub - lb;
		}
		
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int n = sc.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = sc.nextInt();

		int m = sc.nextInt();
		int[] B = new int[m];
		for (int i = 0; i < m; i++)
			B[i] = sc.nextInt();

		System.out.println(solution(A, B, T));

	}
}
