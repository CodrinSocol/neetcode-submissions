class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];

        if(nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) {
            return nums[0];
        }

        int first = memo(nums, memo, 0, false);

        Arrays.fill(memo, 0);

        return Math.max(first, memo(nums, memo, 1, true));
    }

    private int memo(int[] nums, int[] memo, int i, boolean includeLast) {
        int n = nums.length;

        if(i >= n) {
            return 0;
        }

        if(i == n - 1) {
            // memo[i] = nums[i];
            if(includeLast) {
                return nums[i];
            }

            return 0;
        }

        if(memo[i] > 0) {
            return memo[i];
        }

        memo[i] = Math.max(nums[i] + memo(nums, memo, i+2, includeLast), memo(nums, memo, i+1, includeLast));

        return memo[i];
    }
}
