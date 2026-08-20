class MyHashSet {

    private List<Integer> set;

    public MyHashSet() {
        this.set = new ArrayList<>(1000001);

        for(int i = 0; i <= 1000000; i++) {
            this.set.add(null);
        }
    }
    
    public void add(int key) {
        this.set.set(key, key);
    }
    
    public void remove(int key) {
        this.set.set(key, null);
    }
    
    public boolean contains(int key) {
        return this.set.get(key) != null;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */