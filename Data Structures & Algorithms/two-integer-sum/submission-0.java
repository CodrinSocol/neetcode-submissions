class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            hashMap.put(target - nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])) {
                int idx = hashMap.get(nums[i]);

                if(idx > i) {
                    return new int[]{i, idx};
                } else if(idx != i) {
                    return new int[]{idx, i};
                }
            }
        }

        return new int[2];
    }
}
