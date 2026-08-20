class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] redundantEdge = new int[2];

        UnionFind uf = new UnionFind(edges.length);

        for(int[] e : edges) {
            if(!uf.union(e[0], e[1])) {
                redundantEdge = e;
            }
        }

        return redundantEdge;
    }

    class UnionFind {
        private Map<Integer, Integer> parents;
        private Map<Integer, Integer> ranks;

        public UnionFind(int n) {
            parents = new HashMap<>();
            ranks = new HashMap<>();

            for(int i = 1; i <= n; i++) {
                parents.put(i,i);
                ranks.put(i, 0);
            }
        }

        public int find(int n) {
            int p = parents.get(n);

            while(p != parents.get(p)) {
                parents.put(p, parents.get(parents.get(p)));
                p = parents.get(p);
            }

            return p;
        }

        public boolean union(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);

            if(p1 == p2) {
                return false;
            }

            int r1 = ranks.get(p1);
            int r2 = ranks.get(p2);

            if(r1 > r2) {
                parents.put(p2, p1);
            } else if (r1 < r2) {
                parents.put(p1, p2);
            } else {
                parents.put(p1, p2);
                ranks.put(p1, ranks.get(p1) + 1);
            }

            return true;
        }
    }
}
