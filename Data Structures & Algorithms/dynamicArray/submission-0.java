class DynamicArray {
    
    private int[] arr;
    private int length;
    private int capacity;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.arr = new int[capacity];
    }

    public int get(int i) {
        return this.arr[i];
    }

    public void set(int i, int n) {
        this.arr[i] = n;

        if(i > this.length) {
            this.length = i;
        }
    }

    public void pushback(int n) {
        if(this.length >= this.capacity) {
            this.resize();
        }

        this.arr[this.length++] = n;
    }

    public int popback() {
        if(this.length > 0) {
            this.length--;
        }
        return this.arr[length];
    }

    private void resize() {
        int[] cpy = new int[2 * this.capacity];
        for(int i = 0; i < this.capacity; i++) {
            cpy[i] = this.arr[i];
        }

        this.capacity = 2 * this.capacity;
        this.arr = cpy;
    }

    public int getSize() {
        return this.length;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
