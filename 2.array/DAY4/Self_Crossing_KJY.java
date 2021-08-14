
public class Self_Crossing_KJY {

	// from next index to the end snail?
	public boolean func_snail_check(int[] distance, int index) {
		
		for (index = index + 1; index < distance.length; index++) {
		
			if (distance[index] >= distance[index - 2])
				return true;
		}
		
		return false;
	}

	public boolean isSelfCrossing(int[] distance) {

		if (distance.length < 3)
			return false;

		for (int index = 2; index < distance.length; index++) {
			// subtract is gap [index-2] [index-4]
			int subtract;

			if (index < 4)
				subtract = distance[index - 2];
			else
				subtract = distance[index - 2] - distance[index - 4];
			
			////////////////////////////////////////////////////////////////////
			if (distance[index] < subtract) {
				return func_snail_check(distance, index);
			} 
			
			else if (distance[index] == subtract) {
				
				if (index == 2)
					return func_snail_check(distance, index);
			
				else {
					// subtract2 is gap [index-1] [index-3]
					int subtract2 = distance[index - 1] - distance[index - 3];
					
					// next index is not exist
					if (distance.length < index + 2)
						return false;
		
					else {
						//next line is under gap [index-1][index-3]
						if (distance[index + 1] < subtract2)
							return func_snail_check(distance, index + 1);
						else
							return true;
					}
				}
			} 
			
			else {
				// line mid(subtarct,[index-2])
				if (distance[index] >= subtract && distance[index] <= distance[index - 2]) {
				
					int subtract2 = distance[index - 1] - distance[index - 3];
					
					if (distance.length < index + 2)
						return false;
					
					else {
					
						if (distance[index + 1] < subtract2)
							return func_snail_check(distance, index + 1);
						
						else
							return true;
					}
				} 
				else 
					continue;
				
			}

		}
		return false;
	}

	public static void main(String[] args) {

	}

}
