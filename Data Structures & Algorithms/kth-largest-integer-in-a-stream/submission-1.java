class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k = k;

        for(int num : nums) {
            this.minHeap.offer(num);
            if(minHeap.size() > this.k) {
                this.minHeap.poll();
            }
        }

        System.out.println(this.minHeap.toString());
    }
    
    public int add(int val) {
       this.minHeap.offer(val);
       if(this.minHeap.size() > this.k) {
            this.minHeap.poll();
       }
       System.out.println(this.minHeap.toString());
       return this.minHeap.peek();
    }   
}
