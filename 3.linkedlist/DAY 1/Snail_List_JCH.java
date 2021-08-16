import java.util.Scanner;

class ListNode{
	int data;
	ListNode next;
	
	ListNode(){
		this.next = null;
	}
	ListNode(int n){
		this.data = n;
		this.next = null;
	}
	
		
}

class List{
	ListNode header = null;
	ListNode trailer = null;
	
	void insertNode(int n){	//노드 입력하는 메소드
		ListNode newNode = new ListNode(n);
		
		if(this.header == null && this.trailer == null) {
			this.header = newNode;		//초기상태에서 노드 삽입시 header == trailer == newNode
			this.trailer = newNode;
		}
		else {
			this.trailer.next = newNode;	//기존 trailer의 next에 newNode 삽입
			this.trailer = newNode;			//newNode가 trailer가 된다.
		}
	}
	
}

public class Snail_List_JCH {

	public static void main(String[] args) {
		int n, m, v, k;
		int data;
		boolean checkFirst = false;
		List l = new List();
		
		Scanner input = new Scanner(System.in);
		
		n = input.nextInt();
		m = input.nextInt();
		v = input.nextInt();
		
		for(int i = 0 ;i < n; i++) {			//리스트 입력
			data = input.nextInt();
			l.insertNode(data);
		}
		
		/*ListNode tmp = l.header;
		
		for(int i = 0 ;i<n;i++) {			//리스트 입력
			System.out.println(tmp.data);
			tmp = tmp.next;
		}*/
		int [] res = new int[m];
		int [] arr = new int[n];
		ListNode tmp = l.header;
		
		for(int i = 0 ;i < n; i++) {	//시간초과로 배열에 리스트를 옮김
			arr[i] = tmp.data;
			tmp = tmp.next;
		}
		
		for(int j = 0; j < m; j++) {
			
			k = input.nextInt();
			if(k>=n) {		//k가 n보다 크면 일단 n만큼 감소시키고 달팽이 주기로 나눈 나머지에 달팽이 주기 밖에 잘린 부분을 더해준다.
				k -= n;
				k %= (n-(v-1));
				k += (v-1);
			}
			tmp = l.header;
		/*	for(int h = 0; h < k; h++) {	//k만큼 tmp 이동 <---시간초과
				tmp = tmp.next;
			} */
			res[j] = arr[k];
		}
		
		for(int j = 0; j < m; j++) {
			System.out.println(res[j]);
		}
	}
		

}















