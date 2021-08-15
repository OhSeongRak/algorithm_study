import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class ListNode {
	public int data;
	public ListNode link;

	public ListNode(int data) {
		this.data = data;
		this.link = null;
	}
}

class LinkedList {
	public ListNode head;
	public ListNode tail;

	public LinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void addLast(int data) {
		ListNode newNode = new ListNode(data);
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.link = newNode;
			tail = newNode;
		}
	}

	public int[] circuit(int N) {
		ListNode tmp = this.head;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++, tmp = tmp.link) {
			arr[i] = tmp.data;
		}
		return arr;
	}
}

public class Snail_list_linkedlist_KJY {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		String[] str = s.split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int V = Integer.parseInt(str[2]);

		s = br.readLine();
		str = s.split(" ");

		LinkedList linkedList = new LinkedList();

		for (int i = 0; i < N; i++) {
			linkedList.addLast(Integer.parseInt(str[i]));
		}

		int[] K = new int[M];
		for (int index = 0; index < M; index++) {
			K[index] = Integer.parseInt(br.readLine());
			if (K[index] + 1 >= V)
				K[index] = (((K[index]) - (V - 1)) % (N - V + 1)) + (V - 1);
		}
		int[] arr = linkedList.circuit(N);

		for (int index = 0; index < M; index++)
			bw.write(arr[K[index]]+"\n");
		bw.flush();
		bw.close();
	}

}