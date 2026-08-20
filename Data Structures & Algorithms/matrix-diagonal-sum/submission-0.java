class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;
        int m = mat[0].length;

        for(int i = 0; i < n; i++) {
            sum += mat[i][i];
        }

        for(int j = 0; j < m; j++) {
            if(m % 2 == 1 && j == m / 2) {
                continue;
            }

            sum += mat[j][m - j - 1];
        }

        return sum;
    }
}