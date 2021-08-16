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
	
	void insertNode(int n){	//��� �Է��ϴ� �޼ҵ�
		ListNode newNode = new ListNode(n);
		
		if(this.header == null && this.trailer == null) {
			this.header = newNode;		//�ʱ���¿��� ��� ���Խ� header == trailer == newNode
			this.trailer = newNode;
		}
		else {
			this.trailer.next = newNode;	//���� trailer�� next�� newNode ����
			this.trailer = newNode;			//newNode�� trailer�� �ȴ�.
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
		
		for(int i = 0 ;i < n; i++) {			//����Ʈ �Է�
			data = input.nextInt();
			l.insertNode(data);
		}
		
		/*ListNode tmp = l.header;
		
		for(int i = 0 ;i<n;i++) {			//����Ʈ �Է�
			System.out.println(tmp.data);
			tmp = tmp.next;
		}*/
		int [] res = new int[m];
		int [] arr = new int[n];
		ListNode tmp = l.header;
		
		for(int i = 0 ;i < n; i++) {	//�ð��ʰ��� �迭�� ����Ʈ�� �ű�
			arr[i] = tmp.data;
			tmp = tmp.next;
		}
		
		for(int j = 0; j < m; j++) {
			
			k = input.nextInt();
			if(k>=n) {		//k�� n���� ũ�� �ϴ� n��ŭ ���ҽ�Ű�� ������ �ֱ�� ���� �������� ������ �ֱ� �ۿ� �߸� �κ��� �����ش�.
				k -= n;
				k %= (n-(v-1));
				k += (v-1);
			}
			tmp = l.header;
		/*	for(int h = 0; h < k; h++) {	//k��ŭ tmp �̵� <---�ð��ʰ�
				tmp = tmp.next;
			} */
			res[j] = arr[k];
		}
		
		for(int j = 0; j < m; j++) {
			System.out.println(res[j]);
		}
	}
		

}















