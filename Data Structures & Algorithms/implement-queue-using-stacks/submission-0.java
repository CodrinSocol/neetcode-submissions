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
        while(!empty()) {
            this.reverse.push(this.stack.pop());
        }

        int result = this.reverse.pop();

        while(!this.reverse.empty()) {
            this.stack.push(this.reverse.pop());
        }

        return result;
    }
    
    public int peek() {
         while(!empty()) {
            this.reverse.push(this.stack.pop());
        }

        int result = this.reverse.peek();

        while(!this.reverse.empty()) {
            this.stack.push(this.reverse.pop());
        }

        return result;
    }
    
    public boolean empty() {
        return this.stack.empty();
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