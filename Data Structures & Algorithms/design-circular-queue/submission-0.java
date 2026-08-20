class MyCircularQueue {
    private int[] q;
    private int start;
    private int end;
    private int capacity;
    private int size;

    public MyCircularQueue(int k) {
        this.q = new int[k];
        this.start = 0;
        this.end = 0;
        this.capacity = k;
        this.size = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }

        q[end] = value;
        end = (end + 1) % capacity;
        size++;

        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }

        start = (start + 1) % capacity;

        size--;
        return true;
    }
    
    public int Front() {
        if(size == 0) {
            return -1;
        }

        return q[start];
    }
    
    public int Rear() {
        if(size == 0) {
            return -1;
        }

        return q[(end - 1 + capacity) % capacity];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */