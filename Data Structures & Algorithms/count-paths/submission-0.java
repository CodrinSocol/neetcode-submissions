class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];

        return memo(0, 0, memo);
    }

    private int memo(int i, int j, int[][] memo) {
        int m = memo.length;
        int n = memo[0].length;

        if(i >= m || j >= n) {
            return 0;
        }

        if(i == m - 1 && j == n - 1) {
            return 1;
        }

        if(memo[i][j] > 0) {
            return memo[i][j];
        }

        memo[i][j] = memo(i+1, j, memo) + memo(i, j+1, memo);

        return memo[i][j];
    }
}
