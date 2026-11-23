class Solution {
    public int rob(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        return dp(0, nums, memo);
    }

    private int dp(int i, int[] nums, Integer[] memo) {
        if (i >= nums.length) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        memo[i] = Math.max(nums[i] + dp(i + 2, nums, memo), dp(i + 1, nums, memo));
        return memo[i];
    }
}
