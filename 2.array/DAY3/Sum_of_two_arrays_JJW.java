package Week2_array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Sum_of_two_arrays_JJW {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st ;
    StringBuilder sb = new StringBuilder();
		
		List<Integer> sumA = new ArrayList<>();
		List<Integer> sumB = new ArrayList<>();
		
		int T = Integer.parseInt(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		st  = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < n ; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int m = Integer.parseInt(br.readLine());
		int[] b = new int[m];
		st  = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < m ; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		//부분합
		for(int i = 0 ; i < n ; i++) {
			int sum = 0;
			for(int j = i ; j < n ; j++) {
				sum += a[j]; 
				sumA.add(sum);
			}
		}
		
		for(int i = 0 ; i < m ; i++) {
			int sum = 0;
			for(int j = i ; j < m ; j++) {
				sum += b[j]; 
				sumB.add(sum);
			}
		}
		
		//1
		//////////////////////////////////////////////////////
		//O(n^2)
		long cnt = 0;
		for(int i = 0 ; i < sumA.size() ; i++){
			for(int j = 0 ; j < sumB.size(); j++){
				int sum = sumA.get(i) + sumB.get(j);
				if(sum == T) cnt++;
				else if(sum > T) break;
			}
		}
		
		///////////////////////////////////////////////////
		
		
		//2
		///////////////////////////////////////////////////
		//two pointer Algorithm 
		Collections.sort(sumA);
		Collections.sort(sumB);
		//오름차순으로 정렬 
		
   		List<Integer> list = new ArrayList<Integer>(sumA);
		
		for(int i = 0 ; i < sumB.size() ;i++) {
			list.add(sumB.get(i));
		}
   		//list에 sumA와 sumB를 차례대로 복붙
    
		
    		long cnt = 0;
		int start = 0 ;
		int end = list.size()-1;
		
		while(start < sumA.size() && end >= sumB.size()) {
			int avalue = list.get(start);
			int bvalue = list.get(end);
			long acnt = 0, bcnt = 0;
			int sum = avalue + bvalue;
      
			if(sum == T) {
        		//합이 T와 같다면
				while(start < sumA.size() && list.get(start) == avalue) {
					start++;
					acnt++;
				}
				while(end >= sumB.size() && list.get(end) == bvalue) {
					end--;
					bcnt++;
				}
       				 //중복값이 있을 수 있기 때문에 while문을 이용함
				count += acnt * bcnt;
			}
			else if(sum > T) {
				end--;
			}//합이 T보다 크다면 end 감소
			else if(sum < T) {
				start++;
			}//합이 T보다 작다면 start 증가
			
		}
		
		///////////////////////////////////////////////////////////////////////
		
		

		
		
		sb.append(count);
		System.out.println(sb);
	}

}
