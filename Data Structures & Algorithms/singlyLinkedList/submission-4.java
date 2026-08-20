class LinkedList {
    class ListNode {
        int value;
        ListNode next;

        public ListNode(int val) {
            this.value = val;
            this.next = null;
        }

        public ListNode(int val, ListNode next) {
            this.value = val;
            this.next = next;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int get(int index) {
        if(index >= size || index < 0) {
            return -1;
        }

        int i = 0;
        ListNode ptr = head;

        while(i < index) {
            ptr = ptr.next;
            i++;
        }

        System.out.println(ptr.value);

        return ptr.value;
    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);

        if(size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        
        size++;
    }

    public void insertTail(int val) {
        ListNode newNode = new ListNode(val);

        if(size == 0) {
            tail = newNode;
            head = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public boolean remove(int index) {
        System.out.println(this.getValues());
        if(index >= size || index < 0) {
            return false;
        }

        int i = 0;
        ListNode ptr = head;

        if(size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            if(index == 0) {
                head = head.next;
            } else {
                while(i < index - 1) {
                    ptr = ptr.next;
                    i++;
                }

            if(ptr.next == null) {
                return true;
            }

            if(ptr.next.next == null) {
                ptr.next = null;
                tail = ptr;
            } else {
                ptr.next = ptr.next.next;
            }

                }
        }

        

        size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ListNode ptr = head;
        ArrayList<Integer> res = new ArrayList<>();

        while(ptr != null) {
            res.add(ptr.value);
            ptr = ptr.next;
        }

        return res;
    }
}
