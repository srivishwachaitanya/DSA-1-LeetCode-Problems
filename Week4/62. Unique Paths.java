class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        return dp(0, 0, m, n, memo);
    }

    private int dp(int r, int c, int m, int n, int[][] memo) {
        if (r == m - 1 || c == n - 1) {
            return 1;
        }
        if (memo[r][c] != 0) {
            return memo[r][c];
        }
        memo[r][c] = dp(r + 1, c, m, n, memo) + dp(r, c + 1, m, n, memo);
        return memo[r][c];
    }
}
