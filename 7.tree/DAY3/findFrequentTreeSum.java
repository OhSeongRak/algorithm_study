	public static int[] findFrequentTreeSum(TreeNode root){
		
		dfs(root);
		//list 에 모든 서브트리의 합이 나옴
		
		System.out.println("hm :" +hm);
		
		
		List<Integer> temp = new ArrayList(hm.keySet());
		
		Collections.sort(temp, (value1, value2) -> (hm.get(value2).compareTo(hm.get(value1))));
	
		for(int val : temp) System.out.println(val);
		
		int value = hm.get(temp.get(0));
		
		for(int val : temp) {
			//val : key값, hm.get(val) :value값
			if(value == hm.get(val)) {
				res.add(val);
			}
			
		}
		
//		System.out.print("res : ");
//		for(int val : res) {
//			System.out.print(val+" ");
//		}
		int len = res.size();
		int[] ans = new int[len];
       
       for(int i = 0 ; i < len ; i++){
           ans[i] = res.get(i);
       }
	
       return ans;
		
	}
	
	public static int dfs(TreeNode root) {
		if (root == null) return 0 ;
		int sum = root.val + dfs(root.left) + dfs(root.right);
		
		//System.out.println("sum : "+sum);
		//System.out.println("sum : " +sum);
		
		hm.put(sum, hm.getOrDefault(sum, 0)+1);
		newhm.put(sum, newhm.getOrDefault(sum, 0)+1);
		
//		list.add(sum);
//		System.out.print("list = ");
//		for(int val : list) {
//			System.out.print(val + " ");
//		}
//		System.out.println();
		return sum;
	}
