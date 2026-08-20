class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for(int stone : stones) {
            maxHeap.add(stone);
        }

        while(maxHeap.size() > 1) {
            Integer x = maxHeap.poll();
            Integer y = maxHeap.poll();

            if(x < y) {
                maxHeap.add(y - x);
            } else if (x > y) {
                maxHeap.add(x - y);
            }
        }

        if(maxHeap.size() == 0) {
            return 0;
        }

        return maxHeap.poll();
    }
}
