class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SingleLinkedList {
    Node head;

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void deleteByValue(int data) {
        if (head == null) {
            System.out.println("List kosong.");
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null && current.data != data) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Data " + data + " tidak ditemukan.");
            return;
        }

        previous.next = current.next;
    }

    public void display() {
        if (head == null) {
            System.out.println("List kosong.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtBeginning(5);
        list.insertAtEnd(30);

        System.out.println("Isi list:");
        list.display();

        list.deleteByValue(10);
        System.out.println("Setelah menghapus 10:");
        list.display();

        list.deleteByValue(100); // Data tidak ditemukan
    }
}
