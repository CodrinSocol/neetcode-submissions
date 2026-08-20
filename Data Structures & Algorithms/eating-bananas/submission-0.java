class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxK = Integer.MIN_VALUE;
        int minK = 1;

        for(int i = 0; i < piles.length; i++) {
            if(maxK < piles[i]) {
                maxK = piles[i];
            }
        }

        int res = maxK;
        System.out.println(res);

        while(minK <= maxK) {
            long hrs = 0;
            int mid = (maxK + minK) / 2;
            for(int i = 0; i < piles.length; i++) {
                hrs += Math.ceil((double) piles[i] / mid);
            }

            if(hrs <= h) {
                res = mid;
                maxK = mid - 1;
            } else {
                minK = mid + 1;
            }
        }

         return res;
    }
}
