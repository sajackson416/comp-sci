package com.itsajackson.algorithms;

import static com.itsajackson.util.SortUtilities.generateRandomArray;
import static com.itsajackson.util.SortUtilities.printArray;

public class InplaceMergesort {

  public static void main(String[] args) {

    int[] arr = generateRandomArray(1000);
    sort(arr, 0, arr.length);
    printArray(arr);
    System.exit(0);
  }

  private static void sort(int[] arr, int begin, int end) {

    if (end - begin == 1) {
      return;
    }

    sort(arr, begin, (begin + end) / 2);
    sort(arr, (begin + end) / 2, end);

    merge(arr, begin, (begin + end) / 2, end);
  }

  private static void merge(int[] arr, final int left, final int right, final int end) {

    int[] result = new int[end - left];

    int leftPointer = left;
    int rightPointer = right;
    int resultPointer = 0;

    while (leftPointer < right && rightPointer < end) {
      result[resultPointer++] =
          arr[leftPointer] < arr[rightPointer] ? arr[leftPointer++] : arr[rightPointer++];
    }
    while (leftPointer < right) {
      result[resultPointer++] = arr[leftPointer++];
    }
    while (rightPointer < end) {
      result[resultPointer++] = arr[rightPointer++];
    }

    resultPointer = 0;
    int arrPointer = left;
    while (resultPointer < result.length) {
      arr[arrPointer++] = result[resultPointer++];
    }
  }

}
