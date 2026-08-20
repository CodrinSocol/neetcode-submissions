class PrefixTree {

    class PTNode {
        Character val;
        Map<Character, PTNode> children = new HashMap<>();
        boolean isEnd = false;

        public PTNode() {
            val = null;
        }

        public PTNode(Character v) {
            val = v;
        }
    }

    PTNode root;

    public PrefixTree() {
        root = new PTNode();
    }

    public void insert(String word) {
        PTNode rootCpy = root;
        int idx = 0;

        while(idx < word.length()) {
            rootCpy.children.putIfAbsent(word.charAt(idx), new PTNode(word.charAt(idx)));
            rootCpy = rootCpy.children.get(word.charAt(idx));
            idx++;
        }
        rootCpy.isEnd = true;
    }

    public boolean search(String word) {
        PTNode rootCpy = root;
        int idx = 0;

        while(rootCpy != null && idx < word.length()) {
            if(!rootCpy.children.containsKey(word.charAt(idx))) {
                return false;
            }
            rootCpy = rootCpy.children.get(word.charAt(idx));
            idx++;
        }

        return idx == word.length() && rootCpy.isEnd;
    }

    public boolean startsWith(String prefix) {
        PTNode rootCpy = root;

        int idx = 0;

        while(rootCpy != null && idx < prefix.length()) {
            if(!rootCpy.children.containsKey(prefix.charAt(idx))) {
                return false;
            }
            rootCpy = rootCpy.children.get(prefix.charAt(idx));
            idx++;
        }

        return idx == prefix.length();
    }
}