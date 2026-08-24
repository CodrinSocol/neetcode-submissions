class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word.equals(abbr)) {
            return true;
        }

        int i = 0, k = 0;

        while (i < word.length() && k < abbr.length()) {
            if (Character.isAlphabetic(abbr.charAt(k))) {
                if (word.charAt(i) != abbr.charAt(k)) {
                    return false;
                }
                k++;
                i++;
            }
            else {
                boolean first = true;
                int cnt = 0;
                while(k < abbr.length() && Character.isDigit(abbr.charAt(k))) {
                    if(first == true && abbr.charAt(k) == '0') {
                        return false;
                    }

                    first = false;
                    cnt = cnt * 10 + (abbr.charAt(k) - '0');
                    k++;
                }

                i+=cnt;
            }
        }

        return i == word.length() && k == abbr.length();
    }
}