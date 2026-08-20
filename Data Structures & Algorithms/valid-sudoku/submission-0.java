class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(!checkSquare(board, i * 3, j * 3)) {
                    return false;
                } 
            }
        }

        for(int i = 0; i < board.length; i++) {
            Set<Integer> elem = new HashSet<>();

            for(int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') continue;
                if(elem.contains(board[i][j] - '0')) {
                    return false;
                }

                elem.add(board[i][j] - '0');
            }
        }

        for(int i = 0; i < board.length; i++) {
            Set<Integer> elem = new HashSet<>();

            for(int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') continue;
                if(elem.contains(board[j][i] - '0')) {
                    return false;
                }

                elem.add(board[j][i] - '0');
            }
        }


        return true;
    }

    private boolean checkSquare(char[][] board, int topI, int topJ) {
        Set<Integer> elem = new HashSet<>();

        for(int i = topI; i < topI + 3; i++) {
            for(int j = topJ; j < topJ + 3; j++) {
                if (board[i][j] == '.') continue;
                if(elem.contains(board[i][j] - '0')) {
                    return false;
                }

                elem.add(board[i][j] - '0');
            }
        }

        return true;
    }
}
