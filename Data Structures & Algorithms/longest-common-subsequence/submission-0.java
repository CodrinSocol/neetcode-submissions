class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] memo = new int[n][m];

        return memo(text1, text2, 0, 0, memo);
    }

    private int memo(String text1, String text2, int i, int j, int[][] memo) {
        int n = text1.length();
        int m = text2.length();

        if(i >= n || j >= m) {
            return 0;
        }

        if(memo[i][j] > 0) {
            return memo[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + memo(text1, text2, i+1, j+1, memo);
        } else {
            memo[i][j] = Math.max(memo(text1, text2, i+1, j, memo), memo(text1, text2, i, j+1, memo));
        }

        return memo[i][j];
    }
}
