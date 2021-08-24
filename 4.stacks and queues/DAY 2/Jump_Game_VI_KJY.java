import java.util.Collections;
import java.util.PriorityQueue;

class Jump_Game_VI{
    public static int maxResult(int[] nums, int k) {
    	if (nums.length==1)
    		return nums[0];
    	
    	PriorityQueue<Integer> priorityqueue = new PriorityQueue<Integer>(Collections.reverseOrder());
    	priorityqueue.add(nums[0]);
    	
    	for( int index = 1 ; index< nums.length-1 ; index++) { 		
    		
    		if (nums[index] < 0) {
    			if( priorityqueue.size()<k)
    				priorityqueue.add(priorityqueue.peek()+nums[index]);
    			else {
    				int tmp = priorityqueue.poll()+nums[index];
    				while (!priorityqueue.isEmpty() &&priorityqueue.peek() < tmp) {
    					priorityqueue.remove();
    				}
    				priorityqueue.add(tmp);
    				
    			}
    		}
    		else {
    			int newRoot=priorityqueue.peek()+nums[index];
    			priorityqueue.clear();
    			priorityqueue.add(newRoot);
    		}
    	}
    	
    	return priorityqueue.peek()+nums[nums.length-1];
    	
    }
    public static void main(String[] args) {
    	int[] nums = {1,-1,-1,-1}; 
    	int k = 2;
    	System.out.println(maxResult(nums,k)); //-1
    	int[] nums2 = {40,30,-100,-100,-10,-7,-3,-3}; 
    	k=2;
    	System.out.println(maxResult(nums2,k)); // -40
    	int[] nums3 = {-1,-2,-3,-4,-5,-6};
    	k=2;
    	System.out.println(maxResult(nums3,k)); // -13
    	int[] nums4 = {-6,-5,-4,-3,-2,-1};
    	k=2;
    	System.out.println(maxResult(nums4,k)); // -13
    }
}
