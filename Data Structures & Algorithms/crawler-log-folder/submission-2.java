class Solution {
    public int minOperations(String[] logs) {
        int operations = 0;

        for(String s : logs) {
            switch(s) {
                case "../": {
                    operations = Math.max(0, operations - 1);
                    break;
                }
                case "./": {
                    continue;
                }
                default: {
                    operations++;
                }
            }
        }

        return Math.max(0, operations);
    }
}