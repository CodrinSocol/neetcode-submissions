class Solution {
    public int removeDuplicates(int[] nums) {
        int ptr = 0;
        int i = 0;
        while(i < nums.length) {
            nums[ptr] = nums[i];

            while(i < nums.length && nums[i] == nums[ptr]) {
                i++;
            }

            ptr++;
        }
        return ptr;
    }
    
}