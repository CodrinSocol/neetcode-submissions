class Solution {
    public int search(int[] nums, int target) {
       return searchHelper(nums, target, 0, nums.length - 1);
    }

    private int searchHelper(int[] nums, int target, int low, int high) {
        if(low > high) {
            return -1;
        }

        if(low == high) {
            if (nums[low] == target) {
                return low;
            } else {
                return -1;
            }
        }

        int mid = low + (high-low) / 2;

        if(nums[mid] == target) {
            return mid;
        } else {
            if(nums[mid] > target) {
                return searchHelper(nums, target, low, mid - 1);
            } else {
                return searchHelper(nums, target, mid+1, high);
            }
        }
    }
}
