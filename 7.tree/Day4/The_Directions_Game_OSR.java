package Tree;

import java.util.ArrayList;
import java.util.Collections;

class Coord implements Comparable<Coord> {
	int v;
	int x;
	int y;
	Coord left, right;

	public Coord(int v, int x, int y) {
		this.v = v;
		this.x = x;
		this.y = y;
		left = null;
		right = null;
	}

	@Override
	public int compareTo(Coord o) {
		if (this.y == o.y)
			return this.x - o.x;
		else
			return o.y - this.y;
	}

}

class Tree {
	Coord root;

	Tree(Coord root) {
		this.root = root;
	}

	public void insertNode(Coord node) {
		if (root == null)
			root = node;

		Coord tmpNode = root;

		while (true) {

			if (node.x < tmpNode.x) {
				if (tmpNode.left != null)
					tmpNode = tmpNode.left;
				else {
					tmpNode.left = node;
					break;
				}
			}

			else {
				if (tmpNode.right != null)
					tmpNode = tmpNode.right;
				else {
					tmpNode.right = node;
					break;
				}
			}

		}

	}
}

public class The_Directions_Game_OSR {

	static Tree tree;
	static int[] pre, post;
	static int idx;

	public static void preorder(Coord node) {

		if (node == null)
			return;

		pre[idx++] = node.v;
		preorder(node.left);
		preorder(node.right);
	}

	public static void postorder(Coord node) {

		if (node == null)
			return;

		postorder(node.left);
		postorder(node.right);
		post[idx++] = node.v;
	}

	public static int[][] solution(int[][] nodeinfo) {

		ArrayList<Coord> nodeList = new ArrayList<>();
		pre = new int[nodeinfo.length];
		post = new int[nodeinfo.length];

		for (int i = 0; i < nodeinfo.length; i++)
			nodeList.add(new Coord(i + 1, nodeinfo[i][0], nodeinfo[i][1]));

		// y값으로 내림차순 정렬
		Collections.sort(nodeList);

		tree = new Tree(nodeList.get(0));
		
		for (int i = 1; i < nodeList.size(); i++)
			tree.insertNode(nodeList.get(i));

		idx = 0;
		preorder(tree.root);
		idx = 0;
		postorder(tree.root);

		return new int[][] { pre, post };
	}

	public static void main(String[] args) {
		int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
				{ 2, 2 } };

		int[][] answer = solution(nodeinfo);

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < answer[i].length; j++)
				System.out.print(answer[i][j] + " ");
			System.out.println();
		}

	}

}

// 정렬 람다식

//Arrays.sort(answer, (o1, o2) -> {
//if (o1[1] == o2[1])
//	return Integer.compare(o1[0], o2[0]);
//else
//	return Integer.compare(o1[1], o2[1]);
//});

//Arrays.sort(answer, (int[] o1, int[] o2) -> o2[1] - o1[1]);
//
//for (int i = 0; i < answer.length; i++) {
//	for (int j = 0; j < answer[i].length; j++)
//		System.out.print(answer[i][j] + " ");
//	System.out.println();
//}
