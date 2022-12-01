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

class DoubleLinkedList implements ILinkedList {
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
        if (index <= 0) {
            index = 0;
        } else if (index >= size) {
            index = size - 1;
        }
        if (head.next == tail || index == size - 1) {
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
        if (fromIndex < 0 || fromIndex >= size || toIndex < 0 || toIndex >= size) {
            throw new IndexOutOfBoundsException();
        }

        DoubleLinkedList subList = new DoubleLinkedList();
        if (fromIndex == toIndex) {
            return subList;
        }
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
}

interface IPolynomialSolver {
    /**
     * Set polynomial terms (coefficients & exponents)
     *
     * @param poly: name of the polynomial
     * @param terms: array of [coefficients][exponents]
     */
    void setPolynomial(char poly, int[] terms);

    /**
     * Print the polynomial in ordered human-readable representation
     *
     * @param poly: name of the polynomial
     * @return: polynomial in the form like 27x^2+x-1
     */
    String print(char poly);

    /**
     * Clear the polynomial
     *
     * @param poly: name of the polynomial
     */
    void clearPolynomial(char poly);

    /**
     * Evaluate the polynomial
     *
     * @param poly: name of the polynomial
     * @param value: the polynomial constant value
     * @return the value of the polynomial
     */
    float evaluatePolynomial(char poly, float value);

    /**
     * Add two polynomials
     *
     * @param poly1: first polynomial
     * @param poly2: second polynomial
     * @return the result polynomial
     */
    int[] add(char poly1, char poly2);

    /**
     * Subtract two polynomials
     *
     * @param poly1: first polynomial
     * @param poly2: second polynomial
     * @return the result polynomial
     */
    int[] subtract(char poly1, char poly2);

    /**
     * Multiply two polynomials
     *
     * @param poly1: first polynomial
     * @param poly2: second polynomial
     * @return: the result polynomial
     */
    int[] multiply(char poly1, char poly2);
}

public class PolynomialSolver implements IPolynomialSolver {

    public DoubleLinkedList A = new DoubleLinkedList();
    public DoubleLinkedList B = new DoubleLinkedList();
    public DoubleLinkedList C = new DoubleLinkedList();
    public DoubleLinkedList R = new DoubleLinkedList();

    @Override
    public void setPolynomial(char poly, int[] terms) {
        DoubleLinkedList polynomial = new DoubleLinkedList();
        for (int i = terms.length - 1; i >= 0; i--) {
            polynomial.add(terms[i]);
        }
        switch (Character.toUpperCase(poly)) {
            case 'A':
                {
                    A = polynomial;
                    break;
                }
            case 'B':
                {
                    B = polynomial;
                    break;
                }
            case 'C':
                {
                    C = polynomial;
                    break;
                }
            case 'R':
                {
                    R = polynomial;
                    break;
                }
        }
    }

    @Override
    public String print(char poly) {
        StringBuilder stringOutput = new StringBuilder();
        DoubleLinkedList temp = new DoubleLinkedList();
        switch (Character.toUpperCase(poly)) {
            case 'A':
                {
                    temp = A;
                    break;
                }
            case 'B':
                {
                    temp = B;
                    break;
                }
            case 'C':
                {
                    temp = C;
                    break;
                }
            case 'R':
                {
                    temp = R;
                    break;
                }
        }

        for (int i = temp.size() - 1; i >= 0; i--) {
            if ((Integer) temp.get(i) >= 0 && i != temp.size() - 1) {
                stringOutput.append("+");
            }
            if ((Integer) temp.get(i) != 1) {
                stringOutput.append(temp.get(i));
            }

            if (i > 1) {
                stringOutput.append("x^").append(i);
            }
            if (i == 1) {
                stringOutput.append("x");
            }
        }
        return stringOutput.toString();
    }

    @Override
    public void clearPolynomial(char poly) {
        switch (Character.toUpperCase(poly)) {
            case 'A':
                {
                    A.clear();
                    break;
                }
            case 'B':
                {
                    B.clear();
                    break;
                }
            case 'C':
                {
                    C.clear();
                    break;
                }
            case 'R':
                {
                    R.clear();
                    break;
                }
        }
    }

    @Override
    public float evaluatePolynomial(char poly, float value) {
        DoubleLinkedList temp = new DoubleLinkedList();
        int result = 0;
        switch (Character.toUpperCase(poly)) {
            case 'A':
                {
                    temp = A;
                    break;
                }
            case 'B':
                {
                    temp = B;
                    break;
                }
            case 'C':
                {
                    temp = C;
                    break;
                }
            case 'R':
                {
                    temp = R;
                    break;
                }
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            result += (Integer) temp.get(i) * Math.pow(value, i);
        }
        return result;
    }

    @Override
    public int[] add(char poly1, char poly2) {
        DoubleLinkedList temp1 = new DoubleLinkedList();
        DoubleLinkedList temp2 = new DoubleLinkedList();

        switch (Character.toUpperCase(poly1)) {
            case 'A':
                {
                    temp1 = A;
                    break;
                }
            case 'B':
                {
                    temp1 = B;
                    break;
                }
            case 'C':
                {
                    temp1 = C;
                    break;
                }
            case 'R':
                {
                    temp1 = R;
                    break;
                }
        }
        switch (Character.toUpperCase(poly2)) {
            case 'A':
                {
                    temp2 = A;
                    break;
                }
            case 'B':
                {
                    temp2 = B;
                    break;
                }
            case 'C':
                {
                    temp2 = C;
                    break;
                }
            case 'R':
                {
                    temp2 = R;
                    break;
                }
        }
        int[] result = new int[Math.max(temp1.size(), temp2.size())];
        for (int i = 0; i < temp1.size(); i++) {
            result[i] = (Integer) temp1.get(i);
        }


        for (int i = 0; i < temp2.size(); i++) {
            result[i] += (Integer) temp2.get(i);

        }
        for (int i = 0; i < result.length / 2; i++) {
            int temp = result[i];
            result[i] = result[result.length - i - 1];
            result[result.length - i - 1] = temp;
        }
        return result;
    }

    @Override
    public int[] subtract(char poly1, char poly2) {

        DoubleLinkedList temp1 = new DoubleLinkedList();
        DoubleLinkedList temp2 = new DoubleLinkedList();

        switch (Character.toUpperCase(poly1)) {
            case 'A':
            {
                temp1 = A;
                break;
            }
            case 'B':
            {
                temp1 = B;
                break;
            }
            case 'C':
            {
                temp1 = C;
                break;
            }
            case 'R':
            {
                temp1 = R;
                break;
            }
        }
        switch (Character.toUpperCase(poly2)) {
            case 'A':
            {
                temp2 = A;
                break;
            }
            case 'B':
            {
                temp2 = B;
                break;
            }
            case 'C':
            {
                temp2 = C;
                break;
            }
            case 'R':
            {
                temp2 = R;
                break;
            }
        }
        int[] result = new int[Math.max(temp1.size(), temp2.size())];
        for (int i = 0; i < temp1.size(); i++) {
            result[i] = (Integer) temp1.get(i);
        }


        for (int i = 0; i < temp2.size(); i++) {
            result[i] -= (Integer) temp2.get(i);

        }
        for (int i = 0; i < result.length / 2; i++) {
            int temp = result[i];
            result[i] = result[result.length - i - 1];
            result[result.length - i - 1] = temp;
        }
        return result;
    }

    @Override
    public int[] multiply(char poly1, char poly2) {
        DoubleLinkedList temp1 = new DoubleLinkedList();
        DoubleLinkedList temp2 = new DoubleLinkedList();

        switch (Character.toUpperCase(poly1)) {
            case 'A':
                {
                    temp1 = A;
                    break;
                }
            case 'B':
                {
                    temp1 = B;
                    break;
                }
            case 'C':
                {
                    temp1 = C;
                    break;
                }
            case 'R':
                {
                    temp1 = R;
                    break;
                }
        }
        switch (Character.toUpperCase(poly2)) {
            case 'A':
                {
                    temp2 = A;
                    break;
                }
            case 'B':
                {
                    temp2 = B;
                    break;
                }
            case 'C':
                {
                    temp2 = C;
                    break;
                }
            case 'R':
                {
                    temp2 = R;
                    break;
                }
        }
        int[] result = new int[temp1.size() + temp2.size() - 1];
        for (int i = 0; i < temp1.size(); i++) {
            for (int j = 0; j < temp2.size(); j++) {
                result[i + j] += (Integer) temp1.get(i) * (Integer) temp2.get(j);
            }
        }
        for (int i = 0; i < result.length / 2; i++) {
            int temp = result[i];
            result[i] = result[result.length - i - 1];
            result[result.length - i - 1] = temp;
        }
        return result;
    }

    public static int[] parseInput(String inputString) {
        String[] s = inputString.split(",");
        int[] arr = new int[s.length];
        if (s.length == 1 && s[0].isEmpty()) arr = new int[] {};
        else {
            for (int i = 0; i < s.length; ++i) arr[i] = Integer.parseInt(s[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner input = new Scanner(System.in);
        PolynomialSolver polynomialSolver = new PolynomialSolver();

        while (true) {
            String function;
            try {
                function = input.nextLine();
            } catch (NoSuchElementException e) {
                break;
            }
            try {
                switch (function) {
                    case "set":
                        {
                            char poly = input.nextLine().toUpperCase().charAt(0);
                            String sin = input.nextLine().replaceAll("\\[|\\]", "");
                            int[] arr = parseInput(sin);
                            polynomialSolver.setPolynomial(poly, arr);
                            break;
                        }

                    case "print":
                        {
                            char poly = input.nextLine().toUpperCase().charAt(0);
                            System.out.println(polynomialSolver.print(poly));
                            break;
                        }
                    case "add":
                        {
                            char poly1 = input.nextLine().toUpperCase().charAt(0);
                            char poly2 = input.nextLine().toUpperCase().charAt(0);
                            int[] result = polynomialSolver.add(poly1, poly2);
                            polynomialSolver.setPolynomial('R', result);
                            System.out.println(polynomialSolver.print('R'));
                            break;
                        }
                    case "sub":
                        {
                            char poly1 = input.nextLine().toUpperCase().charAt(0);
                            char poly2 = input.nextLine().toUpperCase().charAt(0);
                            int[] result = polynomialSolver.subtract(poly1, poly2);
                            polynomialSolver.setPolynomial('R', result);
                            System.out.println(polynomialSolver.print('R'));
                            break;
                        }
                    case "mult":
                        {
                            char poly1 = input.nextLine().toUpperCase().charAt(0);
                            char poly2 = input.nextLine().toUpperCase().charAt(0);
                            int[] result = polynomialSolver.multiply(poly1, poly2);
                            polynomialSolver.setPolynomial('R', result);
                            System.out.println(polynomialSolver.print('R'));
                            break;
                        }
                    case "clear":
                        {
                            char poly = input.nextLine().toUpperCase().charAt(0);
                            polynomialSolver.clearPolynomial(poly);
                            DoubleLinkedList temp = new DoubleLinkedList();
                            switch (Character.toUpperCase(poly)) {
                                case 'A':
                                    {
                                        temp = polynomialSolver.A;
                                        break;
                                    }
                                case 'B':
                                    {
                                        temp = polynomialSolver.B;
                                        break;
                                    }
                                case 'C':
                                    {
                                        temp = polynomialSolver.C;
                                        break;
                                    }
                                case 'R':
                                    {
                                        temp = polynomialSolver.R;
                                        break;
                                    }
                            }
                            System.out.println(temp.toString());
                            break;
                        }
                    case "eval":
                        {
                            char poly = input.nextLine().toUpperCase().charAt(0);
                            int value = Integer.parseInt(input.nextLine());
                            System.out.println(
                                    (int) polynomialSolver.evaluatePolynomial(poly, value));
                        }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error");
                return;
            }
        }
    }
}
