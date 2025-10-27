package Problem_List.Q629_K_Inverse_Pairs_Array;

class Solution {
	public int kInversePairs(int n, int k) {
		int MOD = 1_000_000_007;
		int[][] dp = new int[n + 1][k + 1];
		
		dp[0][0] = 1;
		
		for (int i = 1; i <= n; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <= k; j++) {
				int val = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
				if (j >= i) {
					val = (val - dp[i - 1][j - i] + MOD) % MOD;
				}
				dp[i][j] = val;
			}
		}
		
		return dp[n][k];
	}
}
