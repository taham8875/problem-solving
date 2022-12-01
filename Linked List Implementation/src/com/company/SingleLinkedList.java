package com.company;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface ILinkedList {
    /**
     * Inserts a specified element at the specified position in the list.
     *
     * @param index
     * @param element
     */
    public void add(int index, Object element);
    /**
     * Inserts the specified element at the end of the list.
     *
     * @param element
     */
    public void add(Object element);
    /**
     * @param index
     * @return the element at the specified position in this list.
     */
    public Object get(int index);

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index
     * @param element
     */
    public void set(int index, Object element);
    /** Removes all the elements from this list. */
    public void clear();
    /**
     * @return true if this list contains no elements.
     */
    public boolean isEmpty();
    /**
     * Removes the element at the specified position in this list.
     *
     * @param index
     */
    public void remove(int index);
    /**
     * @return the number of elements in this list.
     */
    public int size();
    /**
     * @param fromIndex
     * @param toIndex
     * @return a view of the portion of this list between the specified fromIndex and toIndex,
     *     inclusively.
     */
    public ILinkedList sublist(int fromIndex, int toIndex);
    /**
     * @param o
     * @return true if this list contains an element with the same value as the specified element.
     */
    public boolean contains(Object o);
}

class Node {
    public Object data;
    public Node next = null;

    public Node(Object data) {
        this.data = data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public Object getNext() {
        return next;
    }
}

public class SingleLinkedList implements ILinkedList {
    /* Implement your linked list class here*/

    Node head;
    private int size = 0;

    @Override
    public void add(int index, Object element) {
        Node newNode = new Node(element);
        if (index < 0) {
            index = 0;
        } else if (index >= size) {
            index = size - 1;
        }

        if (head == null || index == size - 1) {
            this.add(newNode);
        } else if (index == 0) {
            newNode.next = head;
            head = newNode;
            ++size;
        } else {
            Node tempNode = head;
            for (int i = 0; i < index - 1; i++) {
                tempNode = tempNode.next;
            }
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            ++size;
        }
    }

    @Override
    public void add(Object element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
        } else {
            Node tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
        ++size;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node tempNode = head;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode.data;
    }

    public Object getHead() {
        return this.head;
    }

    @Override
    public void set(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node tempNode = head;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        tempNode.data = element;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
        // and the garbage collector will do the rest!
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
            --size;
            return;
        }
        Node tempNode = head;
        for (int i = 0; i < index - 1; i++) {
            tempNode = tempNode.next;
        }
        tempNode.next = tempNode.next.next;
        --size;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public SingleLinkedList sublist(int fromIndex, int toIndex) {
        if (fromIndex < 0 || fromIndex >= size || toIndex < 0 || toIndex >= size) {
            throw new IndexOutOfBoundsException();
        }

        SingleLinkedList subList = new SingleLinkedList();
        if (fromIndex == toIndex) {
            return subList;
        }
        Node tempNode = head;
        for (int i = 0; i < fromIndex; i++) {
            tempNode = tempNode.next;
        }
        for (int i = fromIndex; i <= toIndex; i++) {
            subList.add(tempNode.data);
            tempNode = tempNode.next;
        }
        return subList;
    }

    @Override
    public boolean contains(Object o) {
        if (head != null) {
            Node tempNode = head;
            while (tempNode.next != null) {
                if (tempNode.data.equals(o)) {
                    return true;
                }
                tempNode = tempNode.next;
            }
            return tempNode.data.equals(o);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringOutput = new StringBuilder();

        stringOutput.append("[");
        for (int i = 0; i < size; ++i) {
            stringOutput.append(this.get(i));
            if (i != size - 1) {
                stringOutput.append(", ");
            }
        }
        stringOutput.append("]");
        return stringOutput.toString();
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
        Scanner input = new Scanner(System.in);
        String sin = input.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");
        ;
        int[] arr = new int[s.length];
        if (s.length == 1 && s[0].isEmpty()) arr = new int[] {};
        else {
            for (int i = 0; i < s.length; ++i) arr[i] = Integer.parseInt(s[i]);
        }

        SingleLinkedList linkedList = new SingleLinkedList();
        for (int i = 0; i < arr.length; i++) {
            linkedList.add(arr[i]);
        }

        String function = input.nextLine();
        try {
            switch (function) {
                case "add":
                {
                    int parameterOne = Integer.parseInt(input.nextLine());
                    linkedList.add(parameterOne);
                    break;
                }

                case "addToIndex":
                {
                    int parameterOne = Integer.parseInt(input.nextLine());
                    int parameterTwo = Integer.parseInt(input.nextLine());
                    linkedList.add(parameterOne, parameterTwo);
                    break;
                }
                case "isEmpty":
                {
                    String isEmpty = String.valueOf(linkedList.isEmpty());
                    System.out.println(
                            isEmpty.substring(0, 1).toUpperCase() + isEmpty.substring(1));
                    return;
                }
                case "set":
                {
                    int parameterOne = Integer.parseInt(input.nextLine());
                    int parameterTwo = Integer.parseInt(input.nextLine());
                    linkedList.set(parameterOne, parameterTwo);
                    break;
                }
                case "get":
                {
                    int parameterOne = Integer.parseInt(input.nextLine());
                    System.out.println(linkedList.get(parameterOne));
                    return;
                }
                case "size":
                {
                    System.out.println(linkedList.size);
                    return;
                }
                case "contains":
                {
                    int parameterOne = Integer.parseInt(input.nextLine());
                    String contains = String.valueOf(linkedList.contains(parameterOne));
                    System.out.println(
                            contains.substring(0, 1).toUpperCase() + contains.substring(1));
                    return;
                }
                case "sublist":
                {
                    int parameterOne = Integer.parseInt(input.nextLine());
                    int parameterTwo = Integer.parseInt(input.nextLine());
                    SingleLinkedList subList = new SingleLinkedList();
                    subList = linkedList.sublist(parameterOne, parameterTwo);
                    System.out.println(subList.toString());
                    return;
                }
                case "clear":
                {
                    linkedList.clear();
                    break;
                }
                case "remove":
                {
                    int parameterOne = Integer.parseInt(input.nextLine());
                    linkedList.remove(parameterOne);
                    break;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error");
            return;
        }

        System.out.println(linkedList.toString());
    }
}