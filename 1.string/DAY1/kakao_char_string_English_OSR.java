package String;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class kakao_char_string_English_OSR {

	public static int solution(String s) {
		int answer = 0;
		String ans = "";
		String tmp = "";
		Map<String, Integer> map = new HashMap<>();
		
		map.put("zero", 0);
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 4);
		map.put("five", 5);
		map.put("six", 6);
		map.put("seven", 7);
		map.put("eight", 8);
		map.put("nine", 9);

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if ('0' <= ch && ch <= '9') {
				ans += String.valueOf(ch);
			}
			else {
				tmp += s.charAt(i);
				if (!tmp.equals("") && map.containsKey(tmp)) {
					ans += String.valueOf(map.get(tmp));
					tmp = "";
				}
			}
		}
		
		answer = Integer.parseInt(ans);
		return answer;
	}

	public static void main(String[] args) {
		String s;
		Scanner in = new Scanner(System.in);

		s = in.next();

		System.out.println(solution(s));
	}

}