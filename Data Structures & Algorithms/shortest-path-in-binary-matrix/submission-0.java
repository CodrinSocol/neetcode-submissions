class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int length = 0;

        Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][0] != 0) {
            return -1;
        }

        q.add(new Pair(0,0));

        List<Pair<Integer, Integer>> directions = new ArrayList<>();

        directions.add(new Pair(0,1));
        directions.add(new Pair(0,-1));
        directions.add(new Pair(1,1));
        directions.add(new Pair(1,0));
        directions.add(new Pair(-1,0));
        directions.add(new Pair(-1,-1));
        directions.add(new Pair(-1,1));
        directions.add(new Pair(1,-1));


        while(q.size() > 0) {
            int qSize = q.size();

            for(int x = 0; x < qSize; x++) {
                Pair<Integer, Integer> curr = q.remove();
                int i = curr.getKey();
                int j = curr.getValue();

                if(i == n - 1 && j == m - 1) {
                    return length + 1;
                }

                for(Pair<Integer, Integer> p : directions) {
                    if(checkValidity(grid, i + p.getKey(), j + p.getValue(), visited)) {
                        
                        q.add(new Pair(i + p.getKey(), j + p.getValue()));
                        visited.add(new Pair(i + p.getKey(), j + p.getValue()));
                    }
                }
            }

            length++;
        }

        return -1;
    }

    private boolean checkValidity(int[][] grid, int i, int j, Set<Pair<Integer, Integer>> visited) {
        int n = grid.length;
        int m = grid[0].length;

        if(Math.min(i, j) < 0 || i >= n || j >= m || visited.contains(new Pair(i,j)) || grid[i][j] != 0) {
            return false;
        }

        return true;
    }
}