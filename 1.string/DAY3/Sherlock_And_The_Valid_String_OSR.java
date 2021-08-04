package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class Sherlock_And_The_Valid_String_OSR {

	public static boolean isValid(String s) {

		int cnt = 0;
		int firstKey = 0, firstValue = 0, secondKey = 0, secondValue = 0;

		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Integer, Integer> map2 = new HashMap<>();
		List<Integer> list = new ArrayList<>();

		// 문자의 개수를 map1에 넣음
		for (int i = 0; i < s.length(); i++) {
			map1.putIfAbsent(s.charAt(i), 0);
			map1.computeIfPresent(s.charAt(i), (k, v) -> v + 1);
		}
		
		for (Entry<Character, Integer> entry : map1.entrySet()) {
			map2.putIfAbsent(entry.getValue(), 0);
			map2.computeIfPresent(entry.getValue(), (k, v) -> v + 1);
		}

		for (Entry<Integer, Integer> entry : map2.entrySet()) {
			if (cnt == 0) {
				firstKey = entry.getKey();
				firstValue = entry.getValue();
			} else if (cnt == 1) {
				secondKey = entry.getKey();
				secondValue = entry.getValue();
				if ((firstKey == 1 && firstValue == 1) || (secondKey == 1 && secondValue == 1)) {
					cnt++;
					continue;
				}
				else if (firstKey > secondKey) {
					if (firstKey - secondKey > 1 || firstValue > 1)
						return false;
				} else {
					if (secondKey - firstKey > 1 || secondValue > 1)
						return false;
				}

			} else // 3개일 때
				return false;
			cnt++;
		}

		return true;

	}

	public static void main(String[] args) {
		String s;

		Scanner in = new Scanner(System.in);

		s = in.next();

		if (isValid(s))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
