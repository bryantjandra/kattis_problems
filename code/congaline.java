
import java.util.*;
import java.io.*;

public class congaline {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        HashMap<String, String> partnerMap = new HashMap<>();
        HashMap<String, DequeNode> nodeMap = new HashMap<>();

        String[] firstLine = br.readLine().split(" ");

        int n = Integer.parseInt(firstLine[0]);
        int q = Integer.parseInt(firstLine[1]);

        DequeDS deque = new DequeDS();

        for (int k = 0; k < n; k++) {
            String[] line = br.readLine().split(" ");
            String name = line[0];
            String partner = line[1];
            partnerMap.put(name, partner);
            partnerMap.put(partner, name);

            DequeNode node = new DequeNode(name);
            nodeMap.put(name, node);
            deque.pushBack(node);

            DequeNode node2 = new DequeNode(partner);
            nodeMap.put(partner, node2);
            deque.pushBack(node2);
        }

        String command = br.readLine();

        DequeNode mic = deque.head;

        for (int i = 0; i < q; i++) {
            char action = command.charAt(i);

            if (action == 'F') {
                if (mic.prev != null)
                    mic = mic.prev;
            }

            if (action == 'B') {
                if (mic.next != null)
                    mic = mic.next;
            }

            if (action == 'R') {
                if (mic.next == null) {
                    mic = deque.head;
                } else {
                    DequeNode toBack = mic;
                    mic = mic.next;

                    if (toBack.prev != null) {
                        toBack.prev.next = toBack.next;
                    } else {
                        deque.head = toBack.next;
                    }

                    toBack.next.prev = toBack.prev;

                    // Push toBack to the deque's back
                    toBack.prev = deque.tail;
                    deque.tail.next = toBack;
                    toBack.next = null;
                    deque.tail = toBack;
                }
            }

            if (action == 'C') {
                String name = mic.val;
                String partner = partnerMap.get(name);

                DequeNode personNode = nodeMap.get(name);
                DequeNode partnerNode = nodeMap.get(partner);

                if (mic.next == null) {
                    mic = deque.head;
                } else {
                    mic = mic.next;
                    if (personNode.prev != null) {
                        personNode.prev.next = personNode.next;
                    } else {
                        deque.head = personNode.next;
                    }

                    personNode.next.prev = personNode.prev;
                    personNode.prev = partnerNode;
                    personNode.next = partnerNode.next;

                    if (partnerNode.next != null) {
                        partnerNode.next.prev = personNode;
                    } else {
                        deque.tail = personNode;
                    }

                    partnerNode.next = personNode;
                }
            }
            if (action == 'P') {
                String partner = partnerMap.get(mic.val);
                pw.println(partner);
            }
        }

        pw.println();

        DequeNode curr = deque.head;
        // Iterate through the deque and print the names
        for (int k = 0; k < 2 * n; k++) {
            pw.println(curr.val);
            curr = curr.next;
        }

        pw.flush();
    }
}

class DequeDS {
    DequeNode head;
    DequeNode tail;
    int size;

    public DequeDS() {
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