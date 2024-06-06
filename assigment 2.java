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
// Class to represent a node in the linked list or stack
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Class to represent a stack using a linked list
class Stack {
    private Node head;

    public Stack() {
        this.head = null;
    }

    // Push method inserts the data at the top of the stack
    public void push(int data) {
        Node newNode = new Node(data);  // Create a new node with the given data
        newNode.next = head;  // Link the new node to the current head
        head = newNode;  // Update the head to the new node
    }

    // Pop method removes and returns the data from the top of the stack (Last-in-First-out)
    public int pop() {
        if (head == null) {  // Check if the stack is empty
            System.out.println("Stack is empty");
            return -1;
        }
        int data = head.data;  // Get the data from the top node
        head = head.next;  // Update the head to the next node
        return data;
    }

    // Peek method returns the data at the top of the stack without removing it
    public int peek() {
        if (head == null) {  // Check if the stack is empty
            System.out.println("Stack is empty");
            return -1;
        }
        return head.data;  // Return the data from the top node
    }

    // Display method prints all the elements in the stack
    public void display() {
        Node current = head;  // Start from the head of the stack
        while (current != null) {  // Traverse until the end of the stack
            System.out.print(current.data + "->");  // Print the data of each node
            current = current.next;  // Move to the next node
        }
        System.out.println("None");  // Indicate the end of the stack
    }

    // Main method to test the Stack class
    public static void main(String[] args) {
        Stack myStack = new Stack();
        myStack.push(4);  // Push 4 onto the stack
        myStack.push(5);  // Push 5 onto the stack
        System.out.println("Popped: " + myStack.pop());  // Pop the top element from the stack (5)
        myStack.push(8);  // Push 8 onto the stack
        myStack.display();  // Display the stack
    }
}
