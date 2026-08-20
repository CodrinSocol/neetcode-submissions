class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap<>();

        Map<Integer, Integer> shortest = new HashMap<>();

        for(List<Integer> e : edges) {
            graph.putIfAbsent(e.get(0), new ArrayList<>());
            graph.get(e.get(0)).add(new Pair(e.get(1), e.get(2)));
        }

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparing(a -> a.getValue()));
        pq.add(new Pair(src, 0));

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

        for (int i = 0; i < n; i++) {
            if (!shortest.containsKey(i)) {
                shortest.put(i, -1);
            }
        }

        return shortest;
    }  
}
