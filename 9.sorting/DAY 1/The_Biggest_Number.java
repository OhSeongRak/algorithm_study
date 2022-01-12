package Week9_Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Day1_The_Biggest_Number {
    public static String solution(int[] numbers) {
        String answer = "";

        
        // 9 5 34 3 30 
        // 30 3 -> lenght가 작은 것
        // 그렇군,! 맞네 ㅇㅋ
        
        //99 55 34 30 33
        
        List<String> str_numbers = new ArrayList<>();
        for(int i = 0 ; i < numbers.length ; i++) {
        	str_numbers.add(String.valueOf(numbers[i]));
        }
        Collections.reverse(str_numbers);
        //str_numbers.sort(Collections.reverseOrder(),( (o1, o2) -> ));
        
        
        for(String s : str_numbers) {
        	answer += s;
        }
        
        return answer;
    }
    
    public static String solution1(int[] numbers) {
    	String answer = "";
        //문자열 리턴을 해줄 스트링배열 생성
        String[] str = new String[numbers.length];
        
        //int배열 String배열로 변환
        for(int i = 0; i < numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }     
        
        //내림차순 정렬
//        Arrays.sort(str, new Comparator<String>() {
//            @Override
//            public int compare(String a, String b) {
//                return (b+a).compareTo(a+b);
//                //오름차순 정렬 (o1+o2).compareTo(o1+o2);
//            }
//        });
        
        Arrays.sort(str, (s1, s2) -> (s2+s1).compareTo(s1+s2));

        
        
        //0 값이 중복일경우 ex){0,0,0}
        //답이 000이 나오면 안되므로 첫번째값이 0이면 0을 리턴
        if (str[0].equals("0")) return "0";
        
        //0이 아니면 문자열을 더해준다.
        for(String s: str) answer += s;
 
        return answer;


    }
	public static void main(String[] args) {
//		int[] numbers = { 6,10,2 };
		int[] numbers = { 3,30,34,5,9 };
		System.out.println(solution(numbers));

	}

}
