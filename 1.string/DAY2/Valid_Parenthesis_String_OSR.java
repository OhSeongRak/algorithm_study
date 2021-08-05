package String;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Valid_Parenthesis_String_OSR {

	public static boolean checkValidString(String s) {

		// lo : '('      => +1  /  ')', '*' => -1
		// hi : '(', '*' => +1  /  ')'      => -1
		// hi�� ������ ��� ')'�� ������ �������� �պ��� ������ ��� break
		// lo�� ������ ��� 0���� �ٲ���('*'�� 0���� ���)
		// ���������� lo�� 0�̾�� true�� �� �� ����( lo > 0�� ��� '('�� ������ �� ���ٴ� ��)
		
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
