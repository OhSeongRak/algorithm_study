package String;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Valid_Parenthesis_String_OSR {

	public static boolean checkValidString(String s) {

		// lo : '('      => +1  /  ')', '*' => -1
		// hi : '(', '*' => +1  /  ')'      => -1
		// hi가 음수일 경우 ')'의 개수가 나머지의 합보다 많아질 경우 break
		// lo가 음수일 경우 0으로 바꿔줌('*'을 0으로 사용)
		// 최종적으로 lo가 0이어야 true가 될 수 있음( lo > 0일 경우 '('의 개수가 더 많다는 뜻)
		
		int lo = 0, hi = 0;
		for (char c : s.toCharArray()) {
			lo += c == '(' ? 1 : -1;
			hi += c != ')' ? 1 : -1;
			if (hi < 0)
				break;
			lo = Math.max(lo, 0);
		}
		return lo == 0;

	}

	public static void main(String[] args) {
		String s;

		Scanner in = new Scanner(System.in);

		s = in.next();
		System.out.println(checkValidString(s));

	}

}
