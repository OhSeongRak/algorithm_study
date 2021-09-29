import java.util.Scanner;

class Solution {
	static class Node {
		int num;
		String data;
		Node left;
		Node right;

		Node() {
			num = 0;
			data = null;
			left = null;
			right = null;
		}
	}

	static class Tree {
		Node root;
		Node tmp;
		Tree() {
			root = null;
		}

		Node addParentNode(int num, String parentNodeData) {
			if (root == null) {
				root = new Node();
				root.num = num;
				root.data = parentNodeData;
				return root;
			} else {
				searchParent(root, num);
				tmp.data = parentNodeData;
				return tmp;
			}
		}

		void addLeftNode(Node parentNode, int num) {
			Node newNode = new Node();
			newNode.num = num;
			parentNode.left = newNode;

		}

		void addRightNode(Node parentNode, int num) {
			Node newNode = new Node();
			newNode.num = num;
			parentNode.right = newNode;
		}

		void searchParent(Node root, int num) {
			if(root==null)
				return;
			if(root.num==num)
				this.tmp = root;
			searchParent(root.left,num);
			searchParent(root.right,num);	
		}
		void inOrder(Node node) {
			if(node!=null) {
				inOrder(node.left);
				System.out.print(node.data);
				inOrder(node.right);
			}
		}

	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		

		for (int test_case = 1; test_case <= 10; test_case++) {
			Tree tree = new Tree();
			int numNode = sc.nextInt();
			String trash = sc.nextLine();
			for (int i = 0; i < numNode; i++) {
				
				String Line = sc.nextLine();
				
				int parentNodeNum = Integer.parseInt(Line.split(" ")[0]);
				String parentNodeData = Line.split(" ")[1];
				
				Node parentNode = tree.addParentNode(parentNodeNum, parentNodeData);

				if ( Line.split(" ").length>=3) {
					int leftNodeNum = Integer.parseInt(Line.split(" ")[2]);
					tree.addLeftNode(parentNode, leftNodeNum);
						
				}
				if (Line.split(" ").length>=4) {
					int rightNodeNum = Integer.parseInt(Line.split(" ")[3]);
					tree.addRightNode(parentNode, rightNodeNum);
				}

			}
			System.out.printf("#%d ",test_case);
			tree.inOrder(tree.root);
			System.out.println("");

		}
	}
}
