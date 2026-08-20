class Solution {
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        int pos = high;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            long pow = (long) mid * mid;

            if(pow == x) {
                return mid;
            }

            if(pow > x) {
                high = mid - 1;
            } else {
                pos = mid;
                low = mid + 1;
            }
        }
        return pos;
    }
}