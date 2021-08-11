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
		
		for(int i = 0; i < n; i++) {	//arr1 부분 벽 체크
			position = n-1;
			while(true) {
				res[i][position] = arr1[i] % 2;	//이진수 변환 부분
				arr1[i] /= 2;
				position--;
				
				if(arr1[i] == 0) {	//arr1 원소 값이 0이 되거나 res의 position이 n-1이 될경우 break
					break;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {	//arr2 벽 체크
			position = n-1;
			while(true) {
				if(res[i][position] == 1) {	//arr1 벽 체크 부분에서 이미 1이 들어가 벽이 생성 되었을 시 그대로 두고 이진수 변환 계속진행
					res[i][position] = 1;
					arr2[i] /= 2;
					position --;
				}
				else {						//arr1 벽 체크 부분에서 0일시 arr2 벽 체크
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
		
		for(int i = 0; i < n; i++) {		//출력
			for(int j = 0; j < n; j++) {
				System.out.print(answer[i][j]);
			}
			System.out.println();
		}
	}
}
	
