class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length + 1];
        Arrays.fill(memo, -1);

        return Math.min(memo(cost, memo, 0), memo(cost, memo, 1));
    }

    private int memo(int[] cost, int[] memo, int i) {
        int n = cost.length;

        if(i >= n) {
            return 0;
        }

        if(memo[i] != -1) {
            return memo[i];
        }

        memo[i] = cost[i] + Math.min(memo(cost, memo, i+1), memo(cost, memo, i+2));
        
        return memo[i];
    }
}