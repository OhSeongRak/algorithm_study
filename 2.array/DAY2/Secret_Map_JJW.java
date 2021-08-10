class Secret_Map_JJW {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[] answer = new String[n];
       
        for(int i = 0 ; i < n ; i++ ){
            answer[i] = "";
        }
        
        StringBuilder sb = new StringBuilder();
        
      
        for(int i = 0 ; i < n ; i++){
          // String str1 = Integer.toBinaryString(arr1[i]);
          // String str2 = Integer.toBinaryString(arr2[i]);
        //10진수를 2진수로 변환해 줌
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            //toBinaryString() : 10진수를 2진수로 변환
            //(|) : | or 논리비트 수행 = 두 값 중 하나라도 1이면 1, 두값 모두 1이면 0으로 처리 
            
            if(answer[i].length() < n){
                answer[i] = "0"+answer[i];
            }
            
        }
        
        for(int i = 0 ; i < n ;i++){
            answer[i] = answer[i].replace("1","#");
            answer[i] = answer[i].replace("0"," ");
           
        }
        return answer;
       
         
            
            
            
    }
}
