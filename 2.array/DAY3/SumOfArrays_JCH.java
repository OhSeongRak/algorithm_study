import java.util.ArrayList;
import java.util.Scanner;

class SumOfArrays_JCH {

	public static void main(String[] args) {
		long [] a = new long [1000];
		long [] b = new long [1000];
		ArrayList<Long> a_sec = new ArrayList<Long>();
		ArrayList<Long> b_sec = new ArrayList<Long>();
		int n,m;
		int t;
		long sum = 0;
		int cnt = 0;
		
		Scanner input = new Scanner(System.in);
		
		t = input.nextInt();
		
		n = input.nextInt();
		for(int i = 0 ; i < n; i++) {
			a[i] = input.nextLong();
		}
		
		m = input.nextInt();
		for(int i = 0 ; i < m; i++) {
			b[i] = input.nextLong();
		}
		
		for(int i = 0 ;i < n;i++) {
			sum = a[i];
			a_sec.add(sum);
			for(int j = i + 1; j < n; j++) {
				sum += a[j];
				a_sec.add(sum);
			}
		}
		
		for(int i = 0 ;i < m;i++) {
			sum = b[i];
			b_sec.add(sum);
			for(int j = i + 1; j < m; j++) {
				sum += b[j];
				b_sec.add(sum);
			}
		}
		
		for(int i = 0 ; i < a_sec.size(); i++) {	//�ʱ� �ڵ� (�����ε� �ð����⵵�� ���ʿ��ϰ� ���ٰ� ��������)
			for(int j = 0; j < b_sec.size(); j++) {
				if(t - a_sec.get(i) == b_sec.get(j)) {
					cnt++;
				}
				
			}
		}
		
		 
		 
		System.out.println(cnt);
		
		
	}

}
