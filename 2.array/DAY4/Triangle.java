import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*class Solution{
    public int minimumTotal(List<List<Integer>> triangle) {
    	int sum = 0;
    	int idx = 0;
    	
    	for(int i = 0; i < triangle.size(); i++) {
    		if(i == 0) {
    			sum += triangle.get(i).get(i);
    			idx = i;
    		}
    		else {
    			sum += Math.min(triangle.get(i).get(idx), triangle.get(i).get(idx + 1));
    			if(triangle.get(i).get(idx) == Math.min(triangle.get(i).get(idx), triangle.get(i).get(idx + 1))) {
    				idx = idx;
    			}
    			else {
    				idx = idx + 1;
    			}
    		}
    	}
    	
    	return sum;
		
    }
}*/

class Solution{
	List<Integer> memo = new ArrayList<Integer>();
    public int minimumTotal(List<List<Integer>> triangle, int i, int j) {
    	if(i == triangle.size()) return 0;
    	if(Integer.parseInt(memo.get(i).toString()) == triangle.get(i).get(j)) return Integer.parseInt(memo.get(i).toString());
    
    	memo.add(Math.min(minimumTotal(triangle, i+1, j), minimumTotal(triangle, i+1, j+1)) + triangle.get(i).get(j));
    		
    	return Math.min(minimumTotal(triangle, i+1, j), minimumTotal(triangle, i+1, j+1)) + triangle.get(i).get(j);
    }
    
}
public class Triangle {

	public static void main(String[] args) {
		List<List<Integer>> triangle;
		
		List<Integer> arr1 = new ArrayList<Integer>();
		arr1.add(2);
		
		List<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(3);
		arr2.add(4);
		
		List<Integer> arr3 = new ArrayList<Integer>();
		arr3.add(6);
		arr3.add(5);
		arr3.add(7);
		
		List<Integer> arr4 = new ArrayList<Integer>();
		arr4.add(4);
		arr4.add(1);
		arr4.add(8);
		arr4.add(3);
		
		triangle = new ArrayList<List<Integer>>();
		triangle.add(arr1);
		triangle.add(arr2);
		triangle.add(arr3);
		triangle.add(arr4);
		
		Solution s = new Solution();
		System.out.println(s.minimumTotal(triangle,0,0));
		
		
	}

}
