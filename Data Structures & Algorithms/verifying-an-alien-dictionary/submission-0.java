class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> alpha = new HashMap<>();

        for(int i = 0; i < 26; i++) {
            alpha.put(order.charAt(i), i);
        }

        for(int i = 0; i < words.length; i++) {
            for(int j = i+1; j < words.length; j++) {
                if(!compare(words[i], words[j], alpha)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean compare(String w1, String w2, Map<Character, Integer> alpha) {
        boolean flag = true;

        for(int i = 0; i < Math.min(w1.length(), w2.length()); i++) {
            int idx1 = alpha.get(w1.charAt(i));
            int idx2 = alpha.get(w2.charAt(i));

            if(idx1 > idx2) {
                return false;
            }

            if(idx1 < idx2) {
                flag = false;
                break;
            }
        }

        if(flag == true && w1.length() > w2.length()) {
            return false;
        }

        return true;
    }
}