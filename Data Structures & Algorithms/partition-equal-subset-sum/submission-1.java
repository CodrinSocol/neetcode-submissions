class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int x : nums) {
            sum += x;
        }

        if(sum % 2 == 1) {
            return false;
        }

        Boolean[][] memo = new Boolean[nums.length][sum / 2 + 1];
        return canPartitionHelper(nums, 0, 0, sum, memo);
    }

    private boolean canPartitionHelper(int[] nums, int i, int currSum, int totalSum, Boolean[][] memo) {
        int n = nums.length;
        int target = totalSum / 2;

        if(currSum == target) {
            return true;
        }

        if(i >= n || currSum > target) {
            return false;
        }

        if(memo[i][currSum] != null) {
            return memo[i][currSum];
        }

        boolean skip = canPartitionHelper(nums, i+1, currSum, totalSum, memo);
        boolean include = canPartitionHelper(nums, i+1, currSum + nums[i], totalSum, memo);

        return memo[i][currSum] = skip || include;
    }
}
