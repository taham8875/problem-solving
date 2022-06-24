package com.company;

import static com.company.MergeSort.*;

public class Main {

    public static void main(String[] args) {
        int[] elements = {12, 11, 13, 5, 6, 7, 9, 7, 8, 5, 4, 1, 11, 18, 17, 246, 354, 36, 39};

        System.out.println("Given Array : ");
        printArray(elements);

        MergeSort ob = new MergeSort();
        ob.sort(elements, 0, elements.length - 1);

        System.out.println("\nSorted array : ");
        printArray(elements);
    }
}

/* Java program for Merge Sort */
class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int[] arr, int start, int mid, int end) {
        // Find sizes of two subarrays to be merged
        int sizeOfLeftArray = mid - start + 1;
        int sizeOfRightArray = end - mid;

        // Create temp arrays
        int[] leftArray = new int[sizeOfLeftArray];
        int[] rightArray = new int[sizeOfRightArray];

        // Copy data to temp arrays
        for (int i = 0; i < sizeOfLeftArray; ++i)
            leftArray[i] = arr[start + i];
        for (int j = 0; j < sizeOfRightArray; ++j)
            rightArray[j] = arr[mid + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = start;
        while (i < sizeOfLeftArray && j < sizeOfRightArray) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
                k++;
            } else {
                arr[k] = rightArray[j];
                j++;
                k++;
            }

        }

        /* Copy remaining elements of leftArray[] if any */
        while (i < sizeOfLeftArray) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        /* Copy remaining elements of rightArray[] if any */
        while (j < sizeOfRightArray) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int[] arr, int start, int end) {
        if (start < end) {
            // Find the middle point
            int mid = (start + end) / 2;

            // Sort first and second halves
            sort(arr, start, mid);
            sort(arr, mid + 1, end);

            // Merge the sorted halves
            merge(arr, start, mid, end);
        }
    }


    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}

