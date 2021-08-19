import java.io.*;

class ListNode{
	int value;
	ListNode next;
	
	ListNode(int value){
		this.value = value;
	}
}
class LinkedList{
	ListNode head;
	ListNode tail;
	
	void addLast(int value) {
		ListNode newnode = new ListNode(value);
		if(head==null) {
			head = newnode;
			tail = newnode;
		}
		else {
			tail.next = newnode;
			tail = newnode;
		}
	}
	
	ListNode remove(ListNode tmp) {
		ListNode preTmp= head;
		
		while( preTmp.next != tmp) {
			preTmp=preTmp.next;
		}
		preTmp.next=tmp.next;
		if(tmp == head)
			head = tmp.next;
		return tmp.next;
	}
	
}
public class Josephus_KJY {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input_data=br.readLine();
		int N = Integer.parseInt(input_data.split(" ")[0]);
		int K = Integer.parseInt(input_data.split(" ")[1]);
		
		LinkedList linkedList = new LinkedList();
		
		for (int i = 1 ; i <= N ; i++)
			linkedList.addLast(i);
		
		// circuit connect
		linkedList.tail.next = linkedList.head;
		
		ListNode tmp =  linkedList.head;
		for (int i = 0 ; i< N; i++) {
			
			for ( int j = 0 ; j < K-1 ; j++)
				tmp = tmp .next;
			
			if (i==0)
				System.out.print('<');
			else
				System.out.print(' ');
			System.out.print(tmp.value);
			if(i==N-1)
				System.out.print('>');
			else
				System.out.print(',');
			
			tmp = linkedList.remove(tmp);
			
		}
	}

}
