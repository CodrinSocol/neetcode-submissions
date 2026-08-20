class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int n = profit.size();
        int m = capacity;

        Integer[] dp = new Integer[m+1];
        Arrays.fill(dp, 0);

        for(int j = 1; j <= m; j++) {
            if(weight.get(0) <= j) {
                dp[j] = profit.get(0);
            }
        }

        for(int i = 1; i < n; i++) {
            Integer[] currRow = new Integer[m+1];
            Arrays.fill(currRow, 0);

            for(int j = 1; j <= m; j++) {
                int skip = dp[j];

                int p = 0;
                if(weight.get(i) <= j) {
                    p = profit.get(i) + dp[j - weight.get(i)];
                }

                currRow[j] = Math.max(p, skip);
            }

            dp = currRow;
         }

         return dp[m];
    }
}
