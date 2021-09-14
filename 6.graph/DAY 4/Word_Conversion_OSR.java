package Graph;

import java.util.*;

class Node {
	String word;
	int cnt;

	Node(String w, int c) {
		word = w;
		cnt = c;
	}
}

public class Word_Conversion_OSR {

	public static boolean isConvert(String w1, String w2) {
		int cnt = 0;

		for (int i = 0; i < w1.length(); i++) {
			if (w1.charAt(i) != w2.charAt(i))
				cnt++;
			if (cnt > 1)
				return false;
		}

		return true;
	}

	public static int solution(String begin, String target, String[] words) {
		boolean[] visited = new boolean[words.length];
		Queue<Node> q = new LinkedList<>();

		q.add(new Node(begin, 0));

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (node.word.equals(target))
				return node.cnt;

			for (int i = 0; i < words.length; i++) {
				if (isConvert(node.word, words[i]) && !visited[i]) {
					q.add(new Node(words[i], node.cnt + 1));
					visited[i] = true;
				}
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		String begin = "hit";
		String target = "dog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };

		System.out.println(solution(begin, target, words));
	}

}
