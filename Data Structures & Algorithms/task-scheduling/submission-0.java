class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frecv = new int[26];
        int max = 0;

        for(char c : tasks) {
            frecv[c - 'A']++;
            if(frecv[c - 'A'] > max) {
                max = frecv[c - 'A'];
            }
        }

        int maxFreq = 0;

        for(int i = 0; i < 26; i++) {
            if(frecv[i] == max) {
                maxFreq++;
            }
        }

        return Math.max(tasks.length, (n+1) * (max - 1) + maxFreq);
    }
}
