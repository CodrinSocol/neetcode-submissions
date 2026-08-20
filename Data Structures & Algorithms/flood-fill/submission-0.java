class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        if(image[sr][sc] == color) {
            return image;
        }

        int startingColor = image[sr][sc];

        helper(image, sr, sc, color, startingColor, visited);

        return image;
    }

    private void helper(int[][] image, int sr, int sc, int color, int startingColor, Set<Pair<Integer, Integer>> visited) {
        int n = image.length;
        int m = image[0].length;
        if(Math.min(sr,sc) < 0 || sr >= n || sc >= m || visited.contains(new Pair(sr,sc)) || image[sr][sc] != startingColor) {
            return;
        }

        image[sr][sc] = color;
        visited.add(new Pair(sr,sc));
        helper(image, sr - 1, sc, color, startingColor, visited);
        helper(image, sr, sc - 1, color, startingColor, visited);
        helper(image, sr + 1, sc, color, startingColor, visited);
        helper(image, sr, sc + 1, color, startingColor, visited);
    }
}