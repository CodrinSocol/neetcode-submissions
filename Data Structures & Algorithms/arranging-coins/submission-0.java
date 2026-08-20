class Solution {
    public int arrangeCoins(int n) {
        return (int) binarySearch(1, (long) n, n);
    }

    private long binarySearch(long l, long r, int n) {
        if(l > r) {
            return r;
        }
        long mid = (l + r) / 2;

        long cnt = mid * (mid + 1) / 2;

        if(cnt > n) {
            return binarySearch(l, mid - 1, n);
        } else {
            long nextCnt = (mid + 1) * (mid + 2) / 2;

            if(nextCnt > n) {
                return mid;
            }

            return binarySearch(mid + 1, r, n);
        }
    }
}