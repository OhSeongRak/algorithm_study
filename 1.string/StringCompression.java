package String;

import java.util.Scanner;

public class StringCompression {

	public static int solution(String s) {
		String ans = s;

		for (int n = 1; n <= s.length() / 2; n++) {
			int cnt = 1;
			String sol = ""; // ���߿� �� ���� ans�� ���� ���ڿ� abbaa a2b2a
			String tmp = ""; // �� a, ab, abb

			for (int i = 0; i < s.length(); i += n) {
				// �ε����� �ʰ��ϰ� ���ڿ��� �ڸ��� ���   
				if (i + n > s.length()) {
					// �� ���ڿ��� 1���� ��� => �� ���ڿ��� ���� ���ڿ��� ����.
					if (cnt == 1) {
						sol += tmp;
						sol += s.substring(i);
					} else {
						sol += cnt;
						sol += tmp;
						sol += s.substring(i);
					}
				}
				
				else {
					// �ʱ⿡ �� ���ڿ� tmp�� ����ִ� ��� // �ʿ� ����
					if (tmp.equals(""))
						tmp = s.substring(i, i + n); // n = 1 aabb 
					else {
						// �� ���ڿ��� �Ȱ��� ��� cnt�� �ø�. ex) abab -> �񱳹��ڿ� ab�� �� �� ab�� ����
						if (tmp.equals(s.substring(i, i + n)))
							cnt++;
						else {
							if (cnt == 1)
								sol += tmp;
							else {
								sol += cnt;
								sol += tmp;
							}
							cnt = 1;
							tmp = s.substring(i, i + n);
						}
						
						// ���������� �� �߶��� ���.
						if(i + n == s.length()) {
							if (cnt == 1)
								sol += tmp;
							else {
								sol += cnt;
								sol += tmp;
							}
						}
					}
				}
			}
			
			if (ans.length() > sol.length())
				ans = sol;
		}
		return ans.length();
	}

	public static void main(String[] args) {
		String s;

		Scanner in = new Scanner(System.in);

		s = in.next();
		System.out.println(solution(s));
	}

}
