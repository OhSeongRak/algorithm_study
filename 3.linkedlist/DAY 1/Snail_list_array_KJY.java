import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Snail_list_array_KJY {

   public static void main(String[] args) throws IOException {
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      String s =br.readLine();
      String[] str = s.split(" ");
      int N = Integer.parseInt(str[0]);
      int M = Integer.parseInt(str[1]);
      int V = Integer.parseInt(str[2]);
      
      s = br.readLine();
      str = s.split(" ");
      int[] arr= new int[N];
      for (int i =0 ; i< N; i++) {
         arr[i]= Integer.parseInt(str[i]);
      }
      
      for (int i = 0; i < M; i++) {
         int K = Integer.parseInt(br.readLine());
         if ( K+1 >= V)
        	 K = ((K - (V - 1)) % (N - V + 1)) + (V - 1);
         bw.write(arr[K]+"\n");
      }
      bw.flush();
      bw.close();
   }

}
