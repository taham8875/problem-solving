// package com.company;

// import com.company.SingleLinkedList;

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
    public Node previous = null;

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

    public void setPrevious(Node node) {
        this.previous = node;
    }

    public Object getPrevious(Node node) {
        return previous;
    }
}

public class DoubleLinkedList implements ILinkedList {
    /* Implement your linked list class here*/

    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedList() {
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MIN_VALUE);
        head.next = tail;
        tail.previous = head;
    }

    @Override
    public void add(int index, Object element) {
        Node newNode = new Node(element);
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (head.next == tail) {
            this.add(newNode);
        } else if (index == 0) {
            newNode.next = head.next;
            newNode.previous = head;
            newNode.next.previous = newNode;
            newNode.previous.next = newNode;
            ++size;
        } else {
            Node tempNode = head.next;
            for (int i = 0; i < index - 1; i++) {
                tempNode = tempNode.next;
            }
            newNode.next = tempNode.next;
            newNode.previous = tempNode;
            newNode.next.previous = newNode;
            newNode.previous.next = newNode;
            ++size;
        }
    }

    @Override
    public void add(Object element) {
        Node newNode = new Node(element);
        newNode.previous = tail.previous;
        newNode.next = tail;
        newNode.previous.next = newNode;
        newNode.next.previous = newNode;
        ++size;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node tempNode = head.next;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode.data;
    }

    @Override
    public void set(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node tempNode = head.next;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        tempNode.data = element;
    }

    @Override
    public void clear() {
        head.next = tail;
        tail.previous = head;
        size = 0;
        // and the garbage collector will do the rest!
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head.next = head.next.next;
            head.next.previous = head;
            --size;
            return;
        }
        Node tempNode = head.next;
        for (int i = 0; i < index - 1; i++) {
            tempNode = tempNode.next;
        }
        tempNode.next = tempNode.next.next;
        tempNode.next.previous = tempNode;
        --size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public DoubleLinkedList sublist(int fromIndex, int toIndex) {
        if (fromIndex < 0 || fromIndex >= size || toIndex < 0 || toIndex >= size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }

        DoubleLinkedList subList = new DoubleLinkedList();
        Node tempNode = head.next;
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
        if (head.next != tail) {
            Node tempNode = head.next;
            while (tempNode.next != tail) {
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
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner input = new Scanner(System.in);
        String sin = input.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");
        ;
        int[] arr = new int[s.length];
        if (s.length == 1 && s[0].isEmpty()) arr = new int[] {};
        else {
            for (int i = 0; i < s.length; ++i) arr[i] = Integer.parseInt(s[i]);
        }

        DoubleLinkedList linkedList = new DoubleLinkedList();
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
                    DoubleLinkedList subList = new DoubleLinkedList();
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
