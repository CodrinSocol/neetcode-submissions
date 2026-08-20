class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens) {
            switch(token) {
                case "+": {
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left+right);
                    break;
                }
                case "-": {
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left-right);
                    break;
                }
                case "*": {
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left*right);
                    break;
                }
                case "/": {
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left/right);
                    break;
                }
                default: {
                    int el = Integer.parseInt(token);
                    stack.push(el);
                }
            }
        }
        return stack.pop();
    }
}
