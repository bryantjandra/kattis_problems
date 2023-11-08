class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class customSLL {
    Node head;
    Node tail;

    // Insert at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // add Node
    public void add(Node other) {
        if (this.head == null) {
            this.head = other;
            this.tail = other;
        } else {
            this.tail.next = other;
            this.tail = other;
        }
    }

    // add another SLL
    public void addList(customLL other) {
        if (this.head == null) {
            this.head = other.head;
            this.tail = other.tail;
        } else {
            this.tail.next = other.head;
            this.tail = other.tail;
        }
    }

    // Delete a node with specific data
    public void delete(int data) {
        if (head == null)
            return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }
        if (temp.next == null)
            return; // Data not found
        temp.next = temp.next.next;
    }

    // Reverse the linked list
    public void reverse() {
        Node prev = null, current = head, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    // Print the linked list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Detect cycle in the linked list
    public boolean hasCycle() {
        if (head == null || head.next == null)
            return false;

        Node slow = head;
        Node fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    // Find the middle element
    public Node findMiddle() {
        if (head == null)
            return null;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // Returns middle node
    }

    // Remove cycle if it exists
    public void removeCycle() {
        if (!hasCycle())
            return;

        Node slow = head;
        Node fast = head;

        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }

    // Count nodes in the linked list
    public int countNodes() {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

}
