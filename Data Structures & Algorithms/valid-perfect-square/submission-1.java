class Solution {
    public boolean isPerfectSquare(int num) {
        return binarySearch(1, num, num);
    }

    private boolean binarySearch(int l, int r, int num) {
        if(l > r) {
            return false;
        }

        int mid = (l + r) / 2;

        long square = (long) mid * mid;
        if(square == num) {
            return true;
        }

        if(square < num) {
            return binarySearch(mid + 1, r, num);
        } else {
            return binarySearch(l, mid - 1, num);
        }
    }
}