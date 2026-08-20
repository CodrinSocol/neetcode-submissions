class Solution {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];

        for(int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }

        int i = 0;

        for(int j = 0; j < 3; j++) {
            while(counts[j] > 0) {
                nums[i++] = j;
                counts[j]--;
            }
        }
    }
}