class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();

        Map<Integer, Double> shortest = new HashMap<>();

        for(int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            graph.putIfAbsent(e[0], new ArrayList<>());
            graph.get(e[0]).add(new Pair(e[1], succProb[i]));
            graph.putIfAbsent(e[1], new ArrayList<>());
            graph.get(e[1]).add(new Pair(e[0], succProb[i]));
        }

        PriorityQueue<Pair<Integer, Double>> pq = new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));

        pq.add(new Pair(start_node, 1.0));

        while(pq.size() > 0) {
            Pair<Integer, Double> min = pq.poll();
            int dest1 = min.getKey();
            double w1 = min.getValue();

            if(shortest.containsKey(dest1)) {
                continue;
            }

            shortest.put(dest1, w1);
            
            if (dest1 == end_node) break;

            if (graph.containsKey(dest1)) {
                for(Pair<Integer, Double> edge : graph.get(dest1)) {
                    int dest2 = edge.getKey();
                    double w2 = edge.getValue();

                    if(!shortest.containsKey(dest2)) {
                        pq.add(new Pair(dest2, w1 * w2));
                    }
                }
            }
        }

        if(!shortest.containsKey(end_node)) {
            return 0;
        }

        return shortest.get(end_node);
    }
}