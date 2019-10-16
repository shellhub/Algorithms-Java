package DataStructures;

public class SingleLinkedList {

    private static class Node {
        private int data; /* store data */
        private Node next; /* the pointer of next elem */

        private Node() {

        }

        private Node(int data) {
            this(data, null);
        }

        private Node(int data, Node node) {
            this.data = data;
            this.next = node;
        }
    }

    private Node head; /* the header of LinkedList */

    private int size; /* the current size */

    public SingleLinkedList() {
        head = new Node();
        head.next = null;
        size = 0;
    }

    /**
     * get list size
     *
     * @return {@code size} of list
     */
    public int getSize() {
        return size;
    }

    /**
     * check out whether list is empty or not
     *
     * @return {@code true} if {@code size} equals zero, otherwise {@code false}
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * insert end of list
     *
     * @param data insert value
     */
    public void insert(int data) {
        insert(size, data);
    }

    /**
     * insert front of list
     *
     * @param data insert value
     */
    public void insertFront(int data) {
        insert(0, data);
    }

    /**
     * insert value at pointed position
     *
     * @param position insert position
     * @param data     insert value
     * @throws IndexOutOfBoundsException if {@code position} is invalid
     */
    public void insert(int position, int data) {
        checkBounds(position, 0, size);
        Node cur = head;
        for (int i = 0; i < position; ++i) {
            cur = cur.next;
        }

        Node newNode = new Node(data);
        newNode.next = cur.next;
        cur.next = newNode;

        size++;
    }

    /**
     * delete last node
     */
    public void delete() {
        delete(size - 1);
    }

    /**
     * delete first node
     */
    public void deleteFront() {
        delete(0);
    }

    /**
     * delete node at pointed position
     *
     * @param position delete position
     * @throws IndexOutOfBoundsException if {@code position} is invalid
     */
    public void delete(int position) {
        checkBounds(position, 0, size - 1);
        Node cur = head;
        for (int i = 0; i < position; ++i) {
            cur = cur.next;
        }
        Node destroy = cur.next;
        cur.next = cur.next.next;
        destroy = null; /* let gc clear */

        size--;
    }

    /**
     * clear all node in list
     */
    public void clear() {
        Node prev = head.next;
        Node cur = head.next.next;
        while (cur != null) {
            prev = null; /* clear to let gc do work */
            prev = cur;
            cur = cur.next;
        }
        head.next = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        Node cur = head.next;
        while (cur != null) {
            builder.append(cur.data).append("->");
            cur = cur.next;
        }
        return builder.replace(builder.length() - 2, builder.length(), "").toString();
    }

    public void checkBounds(int position, int low, int high) {
        if (position < low || position > high) {
            throw new IndexOutOfBoundsException(position + "");
        }
    }

    /* Driver */
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.insertFront(0); /* 0 */
        list.insert(1); /* 0 1 */
        list.insert(2); /* 0 1 2 */
        list.insertFront(-1); /* -1 0 1 2 */
        System.out.println(list);

        System.out.println("----------------");

        list.deleteFront(); /* 0 1 2 */
        list.delete(); /* 0 1 */
        list.delete(0); /* 1 */
        System.out.println(list);

        list.clear();
        assert list.isEmpty();
        System.out.println(list);
    }
}
