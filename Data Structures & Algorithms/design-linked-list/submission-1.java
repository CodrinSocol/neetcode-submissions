class MyLinkedList {

    class ListNode {
        ListNode prev;
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public int get(int index) {
        if(index < 0 || index >= size) {
            return -1;
        }

        ListNode ptr = head;
        int i = 0;

        while(i < index) {
            ptr = ptr.next;
            i++;
        }

        return ptr.val;
    }
    
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);

        if(this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            if(this.size == 1) {
                this.tail.prev = newNode;
                newNode.next = this.tail;
                this.head = newNode;
            } else {
                this.head.prev = newNode;
                newNode.next = this.head;
                this.head = newNode;
            }  
        }
        size++;
    }
    
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);

        if(this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            if(this.size == 1) {
               this.head.next = newNode;
               newNode.prev = this.head;
               this.tail = newNode;
            } else {
                this.tail.next = newNode;
                newNode.prev = this.tail;
                this.tail = newNode;
            }  
        }
        this.size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > this.size) {
            return;
        }

        ListNode newNode = new ListNode(val);

        if(index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            if(index == size) {
                newNode.prev = tail;
                tail.next = newNode;
                tail = newNode;
            } else {

                ListNode ptr = this.head;
                int i = 0;

                while(i < index - 1) {
                    ptr = ptr.next;
                    i++;
                }

                if(ptr.next != null) {
                    ListNode next = ptr.next;
                    next.prev = newNode;
                    newNode.next = next;
                }
                
                ptr.next = newNode;
                newNode.prev = ptr;
            }
        }
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= this.size) {
           return;
        }

         if(index == 0) {
            this.head = this.head.next;
            this.head.prev = null;
        } else if(index == this.size - 1) {
            this.tail = this.tail.prev;
            this.tail.next = null;
        } else {
            ListNode ptr = this.head;
            int i = 0;

            while(i < index - 1) {
                ptr = ptr.next;
                i++;
            }

            if(ptr.next != null) {
                if(ptr.next.next == null){
                    ptr.next = null;
                } else {
                    ptr.next.next.prev = ptr;
                    ptr.next = ptr.next.next;
                }
        }
    }
    size--;
}
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */