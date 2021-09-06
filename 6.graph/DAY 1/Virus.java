import java.util.Scanner;


public class Main {
	static int N;
	static int K;
	static int arr[][];
	static int visit[];
	static int count;
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	N=sc.nextInt();
	K=sc.nextInt();
	
	arr=new int[N+1][N+1];
	visit=new int[N+1];
	for(int i=0;i<K;i++){
		int a=sc.nextInt();
		int b=sc.nextInt();
		arr[a][b]=1;
		arr[b][a]=1;
	}
	
	dfs(1);
	System.out.println(count);
	
}static void dfs(int a){
	visit[a]=1;
	for(int i=1;i<=N;i++){
		if(visit[i]==0&&arr[a][i]==1){
			count++;
			dfs(i);
		}
	}
}
}
