// Class to represent a node in the linked list
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Class to represent the linked list
class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // Method to insert a node at a specific position
    public void insertAtPos(int data, int position) {
        Node newNode = new Node(data);
        if (position == 1) {
            // Inserting at the head of the list
            newNode.next = head;
            head = newNode;
            return;
        }
        // Inserting at a position other than the head
        Node current = head;
        Node prev = null;
        int count = 1;
        while (current != null && count < position) {
            prev = current;
            current = current.next;
            count++;
        }
        if (count != position) {
            System.out.println("Invalid position");
            return;
        }
        prev.next = newNode;
        newNode.next = current;
    }

    // Method to delete a node at a specific position
    public void deleteAtPosition(int position) {
        if (position == 1) {
            if (head != null) {
                head = head.next;
            } else {
                System.out.println("List is empty");
            }
            return;
        }
        Node current = head;
        Node prev = null;
        int count = 1;
        while (current != null && count < position) {
            prev = current;
            current = current.next;
            count++;
        }
        if (count != position || current == null) {
            System.out.println("Invalid position");
            return;
        }
        prev.next = current.next;
    }

    // Method to delete the node after a given node
    public void deleteAfterNode(Node prevNode) {
        if (prevNode == null || prevNode.next == null) {
            System.out.println("Previous node is None or does not have a next node");
            return;
        }
        prevNode.next = prevNode.next.next;
    }

    // Method to search for a node by its value
    public int searchNode(int value) {
        Node current = head;
        int position = 1;
        while (current != null) {
            if (current.data == value) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1;
    }

    // Method to display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("None");
    }

    // Method to get the size of the linked list
    public int size() {
        if (head == null) {
            return 0;
        }
        Node current = head;
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // Main method to test the LinkedList class
    public static void main(String[] args) {
        LinkedList mylinkedlist = new LinkedList();
        mylinkedlist.insertAtPos(5, 1);  // Insert 5 at position 1
        mylinkedlist.insertAtPos(4, 2);  // Insert 4 at position 2
        mylinkedlist.insertAtPos(3, 1);  // Insert 3 at position 1 (head of the list)
        mylinkedlist.deleteAtPosition(2);  // Delete node at position 2
        mylinkedlist.display();  // Display the linked list
    }
}
