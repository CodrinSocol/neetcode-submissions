class Solution {
    public int countOdds(int low, int high) {
        if(high == low) {
            return low % 2 == 1 ? 1 : 0;
        }

        int cnt = 0;

        if(low % 2 == 1) {
            cnt++;
            low++;
        }

        if(high % 2 == 1) {
            cnt++;
            high--;
        }

        if(low < high) {
            cnt += (high - low) / 2;
        }

        return cnt;
    }
}