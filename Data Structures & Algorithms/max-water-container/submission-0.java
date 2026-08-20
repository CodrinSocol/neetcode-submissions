class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int i = 0;
        int j = heights.length - 1;

        while(i < j && j >= 0 && i < heights.length) {
            int area = Math.min(heights[i], heights[j]) * (j - i);
            if(area > max) {
                max = area;
            }

            if(heights[i] > heights[j]) {
                j--;
            } else {
                i++;
            }

        }

        return max;
    }
}
