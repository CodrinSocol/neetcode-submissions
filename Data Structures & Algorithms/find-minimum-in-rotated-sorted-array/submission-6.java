class Solution {
    public int findMin(int[] nums) {
        int minRot = 0;
        int maxRot = nums.length - 1;

        int minEl = nums[0];

        while(minRot <= maxRot) {
           int mid = (maxRot + minRot) / 2;
            minEl = Math.min(minEl, nums[mid]);
          if(nums[minRot] <= nums[mid]) {
            
            if(nums[mid] < nums[maxRot]) {
                maxRot = mid-1;
            } else {
                minRot = mid + 1;
            }
          } else {
            if(nums[mid] <= nums[maxRot]) {
                maxRot = mid-1;
            } else{
                minRot = mid + 1;
            }
          }
        }

        return minEl;
    }
}