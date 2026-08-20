class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        int cpy = x;
        int len = 0;

        int mirror = 0;
        

        while(cpy > 0) {
            len++;
            mirror = mirror * 10 + cpy % 10;
            cpy /= 10;
        }

        System.out.println(mirror);
        System.out.println(len);

        for(int i = 0; i < len / 2; i++) {
            if(x % 10 != mirror % 10) {
                return false;
            }

            x = x / 10;
            mirror = mirror /10;
        }

        return true;
    }
}