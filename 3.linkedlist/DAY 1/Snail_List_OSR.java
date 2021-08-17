package LinkedList;

import java.util.Scanner;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class Snail_List_OSR {

	static int N, M, V;

	public static int findVal(ListNode head, int valIdx) {
		if (valIdx < N) {
			for (int i = 0; i < valIdx; i++)
				head = head.next;

			return head.val;
		}

		// V번째 노드
		ListNode startPoint = head;
		// 순환 연결리스트 길이
		int len = N - V + 1;
		int idx = (valIdx - V + 1) % len;
		
		for (int i = 0; i < V - 1; i++)
			startPoint = startPoint.next;

		for(int i = 0; i < idx; i++)
			startPoint = startPoint.next;
		
		return startPoint.val;
	}

	public static ListNode insertNode(ListNode head, int data) {
		ListNode newNode = new ListNode(data);
		if (head == null)
			head = newNode;
		else {
			ListNode tempNode = head;

			while (tempNode.next != null)
				tempNode = tempNode.next;

			tempNode.next = newNode;
		}

		return head;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ListNode head = null;

		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();

		for (int i = 0; i < N; i++)
			head = insertNode(head, sc.nextInt());

		ListNode tail = head;
		ListNode intersect = head;

		for (int i = 0; i < N - 1; i++) {
			if (i == V - 1)
				intersect = tail;

			tail = tail.next;
		}

		tail.next = intersect;

		for (int i = 0; i < M; i++)
			System.out.println(findVal(head, sc.nextInt()));

	}

}
