package Problem_List.Q576_Out_of_Boundary_Paths;

class Solution {
	private static final int MOD = 1_000_000_007;
	
	public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		int[][][] dp = new int[maxMove + 1][m][n];
		int result = 0;
		
		for (int move = 1; move <= maxMove; move++) {
			for (int row = 0; row < m; row++) {
				for (int col = 0; col < n; col++) {
					for (int[] dir : new int[][]{{0,1},{1,0},{0,-1},{-1,0}}) {
						int newRow = row + dir[0];
						int newCol = col + dir[1];
						
						if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
							dp[move][row][col] = (dp[move][row][col] + 1) % MOD;
						} else {
							dp[move][row][col] = (dp[move][row][col] + dp[move - 1][newRow][newCol]) % MOD;
						}
					}
				}
			}
		}
		
		return dp[maxMove][startRow][startColumn];
	}
}
