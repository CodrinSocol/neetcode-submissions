class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(temperatures.length - 1);

        for(int i = temperatures.length - 2; i >= 0; i--) {
            int maxIdx = stack.peek();
            if(temperatures[i] < temperatures[maxIdx]) {
                result[i] = maxIdx - i;
                stack.push(i);
            } else {
                while(stack.size() > 0) {
                    maxIdx = stack.peek();
                    if(temperatures[i] < temperatures[maxIdx]) {
                        result[i] = maxIdx - i;
                        stack.push(i);
                        break;
                    }
                    stack.pop();
                }
                if(stack.size() == 0) {
                    result[i] = 0;
                    stack.push(i);
                }
            }
        }

        return result;
    }
}
