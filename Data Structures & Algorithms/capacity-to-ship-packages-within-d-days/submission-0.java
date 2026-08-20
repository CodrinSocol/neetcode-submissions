class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 1;
        
        int wSum = 0;

        for(int w : weights) {
            if(w > low) {
                low = w;
            }
            wSum += w;
        }
        int high = wSum;
        int res = wSum;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int currW = 0;
            int nDays = 1;

            for(int i = 0; i < weights.length; i++) {
                
                if(currW + weights[i] > mid) {
                    nDays++;
                    currW = weights[i];
                } else {
                    currW += weights[i];
                }
            }

            if(nDays <= days) {
                res = mid;
                high = mid - 1;
            } else {
               low = mid + 1;
            }
        }

        return res;
    }
}