import java.util.ArrayList;
import java.util.List;

public class Triangle_TopToBot_KJY {
	
    public static int minimumTotal(List<List<Integer>> triangle) {
    	//new sublist
    	ArrayList<Integer> rowTriangle = new ArrayList<Integer>();
    	
    	// row circuit
    	for( int row  = 0 ;  row < triangle.size() ; row ++) {
    		
    		
    		if(row == 0)
    			rowTriangle.add(triangle.get(row).get(0));
    		
    		else {
    			
    			// add new row list value
    			for ( int index = 0 ; index < triangle.get(row-1).size(); index++) {
    				rowTriangle.add(triangle.get(row).get(index)+rowTriangle.get(index));
    				rowTriangle.add(triangle.get(row).get(index+1)+rowTriangle.get(index));
    			}
    			// remove past data
    			for ( int i = 0 ; i< triangle.get(row-1).size(); i++)
    				rowTriangle.remove(0);
   
    			// remove overlap data
    			if ( rowTriangle.size() > row +1) {
    			
    				for ( int index = 1 ; index < rowTriangle.size() -1 ; index++) {
    				
    					if ( rowTriangle.get(index)>= rowTriangle.get(index+1))
    						rowTriangle.remove(index);
    					
    					else
    						rowTriangle.remove(index+1);
    				}
    			}
    		}
    	}
    	
    	int answer=10^4;
    	for( int index = 0 ; index < rowTriangle.size() ;index++)
    		if (answer > rowTriangle.get(index))
    			answer = rowTriangle.get(index);
    	
    	
    	return answer;
 
    }
       
    public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
    	
		ArrayList<Integer> triangle0 = new ArrayList<Integer>();
		triangle0.add(2);
		triangle.add(triangle0);
		
		triangle0 = new ArrayList<Integer>();
		triangle0.add(3);
		triangle0.add(4);
		triangle.add(triangle0);

		triangle0 = new ArrayList<Integer>();
		triangle0.add(6);
		triangle0.add(5);
		triangle0.add(7);
		triangle.add(triangle0);		
		
		triangle0 = new ArrayList<Integer>();
		triangle0.add(4);
		triangle0.add(1);
		triangle0.add(8);
		triangle0.add(3);
		triangle.add(triangle0);		

		System.out.println(triangle);
		System.out.println(minimumTotal(triangle));
	}

}
