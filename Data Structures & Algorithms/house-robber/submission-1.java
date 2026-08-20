class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }

        if(n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] memo = new int[n];
        memo[n - 1] = nums[n - 1];
        memo[n - 2] = nums[n - 2];

        helper(nums, 0, memo);

        return memo[0];
    }

    private void helper(int[] nums, int start, int[] memo) {
        if(start >= nums.length - 2 || memo[start] != 0) {
            return;
        }


        helper(nums, start + 2, memo);
        helper(nums, start + 1, memo);

        int left = start + 2 >= nums.length ? 0 : memo[start + 2];
        int right = start + 1 >= nums.length ? 0 : memo[start + 1];

        memo[start] = Math.max(nums[start] + left, right);
    }
}
