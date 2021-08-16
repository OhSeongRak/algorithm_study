package Week3_LinkedList;
import java.util.*;
import java.io.*;


class LinkedList{
	Node head;
	Node tail;
	LinkedList(){ head = null; }
	 
	private class Node{
		int val;
		Node next;
		Node(){}
		Node(int val){ this.val = val; this.next = null; }
		Node(int val, Node next){ this.val = val; this.next = next; }
	}
	
	public void appendHead(int val) {
		Node newNode= new Node();
		newNode.val = val;
		newNode.next = head;
		head = newNode;
	}
	
	public void appendTail(int val) {
		Node newNode = new Node(val);
		//값을 추가한 노드 newNode 생성
		
		if(head == null) head = newNode;
		//노드가 비어있다면 노드가 곧 newNode
		
		else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		//비어있지 않다면 새로 추가한 노드를 temp에 추가
		
	}
	public int print(int skip) {
		Node temp = head;
		while(skip-->0) {
			temp = temp.next;
		}
		return temp.val;
		//System.out.println(temp.val);
		
	}
}

public class Snail_list_JJW {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());//마지막에서 V번째로 이동
		
		//append number to list
		LinkedList list = new LinkedList();
		//int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			int num = Integer.parseInt(st.nextToken());
			list.appendTail(num);
			//arr[i] = num;
		}
		//list.print();
		
		StringBuilder sb = new StringBuilder();
		
		//question
		while(M-- > 0) {
			int skip = Integer.parseInt(br.readLine());
		
			if(skip >= N){
				int temp = N - V+1;
				while(true) {
					if(skip < N) break;
					skip -= temp;
				}
				//while(skip >= N) { skip -=temp; }
			}
			//sb.append(arr[skip]).append('\n');
			int answer = list.print(skip);
			sb.append(answer).append('\n');
		}
		System.out.print(sb);
		
		
	}

}
