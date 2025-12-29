package Problem_List.Q688_Knight_Probability_in_Chessboard;

class Solution {
	public double knightProbability(int n, int k, int row, int column) {
		int[][] dirs = {{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
		double[][] dp = new double[n][n];
		dp[row][column] = 1.0;
		
		for (int step = 1; step <= k; step++) {
			double[][] next = new double[n][n];
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					if (dp[r][c] > 0) {
						for (int[] d : dirs) {
							int nr = r + d[0], nc = c + d[1];
							if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
								next[nr][nc] += dp[r][c] / 8.0;
							}
						}
					}
				}
			}
			dp = next;
		}
		
		double result = 0.0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				result += dp[r][c];
			}
		}
		return result;
	}
}