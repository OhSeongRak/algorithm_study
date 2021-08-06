package String;

import java.util.Scanner;

public class Permutation_in_String_OSR {

	public static boolean permutation(String s1, String s2) {

		String str;
		int flag = 0;
		int[] map = new int[26];
		int[] map_cpy = new int[26];

		if (s1.length() > s2.length())
			return false;

		for (char c : s1.toCharArray())
			map[c - 'a']++;

		for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
			str = s2.substring(i, i + s1.length());

			for (int n = 0; n < 26; n++)
				map_cpy[n] = map[n];

			flag = 0;
			for (int j = 0; j < s1.length(); j++) {
				if (map_cpy[str.charAt(j) - 'a']-- <= 0) {
					flag = 1;
					break;
				}
			}
			if (flag == 0)
				return true;
		}

		return false;
	}

	public static void main(String[] args) {

		String s1, s2;

		Scanner in = new Scanner(System.in);

		s1 = in.next();
		s2 = in.next();

		System.out.println(permutation(s1, s2));
	}

}
