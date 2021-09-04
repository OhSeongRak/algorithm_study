package HashTable;

public class firstMissingPositive_BestCode {

	public static int firstMissingPositive(int[] A) {
		int i = 0;
		while (i < A.length) {
			if (A[i] == i + 1 || A[i] <= 0 || A[i] > A.length)
				i++;
			else if (A[A[i] - 1] != A[i])
				swap(A, i, A[i] - 1);
			else
				i++;
		}
		i = 0;
		while (i < A.length && A[i] == i + 1)
			i++;
		return i + 1;
	}

	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 0 };

		System.out.print(firstMissingPositive(nums));

	}

}
