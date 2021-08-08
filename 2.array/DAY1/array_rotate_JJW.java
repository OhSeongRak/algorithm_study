import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main{
    public static int N, M, R;
    public static int[][] arr;

    public static void main(String[] args) throws IOException{
    
        
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < M ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        int count = Math.min(N,M)/2; 
        //배열 안 회전시키는 사각형의 수
        
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < count ; j++){
                int temp = arr[j][j];
                for(int k = j + 1 ; k < M - j ; k++){
                    arr[j][k-1] = arr[j][k]; 
                }//위
                for(int k = j + 1 ; k < N - j ; k++){
                    arr[k-1][M-j-1] = arr[k][M-j-1];
                }//오른쪽
                for(int k = M - j - 2 ; k >= j ; k--){
                    arr[N-j-1][k+1] = arr[N-j-1][k];                                                                                                            
                }//아래
                for(int k = N - j - 2 ; k >= j ; k--){
                    arr[k+1][j] = arr[k][j];
                }//왼쪽
                arr[j+1][j] = temp;
                //처음 배열의 맨처음 수인 temp를 다시 넣어줌
                
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }
    
}

