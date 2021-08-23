import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < asteroids.length; i++) {
        	if(asteroids[i] > 0)	stack.push(asteroids[i]);	//��� push
        	else if(asteroids[i] < 0){	//������ ���
        		
        		while(stack.size() > 0 && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i]))	stack.pop();
        		//peek�� ���� ����̰� �� �迭�� ���밪�� ���Ͽ� ���� �� pop
        		if(stack.size()==0 || stack.peek()<0)	stack.push(asteroids[i]);
        		//stack�� ����ų� peek�� ���� �����ΰ�� push
        		else if(stack.size()>0 && stack.peek() == Math.abs(asteroids[i]))	stack.pop();
        		//peek�� ���� �迭�� ���밪�� ���� ��� �Ѵ� ������ pop
        	}
        }

        int cnt = stack.size();
        int []res = new int [cnt];
        for(int i = cnt - 1; i >= 0; i--) {
        	res[i] = stack.pop();
        }
        
        return res;
    }
}
public class Asteroids_Collision_JCH {

	public static void main(String[] args) {
		int[] arr = new int [10];
		
		arr[0] = 10;
		arr[1] = 2;
		arr[2] = -5;
		
		Solution1 s = new Solution1();
		arr = s.asteroidCollision(arr);
		
		for(int a : arr) {
			System.out.println(a);
		}

	}

}
