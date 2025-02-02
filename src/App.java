/*
 *  Title: Assignment 4 - Random List with Generics
 *  Created by: Robert Norlander
 *  Email: shamotar@csp.edu
 *  Date: 2025-02-02
 *  Class: CSC 420 - Data Structures and Algorithms
 *  Professor: Susan Furtney
 */

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Created and submitted by: Robert Norlander - shamotar@csp.edu");
        System.out.println("I certify that this is my own work\n");

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("One");
        stringList.add("Two");
        stringList.add("Three");
        stringList.add("Four");
        stringList.add("Five");
        stringList.add("Six");
        stringList.add("Seven");
        stringList.add("Eight");
        stringList.add("Nine");
        stringList.add("Ten");

        System.out.println("New RandomList of Strings");
        testRandomList(stringList, "Eleven");


        System.out.println("New RandomList with Integers");
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);
        intList.add(7);
        intList.add(8);
        intList.add(9);
        intList.add(10);

        testRandomList(intList, 11);


        System.out.println("Process finished with exit code 0");
    }

    public static <T> void testRandomList(ArrayList<T> list, T randomElement) {
        RandomList<T> randomList = new RandomList<>();
        for (T element : list) {
            randomList.randomAdd(element);
        }

        System.out.println("Displaying List using element's default toString() method");
        randomList.printList();

        System.out.println("Displaying Reverse List using element's default toString() method");
        randomList.printReverseList();

        // Remove random element
        System.out.println("Removing a random element...");
        randomList.randomRemove();

        System.out.println("Displaying List after removing a random element");
        randomList.printList();

        // Add random element
        System.out.println("Adding a random element...");
        randomList.randomAdd(randomElement);

        System.out.println("Displaying List after adding a random element");
        randomList.printList();

        // Get random element
        System.out.println("Getting a random element...");
        System.out.println("Random element: " + randomList.randomGet());

        // Get specific element
        System.out.println("Element at index 3: " + randomList.get(3));

        // Get specific element that doesn't exist
        try {
            System.out.println("Element at index 100: " + randomList.get(100));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

    }
}
