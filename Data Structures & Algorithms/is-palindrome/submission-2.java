class Solution {
    public boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();
        System.out.println(s);
        
        while(i < j) {
            if(!isAlphaNum(s.charAt(i))) {
                i++; continue;
            }
            if(!isAlphaNum(s.charAt(j))) {
                j--; continue;
            }

            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    private boolean isAlphaNum(char c) {
        if(c >= 'a' && c <= 'z') {
            return true;
        }

        if(c >= '0' && c <= '9') {
            return true;
        }

        if(c >= 'A' && c <= 'Z') {
            return true;
        }

        return false;
    }
}
