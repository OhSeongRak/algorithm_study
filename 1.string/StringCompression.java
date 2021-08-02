package String;

import java.util.Scanner;

public class StringCompression {

	public static int solution(String s) {
		String ans = s;

		for (int n = 1; n <= s.length() / 2; n++) {
			int cnt = 1;
			String sol = ""; // 나중에 다 들어가고 ans랑 비교할 문자열 abbaa a2b2a
			String tmp = ""; // 왕 a, ab, abb

			for (int i = 0; i < s.length(); i += n) {
				// 인덱스를 초과하게 문자열을 자르는 경우   
				if (i + n > s.length()) {
					// 비교 문자열이 1개인 경우 => 비교 문자열과 남은 문자열을 붙임.
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
					// 초기에 비교 문자열 tmp가 비어있는 경우 // 필요 없음
					if (tmp.equals(""))
						tmp = s.substring(i, i + n); // n = 1 aabb 
					else {
						// 비교 문자열과 똑같을 경우 cnt를 늘림. ex) abab -> 비교문자열 ab와 그 뒤 ab가 같음
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
						
						// 마지막까지 다 잘랐을 경우.
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
