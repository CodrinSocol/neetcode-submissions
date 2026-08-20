class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids.length < 2) {
            return asteroids;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);

        for(int i = 1; i < asteroids.length; i++) {
            if(stack.size() == 0) {
                stack.push(asteroids[i]);
                continue;
            }
            int top = stack.peek();
            int curr = asteroids[i];

            if(sign(top) == sign(curr)) {
                stack.push(curr);
            } else {
                boolean flag = true;
                while(stack.size() > 0 && stack.peek() > 0 && curr < 0) {
                    top = stack.pop();
                    if(Math.abs(top) > Math.abs(curr)) {
                        stack.push(top);
                        flag = false;
                        break;
                    } else if (Math.abs(top) == Math.abs(curr)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    stack.push(curr);
                }
            }
        }
        int[] result = new int[stack.size()];

        for(int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    private int sign(int n) {
        if(n >= 0) {
            return 1;
        } 
        return -1;
    }
}