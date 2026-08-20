class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        int i = 0;
        int j = n - 1;

        

        while(i < j && j >= 0 && i < n) {
            int sum = numbers[i] + numbers[j];
            if(sum == target) {
                return new int[]{i + 1,j + 1};
            }

            int mid = (j + i) / 2;

            if(sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{i, j};
    }
}
