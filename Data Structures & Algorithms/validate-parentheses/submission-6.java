class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        int n = s.length();

        if(n%2 != 0) {
            return false;
        }

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if(stack.size() == 0) {
                    return false;
                }
                Character prev = stack.pop();

                if(getMatchingBracket(prev) != s.charAt(i)) {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }

    private Character getMatchingBracket(Character c) {
        switch(c) {
            case '[': {
                return ']';
            }
            case '{': {
                return '}';
            }
            case '(': {
                return ')';
            }
            default: {
                return 'a';
            }

        }
    }
}


