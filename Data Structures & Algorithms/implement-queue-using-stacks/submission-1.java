class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> reverse;

    public MyQueue() {
        this.stack = new Stack<>();
        this.reverse = new Stack<>();
    }
    
    public void push(int x) {
       this.stack.push(x);
    }
    
    public int pop() {
        if(this.reverse.empty()) {
            while(!this.stack.empty()) {
                this.reverse.push(this.stack.pop());
            }
        }

        return this.reverse.pop();
    }
    
    public int peek() {
        if(this.reverse.empty()) {
            while(!this.stack.empty()) {
                this.reverse.push(this.stack.pop());
            }
        }
        return this.reverse.peek();
    }
    
    public boolean empty() {
        return this.stack.empty() && this.reverse.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */