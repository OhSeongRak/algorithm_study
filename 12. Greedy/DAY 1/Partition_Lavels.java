package Week12_Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1_Parition_Labels {
	public static List<Integer> partitionLabels(String s) {
		List<Integer> ans = new ArrayList<>();
		
		int n = s.length();
		

		Map<Character,Integer> map = new HashMap<>();
		char[] temp = new char[n];
		temp = s.toCharArray();
		
		for(int i = 0 ; i < n ; i++) {
//			map.put(temp[i], map.getOrDefault(temp[i], 0)+1); 
//			-> 갯수를 구해서 다음 while문에서 수를 삭제시키면서 0이 될 때 인덱스 저장
			map.put(temp[i], i); //마지막 인덱스값을 넣음
		}
		System.out.println(map);
		
		int end = Integer.MIN_VALUE, now = 0;
		
		for(int start = 0 ; start < n ; start++) {
			//앞 순서에 있는 문자의 마지막으로 나타내는 인덱스 값이 나중인 것을 기억
			//그 보다 큰 값이 있으면 end 갱신
			end = Math.max(end, map.get(temp[start]));
			
			if(end == start) {
				//그 인덱스 값이 같아지면 현재값 갱신
				int len = end - now + 1;
				now = end+1;
				ans.add(len);
			}
		}

		
		return ans;
		
	}
	public static void main(String[] args) {
		String s = "ababcbacadefegdehijhklij";
		List<Integer> res = new ArrayList<>();
		res = partitionLabels(s);
		for(int a : res) System.out.println(a);
	}

}
