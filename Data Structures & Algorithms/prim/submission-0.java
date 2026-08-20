class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        Map<Integer, List<AbstractMap.SimpleEntry<Integer, Integer>>> adj = new HashMap<>();

        for (List<Integer> e : edges) {
            int src = e.get(0);
            int dst = e.get(1);
            int w = e.get(2);

            adj.putIfAbsent(src, new ArrayList<>());
            adj.putIfAbsent(dst, new ArrayList<>());

            adj.get(src).add(new AbstractMap.SimpleEntry<>(dst, w));
            adj.get(dst).add(new AbstractMap.SimpleEntry<>(src, w));
        }

        int minW = 0;

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.get(2), b.get(2)));
        Set<Integer> visited = new HashSet<>();

        visited.add(0);
        if (adj.containsKey(0)) {
            for (AbstractMap.SimpleEntry<Integer, Integer> p : adj.get(0)) {
                pq.add(Arrays.asList(0, p.getKey(), p.getValue()));
            }
        }

        while (!pq.isEmpty() && visited.size() < n) {
            List<Integer> curr = pq.poll();

            if (!visited.contains(curr.get(1))) {
                visited.add(curr.get(1));
                minW += curr.get(2);

                if (adj.containsKey(curr.get(1))) {
                    for (AbstractMap.SimpleEntry<Integer, Integer> p : adj.get(curr.get(1))) {
                        if (!visited.contains(p.getKey())) {
                            pq.add(Arrays.asList(curr.get(1), p.getKey(), p.getValue()));
                        }
                    }
                }
            }
        }

        return visited.size() == n ? minW : -1;
    }
}