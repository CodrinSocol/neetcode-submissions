class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        return helper(matrix, target, 0, m - 1);
    }
    private boolean helper(int[][] matrix, int target, int il, int ir) {
        if(il > ir) {
            return false;
        }

        if(il == ir) {
            return findInRow(matrix, target, il, 0, matrix[0].length - 1);
        }


        int im = (il + ir + 1) / 2;
       
        if(target == matrix[im][0]) {
            return true;
        }
    
        if(target < matrix[im][0]) {
            return helper(matrix, target, il, im - 1);
        } else {
            return helper(matrix, target, im, ir);
        }
    }

    private boolean findInRow(int[][] matrix, int target, int row, int l, int r) {
        if(l > r) {
            return false;
        }

        int mid = (l + r + 1) / 2;

        if(matrix[row][mid] == target) {
            return true;
        }

        if(matrix[row][mid] > target) {
            return findInRow(matrix, target, row, l, mid - 1);
        }
        return findInRow(matrix, target, row, mid + 1, r);
    }
}