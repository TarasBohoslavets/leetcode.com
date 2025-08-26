package Problem_List.Q565_Array_Nesting;

class Solution {
	public int arrayNesting(int[] nums) {
		/*
	    int maxsize=0;
        for(int i=0;i<a.length;i++){
        int size=0;
        for(int k=i;a[k]>=0;size++){
            int ak=a[k];
            a[k]=-1;
            k=ak;
        }
        maxsize=Integer.max(maxsize,size);
       }
       return maxsize;
    }
		 */
		
		boolean[] visited = new boolean[nums.length];
		int maxLen = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				int count = 0;
				int current = i;
				
				while (!visited[current]) {
					visited[current] = true;
					current = nums[current];
					count++;
				}
				
				maxLen = Math.max(maxLen, count);
			}
		}
		
		return maxLen;
	}
}
