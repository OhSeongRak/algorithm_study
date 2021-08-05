package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class K_th_string {

	public static void findString(int N, String str) {
		ArrayList<String> stringArray = new ArrayList<String>();
		ArrayList<String> resultArray = new ArrayList<String>();
		
		for(int i = 0; i < str.length(); i++) {
			for(int j = i; j < str.length(); j++)
				stringArray.add(str.substring(i, j + 1));
		}
		
		Collections.sort(stringArray);
		
		for(int i = 0; i < stringArray.size(); i++) {
			if(!resultArray.contains(stringArray.get(i)))
				resultArray.add(stringArray.get(i));
		}
		if(N > resultArray.size())
			System.out.println("none");
		else
			System.out.println(resultArray.get(N - 1));
	}

	public static void main(String[] args) {
		int K, N;
		String str;
		
		Scanner in = new Scanner(System.in);

		K = in.nextInt();

		for (int i = 0; i < K; i++) {
			N = in.nextInt();
			str = in.next();

			System.out.print("#" + (i + 1) + ' ');
			findString(N, str);
		}
	}
}
