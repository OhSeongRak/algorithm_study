package Week9_Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Day2_Insertion_Sort_Advanced_Analysis {
	static int shift = 0;
	public static int insertionsSort(List<Integer> arr) {
		int n = arr.size();
		int[] copy = new int[n];


		for(int i = 0 ; i < n ; i++) {
			copy[i] = arr.get(i);
		}
		
		//arr 2 1 3 1 2 

		try {
			for(int i = 0 ; i < n-1 ; i++) {
				int j = i;
				while(copy[j] > copy[j+1]) {
					int temp = copy[j];
					copy[j] = copy[j+1];
					copy[j+1] = temp;
					shift++;
					j--;
					if(j < 0) break;
					
				}
			}
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println(0);
		}
		
		for(int val : copy) System.out.print(val + " ");
		System.out.println();
		return shift;
		
	}
	
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		arr.add(2);
		arr.add(1);
		arr.add(3);
		arr.add(1);
		arr.add(2);
		
//		arr.add(4);
//		arr.add(3);
//		arr.add(2);
//		arr.add(1);
		
		System.out.println(insertionsSort(arr));
		

	}

}
