class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int maxEl = 0;

        for(int i = 0; i < nums.length; i++) {
            if(counts.containsKey(nums[i])) {
                counts.replace(nums[i], counts.get(nums[i]) + 1);
            } else {
                counts.put(nums[i], 1);
            }

             if(max < counts.get(nums[i])) {
                max = counts.get(nums[i]);
                maxEl = nums[i];
             }
        }

        System.out.println(counts);

        return maxEl;
    }
}