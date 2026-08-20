class Solution {
    public int removeElement(int[] nums, int val) {
        int cnt = 0;
        for(int i = 0; i < nums.length - cnt; i++) {
            if(nums[i] == val) {
                shiftFromIdx(nums, i);
                cnt++;
                i--;
            }
        }
        return nums.length - cnt;
    }

    private void shiftFromIdx(int[] nums, int idx) {
        for(int i = idx; i < nums.length - 1; i++) {
            nums[i] = nums[i+1];
        }
    }
}