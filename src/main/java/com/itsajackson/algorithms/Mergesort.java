package com.itsajackson.algorithms;

import static com.itsajackson.util.SortUtilities.generateRandomArray;
import static com.itsajackson.util.SortUtilities.printArray;

import java.util.Arrays;

public class Mergesort {

  public static void main(String[] args) {
    printArray(sort(generateRandomArray(1000)));
    System.exit(0);
  }

  private static int[] sort(int[] arr) {

    if (arr.length == 1) {
      return arr;
    }

    int[] left = sort(Arrays.copyOfRange(arr, 0, arr.length / 2));
    int[] right = sort(Arrays.copyOfRange(arr, arr.length / 2, arr.length));

    return merge(left, right);
  }

  private static int[] merge(int[] left, int[] right) {

    int[] result = new int[left.length + right.length];

    int leftPointer = 0;
    int rightPointer = 0;
    int resultPointer = 0;

    while (leftPointer < left.length && rightPointer < right.length) {
      result[resultPointer++] =
          left[leftPointer] < right[rightPointer] ? left[leftPointer++] : right[rightPointer++];
    }
    while (leftPointer < left.length) {
      result[resultPointer++] = left[leftPointer++];
    }
    while (rightPointer < right.length) {
      result[resultPointer++] = right[rightPointer++];
    }

    return result;
  }

}
