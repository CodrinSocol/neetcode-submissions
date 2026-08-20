class Solution {
    public int buyChoco(int[] prices, int money) {
        int min1 = prices[0];
        int min2 = prices[1];

        if(min1 > min2) {
            min1 = prices[1];
            min2 = prices[0];
        }

        for(int i = 2; i < prices.length; i++) {
            if(prices[i] < min1) {
                min2 = min1;
                min1 = prices[i];
            } else {
                if(prices[i] < min2) {
                    min2 = prices[i];
                }
            }
        }

        if(min1 + min2 > money) {
            return money;
        }
        else {
            return money - min1 - min2;
        }
    }
}