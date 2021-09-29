package Tree;

import java.util.Scanner;

public class InOrder_OSR {

	static Scanner sc = new Scanner(System.in);
	static char[] tree;
	static int num;
	static int T = 1;

	static void solution() {

		while (10 >= T++) {
			num = sc.nextInt();
			tree = new char[num + 1];
			sc.nextLine();
			for (int i = 0; i < num; i++) {
				String str = sc.nextLine();
				char c = str.split(" ")[1].charAt(0);
				tree[i + 1] = c;
			}

			System.out.print("#" + (T - 1) + " ");
			inorder(1);
			System.out.println();
		}
	}

	static void inorder(int i) {
		if (i <= num) {
			inorder(i * 2);
			System.out.print(tree[i]);
			inorder(i * 2 + 1);
		}

	}

	public static void main(String[] args) {

		solution();

	}

}
