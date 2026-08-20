class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] postfix = new int[n];

        prefix[0] = nums[0];
        postfix[n - 1] = nums[n - 1];

        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        for(int i = n-2; i >= 0; i--) {
            postfix[i] = postfix[i+1] + nums[i];
        }

        for(int i = 0; i < n; i++) {
            int leftSum = (i == 0) ? 0 : prefix[i-1];
            int rightSum = (i == n - 1) ? 0 : postfix[i+1];
            
            if(leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }
}