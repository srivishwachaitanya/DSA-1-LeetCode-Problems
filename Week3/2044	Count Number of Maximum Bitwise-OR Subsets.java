class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int num : nums) maxOr |= num;
        return dfs(nums, 0, 0, maxOr);
    }

    private int dfs(int[] nums, int i, int currOr, int maxOr) {
        if (currOr == maxOr) return 1 << (nums.length - i);
        if (i == nums.length) return 0;
        return dfs(nums, i + 1, currOr | nums[i], maxOr)
             + dfs(nums, i + 1, currOr, maxOr);
    }
}
