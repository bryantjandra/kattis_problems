class DequeNode {
    String val;
    DequeNode next;
    DequeNode prev;

    public DequeNode(String val) {
        this.val = val;
    }

    public String toString() {
        return this.val;
    }
}

class customDeque {
    DequeNode head;
    DequeNode tail;
    int size;

    public customDeque() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void pushFront(DequeNode node) {
        if (this.size == 0) {
            this.head = node;
            this.tail = node;
        } else {
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }

    public void pushBack(DequeNode node) {
        if (this.size == 0) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
        this.size++;
    }

    public DequeNode popFront() {
        if (isEmpty())
            return null;

        DequeNode temp = head;
        if (head == tail) { // Only one node
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return temp;
    }

    public DequeNode popBack() {
        if (isEmpty())
            return null;

        DequeNode temp = tail;
        if (head == tail) { // Only one node
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return temp;
    }

    public void insertAfter(DequeNode referenceNode, DequeNode newNode) {
        if (referenceNode == tail) {
            pushBack(newNode);
        } else {
            newNode.next = referenceNode.next;
            newNode.prev = referenceNode;
            referenceNode.next.prev = newNode;
            referenceNode.next = newNode;
            size++;
        }
    }

    public void insertBefore(DequeNode referenceNode, DequeNode newNode) {
        if (referenceNode == head) {
            pushFront(newNode);
        } else {
            newNode.next = referenceNode;
            newNode.prev = referenceNode.prev;
            referenceNode.prev.next = newNode;
            referenceNode.prev = newNode;
            size++;
        }
    }

    public void appendDeque(customDeque other) {
        if (other.isEmpty())
            return;
        if (this.isEmpty()) {
            this.head = other.head;
            this.tail = other.tail;
        } else {
            this.tail.next = other.head;
            other.head.prev = this.tail;
            this.tail = other.tail;
        }
        this.size += other.size;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean contains(String value) {
        DequeNode curr = this.head;
        while (curr != null) {
            if (curr.val.equals(value))
                return true;
            curr = curr.next;
        }
        return false;
    }

    public DequeNode[] toArray() {
        DequeNode[] arr = new DequeNode[this.size];
        DequeNode curr = this.head;
        int index = 0;
        while (curr != null) {
            arr[index++] = curr;
            curr = curr.next;
        }
        return arr;
    }

    public void reverse() {
        DequeNode temp = null;
        DequeNode curr = this.head;
        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        if (temp != null) {
            this.tail = this.head;
            this.head = temp.prev;
        }
    }

    public customDeque clone() {
        customDeque newDeque = new customDeque();
        DequeNode curr = this.head;
        while (curr != null) {
            newDeque.pushBack(new DequeNode(curr.val));
            curr = curr.next;
        }
        return newDeque;
    }

    public DequeNode peekFront() {
        return head;
    }

    public DequeNode peekBack() {
        return tail;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        String result = "";
        DequeNode curr = this.head;
        while (curr != null) {
            result += curr.val + " ";
            curr = curr.next;
        }
        return result;
    }
}
