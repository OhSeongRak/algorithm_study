
class Secret_Map_KJY{
	public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0 ; i < n ; i++) {
            answer[i]= "";
        }

        for(int y = 0 ; y < n ; y++){
            int map1Num = arr1[y];
            int map2Num = arr2[y];

            for(int squareNumber = n-1 ; squareNumber>=0; squareNumber--) {
                int map1Quotient= (int) (map1Num/(Math.pow(2,squareNumber)));
                int map2Quotient= (int) (map2Num/(Math.pow(2,squareNumber)));
                if (map1Quotient ==1 || map2Quotient==1) {
                    answer[y] += '#';
                }
                else {
                    answer[y] += ' ';
                }
                map1Num = (int)(map1Num % (Math.pow(2,squareNumber)));
                map2Num = (int)(map2Num % (Math.pow(2,squareNumber)));
            }           
        }
        return answer;
    }
  
}