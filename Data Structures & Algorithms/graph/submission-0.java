class Graph {

    private Map<Integer, List<Integer>> graph;

    public Graph() {
        this.graph = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        if(!graph.containsKey(src)) {
            graph.put(src, new ArrayList<>());
        }

        if(!graph.containsKey(dst)) {
            graph.put(dst, new ArrayList<>());
        }

        if(!graph.get(src).contains(dst)) {
            graph.get(src).add(dst);
        }
    }

    public boolean removeEdge(int src, int dst) {
        if(!graph.containsKey(src) || !graph.containsKey(dst)) {
            return false;
        }

        if(!graph.get(src).contains(dst)) {
            return false;
        }

        graph.get(src).remove((Integer) dst);

        return true;
    }

    public boolean hasPath(int src, int dst) {
         if(!graph.containsKey(src) || !graph.containsKey(dst)) {
            return false;
        }

        Queue<Integer> bfs = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        bfs.add(src);
        visited.add(src);

        while(bfs.size() > 0) {
            int curr = bfs.remove();

            if (curr == dst) return true;

            for(int x : graph.get(curr)) {
                if(!visited.contains(x)) {
                    visited.add(x);
                    bfs.offer(x);
                }

            }
        }

        return false;
    }
}

