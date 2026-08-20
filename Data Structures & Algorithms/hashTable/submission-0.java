class HashTable {

    class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] table;
    private int capacity;
    private int size;

    public HashTable(int capacity) {
        this.table = new Node[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public void insert(int key, int value) {
        int hash = hash(key);
        while (table[hash] != null) {
            if (table[hash].key == key) {
                table[hash].value = value;
                return;
            }
            hash = (hash + 1) % capacity;
        }

        if ((size + 1.0) / capacity >= 0.5) {
            resize();
            hash = hash(key);
            while (table[hash] != null) {
                hash = (hash + 1) % capacity;
            }
        }

        table[hash] = new Node(key, value);
        size++;
    }

    public int get(int key) {
        int hash = hash(key);
        int startHash = hash;

        while(table[hash] != null) {
            if(table[hash].key == key) {
                return table[hash].value;
            }
            hash = (hash + 1) % capacity;
            if (hash == startHash) break;
        }

        return -1;
    }

    public boolean remove(int key) {
        int hash = hash(key);

        while(table[hash] != null) {
            if(table[hash].key == key) {
                table[hash] = null;
                size--;
                int i = (hash + 1) % capacity;
                while (table[i] != null) {
                    Node nodeToRehash = table[i];
                    table[i] = null;
                    size--;
                    insert(nodeToRehash.key, nodeToRehash.value);
                    i = (i + 1) % capacity;
                }
                return true;
            }
            hash = (hash + 1) % capacity;
        }

        return false;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void resize() {
        Node[] oldTable = table;
        this.capacity *= 2;
        this.table = new Node[this.capacity];
        this.size = 0;

        for(Node x : oldTable) {
            if(x != null) {
                insert(x.key, x.value);
            }
        }
    }

    private int hash(int key) {
        return Math.abs(key) % this.capacity;
    }
}