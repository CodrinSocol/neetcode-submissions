class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int n = nums.length;
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] == target) {
                cnt++;
            }
        }

        return cnt > n / 2;
    }
}
