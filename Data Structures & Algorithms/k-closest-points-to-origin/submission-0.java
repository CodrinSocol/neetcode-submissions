class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] l1, int[] l2) {
                double d1 = distance(l1[0], l1[1], 0, 0);
                double d2 = distance(l2[0], l2[1], 0, 0);

                if(d1 < d2) {
                    return -1;
                }
                if(d2 < d1) {
                    return 1;
                }

                return 0;
                }
            });

            for(int[] p : points) {
                minHeap.offer(p);
            }

            int[][] result = new int[k][2];

            for(int i = 0; i < k; i++) {
                result[i] = minHeap.poll();
            }

        return result;

    }

    private double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
