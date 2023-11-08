
import java.util.*;
import java.io.*;

class Node {
    String value;
    Node next;

    public Node(String value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class customLL {
    Node head;
    Node tail;

    public customLL() {
        this.head = null;
        this.tail = null;
    }

    public void add(Node other) {
        if (this.head == null) {
            this.head = other;
            this.tail = other;
        } else {
            this.tail.next = other;
            this.tail = other;
        }
    }

    public void addList(customLL other) {
        if (this.head == null) {
            this.head = other.head;
            this.tail = other.tail;
        } else {
            this.tail.next = other.head;
            this.tail = other.tail;
        }
    }
}

class joinstrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        customLL[] arrcustomLL = new customLL[N];
        for (int i = 0; i < N; i++) {
            arrcustomLL[i] = new customLL();
            arrcustomLL[i].add(new Node(br.readLine()));
        }
        int storeLastIdx = 0;
        for (int i = 0; i < N - 1; i++) {
            String[] tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            arrcustomLL[a - 1].addList(arrcustomLL[b - 1]);
            storeLastIdx = a - 1;
        }
        Node curr = arrcustomLL[storeLastIdx].head;
        while (curr != null) {
            pw.print(curr.value);
            curr = curr.next;
        }
        pw.flush();
        pw.close();
    }
}