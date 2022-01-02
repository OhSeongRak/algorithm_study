package Week8_Heap_and_Priority_Queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Day3_Parking_Tower {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt(); //the # of parking spaces
			int m = sc.nextInt(); // 
			
			int[] r = new int[n];
			PriorityQueue<Integer> r_list = new PriorityQueue<>();
			int[] w = new int[m];
			int[] cur = new int[n];
			
			
			for(int i = 0 ; i < n ; i++) {
				r[i] = sc.nextInt();
				r_list.add(r[i]);
//				r.add(sc.nextInt());
			}
			for(int i = 0 ; i < m ; i++) {
				w[i] = sc.nextInt();
			}
//			
//			PriorityQueue<Integer> parking = new PriorityQueue<>();
//			PriorityQueue<Integer> waiting = new PriorityQueue<>();
			
			Queue<Integer> parking = new LinkedList<>();
			Queue<Integer> waiting = new LinkedList<>();
			//주차요금 = 차량무게 * 단위 무게당 곱한 가격
			//주차가능한 공간 중 번호가 가장 작은 주차공간에 주차하도록 함
			//in -> 주차공간이 비어있다면 주차하고 주차요금 계산/ 비어있지않다면 대기
			//out - > out / 대기 공간 존재한다면 주차
			
			// n = 3 , r = {2,3,5}
			// m = 4 , w = {2,1,3,8}
			// 3 2 -3 1 4 -4 2 -1 2 4
						
			//숫자 입력 받음
			//양수라면 가장 작은 주차공간이 있는지 검사
			//		주차공간 있다면 in 하고 주차요금 계신
			// 		없다면 waiting 
			int sum = 0, cnt = 0, small;
			//음수라면 
			for(int i = 0 ; i < 2 * m ; i++) {
				int car = sc.nextInt();
				parking.add(car);
				
				
			}
			System.out.println(parking);
			
			while(!parking.isEmpty()) {
				int num;
				if(cnt < n  && !waiting.isEmpty()) {
					//out하고 비어있는 공간을 waiting에 대기하는 차가 있다면 채우기
					num = waiting.poll();
					
					for(int i = 0 ; i < n ; i++) {
						if(cur[i] == 0) {
							cur[i] = num;
							sum += w[num-1] * r[i];
							cnt++;
							break;
						}
					}
				}
				else {
					num = parking.poll();

					//in
					if(num > 0) {
						if(cnt < n) {//주차공간 비어있을 경우 
							//small = r_list.poll();
							for(int i = 0 ; i < n ; i++) {
								if(cur[i] == 0){
									cur[i] = num;
									sum += w[num-1] * r[i];
									cnt++;
									break;
								}
							}
						}
						else waiting.add(num);
						//주차공간 없다면 waiting에 대기
					}
				
					//out
					else {

						for(int i = 0 ; i < n; i++) {
							if(cur[i] == -1 * num) {
								cur[i] = 0;
								cnt--;
							}
								
						}
						
					}
				}
				
			}
		
			System.out.println("#"+test_case+" "+sum);
		}

	}

}
