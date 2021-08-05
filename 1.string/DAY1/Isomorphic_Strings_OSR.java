package String;

import java.util.HashMap;
import java.util.Scanner;

public class Isomorphic_Strings_OSR {

	public static boolean isIsomorphic(String s, String t) {

		HashMap<Character, Character> charMap = new HashMap<>();

		if (s.length() != t.length())
			return false;

		for (int i = 0; i < s.length(); i++) {
			if (!charMap.containsKey(s.charAt(i))) {
				if (charMap.containsValue(t.charAt(i)))
					return false;
				charMap.put(s.charAt(i), t.charAt(i));
			} else {
				if (charMap.get(s.charAt(i)) != t.charAt(i))
					return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String s, t;

		Scanner in = new Scanner(System.in);

		s = in.next();
		t = in.next();

		System.out.println(isIsomorphic(s, t));
	}

}
