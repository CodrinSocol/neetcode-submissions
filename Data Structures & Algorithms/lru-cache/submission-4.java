class LRUCache {

    private Map<Integer, Integer> map;
    private List<Integer> lru;
    private int size;
    private int cap;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.lru = new LinkedList<>();
        this.size = 0;
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            lru.remove(new Integer(key));
            lru.add(key);
            return map.get(key);
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
           lru.remove(new Integer(key));
           lru.add(key); 
           map.put(key, value);
           return;
        }

        if(this.size >= this.cap) {
            int first = lru.remove(0);
            map.remove(first);
            size--;
        }

        map.put(key, value);
        lru.add(key);
        size++;
    }
}