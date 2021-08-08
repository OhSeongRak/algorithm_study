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
			// list�� ���ڰ� ä���� ��� break;
			while(list.size() < i + 1) {
				// N : ���ڿ��� ����, sPart : N��ŭ �ڸ� ���ڿ�
				for (int left = 0; left < s.length() - N + 1; left++) {
					String sPart = s.substring(left, left + N);
					// ��Ī ã�� �κ�
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
