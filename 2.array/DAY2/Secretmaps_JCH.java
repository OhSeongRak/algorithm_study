import java.util.Scanner;

public class Programmers_Secretmaps_JCH {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		int n = input.nextInt();
		
		int [][] res = new int [n][n];
		char [][] answer = new char [n][n];
		int [] arr1 = new int[n];
		int [] arr2 = new int[n];
		int position = n-1;
		
		for(int i = 0; i < n; i++) {
			arr1[i] = input.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			arr2[i] = input.nextInt();
		}
		
		for(int i = 0; i < n; i++) {	//arr1 �κ� �� üũ
			position = n-1;
			while(true) {
				res[i][position] = arr1[i] % 2;	//������ ��ȯ �κ�
				arr1[i] /= 2;
				position--;
				
				if(arr1[i] == 0) {	//arr1 ���� ���� 0�� �ǰų� res�� position�� n-1�� �ɰ�� break
					break;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {	//arr2 �� üũ
			position = n-1;
			while(true) {
				if(res[i][position] == 1) {	//arr1 �� üũ �κп��� �̹� 1�� �� ���� ���� �Ǿ��� �� �״�� �ΰ� ������ ��ȯ �������
					res[i][position] = 1;
					arr2[i] /= 2;
					position --;
				}
				else {						//arr1 �� üũ �κп��� 0�Ͻ� arr2 �� üũ
					res[i][position] = arr2[i] % 2;
					arr2[i] /= 2;
					position --;
				}
				
				if(arr2[i] == 0) {
					break;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(res[i][j]==1) {
					answer[i][j] = '#';
				}
				else {
					answer[i][j] = ' ';
				}
			}
		}
		
		for(int i = 0; i < n; i++) {		//���
			for(int j = 0; j < n; j++) {
				System.out.print(answer[i][j]);
			}
			System.out.println();
		}
	}
}
	
