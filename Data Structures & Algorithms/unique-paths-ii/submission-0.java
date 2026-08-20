class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];

        return memo(0,0, memo, obstacleGrid);
    }

    private int memo(int i, int j, int[][] memo, int[][] grid) {
        int m = memo.length;
        int n = memo[0].length;

        if(i >= m || j >= n || grid[i][j] == 1) {
            return 0;
        }

        if(i == m - 1 && j == n - 1) {
            return 1;
        }

        if(memo[i][j] > 0) {
            return memo[i][j];
        }

        memo[i][j] = memo(i+1, j, memo, grid) + memo(i, j+1, memo, grid);

        return memo[i][j];
    }
}