class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int idx = 0;

        while(idx < nums.length) {
            int cnt = 0;
            while(idx < nums.length && nums[idx] == 1) {
                idx++;
                cnt++;
            }

            if(cnt > max) {
                max = cnt;
            }

            idx++;
        }

        return max;
    }
}