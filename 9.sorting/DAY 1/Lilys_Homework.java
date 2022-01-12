package Week9_Sorting;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;

public class Day1_Lilys_Homework {
	public static int lilysHomework(List<Integer> arr) {
		
		//copy -> List arr 값을 배열로 복사한 값
		//m < 값, 인덱스 > -> 원초적으로 위치했던 값과 인덱스 표시
		//sorted -> 오름차순이나 내림차순으로 정렬된 배열
		
		int n = arr.size();
		int[] copy= new int[n];
		Map<Integer, Integer> m = new TreeMap<>();
		
		for(int i = 0 ; i < n ; i++) {
			copy[i] = arr.get(i);
			m.put(copy[i],i);
		}
		
		List<Integer> sorted = new ArrayList<>();
		for(int ks : m.keySet()) sorted.add(ks);
		Collections.sort(sorted);
		
		int asc_count = 0;
		
		for(int i = 0 ; i < n ; i++) {
			if(copy[i] != sorted.get(i)) {
				int idx = m.get(sorted.get(i));
	
				int temp = copy[i];
				copy[i] = copy[idx];
				copy[idx] = temp;
				//m.put(copy[i], i);
				m.put(copy[idx], idx);
				
				asc_count++;
			}
			
		}
		//copy 3 4 2 5 1
		//m (1,4) (2,2) (3,0) (4,1) (5,3)
		//sorted 1 2 3 4 5
		
		// 1 4 2 5 3
		// m (1,4) (2,2) (3,4) (4,1) (5,3)
		
		
		copy = new int[n];
		m = new HashMap<>();
		sorted = new ArrayList<>();
		
		for(int i = 0 ; i < n ; i++) {
			copy[i] = arr.get(i);
			m.put(copy[i],i);
		}
		for(int ks : m.keySet()) sorted.add(ks);
		
		Collections.reverse(sorted);

		int desc_count = 0;
		for(int i = 0 ; i < n ; i++) {
			if(copy[i] != sorted.get(i)) {
				int idx = m.get(sorted.get(i));
	
				int temp = copy[i];
				copy[i] = copy[idx];
				copy[idx] = temp;
				
				m.put(copy[idx], idx);
				
				desc_count++;
			}
			
		}

	
		return Math.min(asc_count, desc_count);

		
	}

	public static void main(String[] args) {

		//int[] arr = {7,15,12,3};
//		int[] arr = {2,5,3,1 };
		List<Integer> arr = new ArrayList<>();
		arr.add(3);
		arr.add(4);
		arr.add(2);
		arr.add(5);
		arr.add(1);
		System.out.println(lilysHomework(arr));
	}

}
