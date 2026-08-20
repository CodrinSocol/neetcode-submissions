class Solution {
    public int tribonacci(int n) {

        if(n == 0) {
            return 0;
        }

        if(n < 3) {
            return 1;
        }

        int first = 0;
        int second = 1;
        int third = 1;

        int tribo = 2;

        for(int i = 3; i <= n; i++) {
            tribo = first + second + third;
            first = second;
            second = third;
            third = tribo;
        }

        return tribo;
    }
}