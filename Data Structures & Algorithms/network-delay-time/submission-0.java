class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap<>();

        Map<Integer, Integer> shortest = new HashMap<>();

        for(int[] e : times) {
            graph.putIfAbsent(e[0], new ArrayList<>());
            graph.get(e[0]).add(new Pair(e[1], e[2]));
        }

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparing(a -> a.getValue()));
        pq.add(new Pair(k, 0));

        while(pq.size() > 0) {
            Pair<Integer, Integer> min = pq.poll();
            int dest1 = min.getKey(), w1 = min.getValue();

            if(shortest.containsKey(dest1)) {
                continue;
            }

            shortest.put(dest1, w1);

            if (graph.containsKey(dest1)) {
                for(Pair<Integer, Integer> edge : graph.get(dest1)) {
                    int dest2 = edge.getKey(), w2 = edge.getValue();

                    if(!shortest.containsKey(dest2)) {
                        pq.add(new Pair(dest2, w1 + w2));
                    }
                }
            }
        }

        int longestPath = 0;

        for (int i = 1; i <= n; i++) {
            if (!shortest.containsKey(i)) {
                return -1;
            }
            if(shortest.get(i) > longestPath) {
                longestPath = shortest.get(i);
            }
        }

        return longestPath;
    }
}
