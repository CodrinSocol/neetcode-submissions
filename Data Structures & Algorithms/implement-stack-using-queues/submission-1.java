class MyStack {

    private Queue<Integer> q1;
    

    public MyStack() {
        this.q1 = new LinkedList<>();
    }
    
    public void push(int x) {
        this.q1.add(x);
        for(int i = 0; i < this.q1.size() - 1; i++) {
            this.q1.add(this.q1.poll());
        }
    }
    
    public int pop() {
       return this.q1.poll();
    }
    
    public int top() {
        return this.q1.peek();
    }
    
    public boolean empty() {
        return this.q1.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */