package Week3_LinkedList;

import java.util.*;

import org.w3c.dom.Node;

import java.io.*;

class LinkedPerson{
	Person first;
	Person last;
	
	LinkedPerson(){ first = null; last = null; }
	
	class Person{
		int num;
		Person next;
//		Person(){}
//		Person(int num){ this.num = num; this.next = null; }
//		Person(int num, Person next){ this.num = num; this.next = next; }
	}
	public void addPerson(int num) {
		Person newPerson = new Person();
		newPerson.num = num;
//		newPerson.next = first;
//		first = newPerson;
		
		
		if(first == null) first = newPerson;
		else {
			Person temp = first;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newPerson;
		}
	}
	public int remove() {
		
		int number ;
		
			Person temp = first;
			number = temp.num;
			temp = temp.next;
			first = temp;
			return number;
		
	}
	public int getCount() {
		Person temp = first;
		int count = 0;
		while(temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}
	public void print() {
		Person temp = first;
		
		while(temp != null) {
			System.out.print(temp.num+" ");
			temp = temp.next;
		}
		System.out.println();
	}
}

public class Josephus_JJW {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		LinkedPerson list = new LinkedPerson();
		
		for(int i = 1 ; i <= N ; i++) {
			list.addPerson(i);
		}
		
		List answer = new ArrayList();
		//제거한 값을 추가시켜줌
		
		int cnt = 1;

		//System.out.println(list.getCount());
		
		while(list.getCount() > 0) {
			int remove = list.remove();
			//첫번째 값을 제거후 
			
			if(cnt == K) {
				cnt = 1;
				answer.add(remove);
			}//K가 될때마다 cnt를 1로 초기화를 시켜준 후 제거한 값을 answer에 추가
			else {
				cnt += 1;
				list.addPerson(remove);
			}//그외에는 첫 값을 삭제시키고 맨뒤로 추가시켜줌
		}
		
		System.out.print("<");
		for(int i = 0 ; i < answer.size() ; i++) {
			System.out.print(answer.get(i));
			if(i != answer.size()-1) System.out.print(", ");
		}
		System.out.print(">");
	}

}
