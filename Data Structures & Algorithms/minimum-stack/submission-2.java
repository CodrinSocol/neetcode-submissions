class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> min;

    public MinStack() {
        this.stack = new Stack<>();
        this.min = new Stack<>();
    }
    
    public void push(int val) {
        this.stack.push(val);

        if(this.min.size() == 0) {
            this.min.push(val);
        } else {
            Integer top = this.min.peek();
            this.min.push(Math.min(top, val));
        }
    }
    
    public void pop() {
        this.stack.pop();
        this.min.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.min.peek();
    }
}
