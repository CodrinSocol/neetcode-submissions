class BrowserHistory {

    private Stack<String> history;
    private LinkedList<String> forward;
    private String current;

    public BrowserHistory(String homepage) {
        this.history = new Stack<>();
        this.forward = new LinkedList<>();
        this.current = homepage;
    }
    
    public void visit(String url) {
        this.history.push(this.current);
        this.forward.clear();
        this.current = url;
    }
    
    public String back(int steps) {
        while(!this.history.empty() && steps > 0) {
            String result = this.history.pop();
            this.forward.addFirst(this.current);
            this.current = result; 
            steps--;
        }

        return this.current;
    }
    
    public String forward(int steps) {
        System.out.println(this.forward);
        while(this.forward.size() > 0 && steps > 0) {
            String result = this.forward.removeFirst();
            this.history.push(this.current);
            this.current = result;

            steps--;
        }

        return this.current;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */