class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int currDepth = 0;
        int currOpen = 0;
        int currClosed = 0;

        for(int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case '(': {
                    currOpen++;
                    if(currOpen > currDepth) {
                        currDepth = currOpen;
                    }
                    break;
                }
                case ')': {
                    currClosed++;
                    currOpen--;
                    // if(currClosed == currDepth) {
                    //     maxDepth = Math.max(currDepth, maxDepth);
                    //     currDepth = 0;
                    //     currClosed = 0;
                    // }
                    break;
                }
                default: {
                    continue;
                }
            }
        }

        return currDepth;
    }
}