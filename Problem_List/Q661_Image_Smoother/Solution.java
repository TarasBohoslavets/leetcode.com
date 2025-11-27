package Problem_List.Q661_Image_Smoother;

class Solution {
	public int[][] imageSmoother(int[][] img) {
		int m = img.length, n = img[0].length;
		int[][] res = new int[m][n];
		
		// напрямки для сусідів (включно з самим центром)
		int[] dirs = {-1, 0, 1};
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int sum = 0, count = 0;
				
				for (int di : dirs) {
					for (int dj : dirs) {
						int ni = i + di, nj = j + dj;
						if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
							sum += img[ni][nj];
							count++;
						}
					}
				}
				
				res[i][j] = sum / count; // округлення вниз автоматично
			}
		}
		
		return res;
	}
}
