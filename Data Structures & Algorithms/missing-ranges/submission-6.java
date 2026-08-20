class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> intervals = new ArrayList<>();

        if(nums.length == 0) {
            intervals.add(Arrays.asList(lower, upper));
            return intervals;
        }

        if(nums[0] > lower) {
             intervals.add(Arrays.asList(lower, nums[0] - 1));
        }

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < lower) {
                continue;
            }

            if(nums[i] > upper) {
                break;
            }

            if(nums[i] - nums[i-1] > 1) {
                intervals.add(new ArrayList<>(Arrays.asList(nums[i-1] + 1, nums[i] - 1)));
            }
        }
        if(nums[nums.length - 1] < upper) {
            intervals.add(new ArrayList<>(Arrays.asList(nums[nums.length-1]+1, upper)));
        }


        return intervals;
    }
}
