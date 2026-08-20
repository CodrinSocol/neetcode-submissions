class Solution {
    public String maximumOddBinaryNumber(String s) {
        int cnt = 0;

        for(char c : s.toCharArray()) {
            if(c == '1') {
                cnt++;
            }
        }

        StringBuilder max = new StringBuilder();

        for(int i = 0; i < cnt - 1; i++) {
            max.append('1');
        }

        for(int i = cnt; i < s.length(); i++) {
            max.append('0');
        }

        max.append('1');

        return max.toString();
    }
}