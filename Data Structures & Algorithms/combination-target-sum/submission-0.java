class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(target == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        if(target < 0) return res;

        for(int i = 0; i < nums.length; i++) {
            List<List<Integer>> sub = combinationSum(Arrays.copyOfRange(nums, i, nums.length), target-nums[i]);

            for(List<Integer> x : sub) {
                List<Integer> newList = new ArrayList<>(x);
                newList.add(nums[i]);
                res.add(newList);
            }
        }

        return res;
    }
}