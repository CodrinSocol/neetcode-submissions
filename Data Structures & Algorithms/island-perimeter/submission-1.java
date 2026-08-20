class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, new HashSet<Pair<Integer, Integer>>(), i, j);
                }
            }
        }
        return 0;
    }


    private int dfs(int[][] grid, Set<Pair<Integer, Integer>> visited, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;

        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0) {
            return 1;
        }
        
        if(visited.contains(new Pair(i, j))) {
            return 0;
        }

        visited.add(new Pair(i, j));

        int left = dfs(grid, visited, i, j-1);
        int right = dfs(grid, visited, i, j+1);
        int up = dfs(grid, visited, i-1, j);
        int down = dfs(grid, visited, i+1, j);


        return left + right + up + down;
    }
}