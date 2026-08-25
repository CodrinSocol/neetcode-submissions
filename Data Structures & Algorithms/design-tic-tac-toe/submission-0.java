class TicTacToe {
    private int[][] grid;
    private int n;

    public TicTacToe(int n) {
        grid = new int[n][n];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        grid[row][col] = player == 1 ? 1 : -1;

        int sumCol = 0;
        int sumRow = 0;
        int sumDiag = 0;
        int sumDiag2 = 0;

        for(int i = 0; i < n; i++) {
            sumCol += grid[i][col];
            sumDiag += grid[i][i];
        }

        for(int j = 0; j < n; j++) {
            sumRow += grid[row][j];
            sumDiag2 += grid[j][n - j - 1];
        }

        int nn = (-1) * n;

        if(player == 1 && (sumCol == n || sumRow == n || sumDiag == n || sumDiag2 == n)) {
            return 1;
        } else if(player == 2 && (sumCol == nn || sumRow == nn || sumDiag == nn || sumDiag2 == nn)) {
            return 2;
        }

        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
