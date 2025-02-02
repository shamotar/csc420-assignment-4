/*
 *  Title: Assignment 4 - Random List with Generics
 *  Created by: Robert Norlander
 *  Email: shamotar@csp.edu
 *  Date: 2025-02-02
 *  Class: CSC 420 - Data Structures and Algorithms
 *  Professor: Susan Furtney
 */

import java.util.Random;

public class RandomList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;
    private Random random;


    /**
     * Node class to represent the elements in the list
     * @param <E> type of the element
     */
    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> previous;

        public Node(E data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public RandomList() {
        head = null;
        tail = null;
        size = 0;
        random = new Random();
    }

    public RandomList(E element) {
        this();
        add(0, element);
    }

    /**
     * Add element to the list at a random index
     * @param element element to be added
     */
    public void randomAdd(E element) {
        add(random.nextInt(size + 1), element);
    }

    /**
     * Remove a random element from the list
     * @return
     */
    public void randomRemove() {
        remove(random.nextInt(size));
    }

    /**
     * Get a random element from the list
     * @return
     */
    public E randomGet() {
        return get(random.nextInt(size));
    }

    /**
     * Add element to the list at the specified index
     * @param index index at which the element is to be added
     * @param element element to be added
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<E> newNode = new Node<>(element);

        
        if (size == 0) {
            // If the list is empty, add the element as the head and tail
            head = newNode;
            tail = newNode;
        } else if (index == 0) {
            // If the index is 0, add the element as the head
            // and set the current head as the next node
            // and set the new node as the previous node of the current head
            // and set the new node as the head
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        } else if (index == size) {
            // If the index is the size of the list, add the element as the tail
            // and set the current tail as the previous node
            // and set the new node as the next node of the current tail
            // and set the new node as the tail
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        } else {
            // If the index is in the middle of the list, add the element at the specified index
            // and set the next node of the new node as the next node of the current node
            // and set the previous node of the new node as the current node
            // and set the new node as the next node of the current node
            // and set the new node as the previous node of the next node of the current node
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.previous = current;
            current.next.previous = newNode;
            current.next = newNode;
        }

        size++;
    }

    /**
     * Remove element from the list at the specified index
     * @param index
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (size == 1) {
            // If the list has only one element, remove the element
            // and set the head and tail to null
            head = null;
            tail = null;
        } else if (index == 0) {
            // If the index is 0, remove the head
            // and set the next node of the head as the new head
            // and set the previous node of the new head as null
            head = head.next;
            head.previous = null;
        } else if (index == size - 1) {
            // If the index is the size of the list, remove the tail
            // and set the previous node of the tail as the new tail
            // and set the next node of the new tail as null
            tail = tail.previous;
            tail.next = null;
        } else {
            // If the index is in the middle of the list, remove the element at the specified index
            // and set the next node of the previous node of the current node as the next node of the current node
            // and set the previous node of the next node of the current node as the previous node of the current node
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
            System.out.println("Removed Element: " + current);
        }

        size--;
    }

    /**
     * Get element from the list at the specified index
     * @param index
     * @return element at the specified index
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " is outside the size of the RandomList - Size: " + size);
        }

        // Step through the list to the specified index
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    /**
     * Print the list
     */
    public void printList() {
        Node<E> current = head;
        int i = 1;
        while (current != null) {
            System.out.print("\t" + i + "> " + current + "\n");
            i++;
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Print the list in reverse
     */
    public void printReverseList() {
        Node<E> current = tail;
        int i = size;
        while (current != null) {
            System.out.print("\t" + i + "> " + current + "\n");
            i--;
            current = current.previous;
        }
        System.out.println();
    }
}
