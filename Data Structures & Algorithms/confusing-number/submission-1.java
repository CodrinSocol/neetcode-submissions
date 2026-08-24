class Solution {
    public boolean confusingNumber(int n) {
        long original = n;
        long rotated = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        int temp = n;
        if (n == 0) return false;
        while (temp > 0) {
            int digit = temp % 10;
            if (!map.containsKey(digit)) {
                return false;
            }
            rotated = rotated * 10 + map.get(digit);
            temp /= 10;
        }

        return rotated != original;
    }
}