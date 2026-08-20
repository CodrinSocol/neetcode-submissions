class StockSpanner {
    private List<Integer> prices;

    public StockSpanner() {
        this.prices = new ArrayList<>();
    }
    
    public int next(int price) {
        this.prices.add(price);
        int cnt = 0;
        for(int i = prices.size() - 1; i >= 0; i--) {
            if(prices.get(i) <= price) {
                cnt++;
            } else {
                break;
            }
        }

        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */