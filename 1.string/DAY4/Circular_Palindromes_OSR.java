package String;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Circular_Palindromes_OSR {

	public static List<Integer> circularPalindromes(String s) {
		List<Integer> list = new ArrayList<>();
		int cnt = 0;

		for (int i = 0; i < s.length(); i++) {
			int N = s.length();
			// list에 숫자가 채워질 경우 break;
			while(list.size() < i + 1) {
				// N : 문자열의 길이, sPart : N만큼 자른 문자열
				for (int left = 0; left < s.length() - N + 1; left++) {
					String sPart = s.substring(left, left + N);
					// 대칭 찾는 부분
					for (cnt = 0; cnt < sPart.length() / 2; cnt++) {
						if (sPart.charAt(cnt) != sPart.charAt(sPart.length() - cnt - 1))
							break;
					}
					if (cnt == sPart.length() / 2) {
						list.add(N);
						break;
					}
				}
				N--;
			}
			s += s.charAt(0);
			s = s.substring(1);
		}

		return list;
	}

	public static void main(String[] args) {
		String s;
		int n;
		List<Integer> list = new ArrayList<Integer>();

		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		list = circularPalindromes(in.next());

		for(Integer idx: list) 
			System.out.println(idx);
		
	}

}
