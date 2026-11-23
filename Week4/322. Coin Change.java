class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[] memo = new Integer[amount + 1];
        int ans = dp(amount, coins, memo);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int dp(int rem, int[] coins, Integer[] memo) {
        if (rem == 0) {
            return 0;
        }
        if (rem < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[rem] != null) {
            return memo[rem];
        }

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = dp(rem - coin, coins, memo);
            if (sub != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + sub);
            }
        }
        memo[rem] = minCoins;
        return minCoins;
    }
}
