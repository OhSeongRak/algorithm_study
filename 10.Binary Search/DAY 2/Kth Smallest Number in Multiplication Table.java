package Week10_Binary_Search;

public class Day2_Multiplication_Table {
	 public static int findKthNumber(int m, int n, int k) {
		 int left = 0;
		 int right = m*n;
	     int answer = 0;
	        
	     while(left < right){
	    	 int mid = ( left + right ) / 2;
//	    	 int cnt = getCount(mid, m,n);
	         int count = 0;
	         for(int i = 1 ; i <= m ; i++){
	        	 count += Math.min(mid/i, n); 
	         }//갯수를 구하는 것이 논제!
	         if(count >= k) right = mid;
	         else {
	             left = mid+1;
	         }
	     }
	     return left;

	}
//	public static int getCount(int mid, int m, int n) {
//		int cnt = 0;
//		for(int i = 1 ; i <= m ; i++) {
//			for(int j = 1; j <= n ; j++) {
//				if(mid >= i*j) cnt++;
//				else break;
//			}
//		}
//		return cnt;
//	}
	 
	public static void main(String[] args) {

		int m = 45;
		int n = 12;
		int k = 471;
		System.out.println(findKthNumber(m,n,k));
		

	}

}
