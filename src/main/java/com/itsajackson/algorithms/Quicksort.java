package src.main.java.com.itsajackson.algorithms;

import static src.main.java.com.itsajackson.util.SortUtilities.printArray;
import static src.main.java.com.itsajackson.util.SortUtilities.swap;

import java.util.Arrays;

public class Quicksort {

  public static void main(String[] args) {

    int[] arr = Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
    sort(arr, 0, arr.length);
    printArray(arr);
    System.exit(0);
  }

  private static void sort(int[] arr, int begin, int end) {

    if (end - begin < 2) {
      return;
    }
    choosePivot(arr, begin, end);
    int pivot = end - 1;

    int fromLeft = begin;
    int fromRight = end - 2;
    while (fromLeft <= fromRight) {
      while (arr[fromLeft] <= arr[pivot] && fromLeft <= fromRight) {
        fromLeft++;
      }
      while (arr[fromRight] > arr[pivot] && fromLeft <= fromRight) {
        fromRight--;
      }
      if (fromLeft < fromRight) {
        swap(arr, fromLeft, fromRight);
        fromLeft++;
        fromRight--;
      }
    }
    swap(arr, fromLeft, pivot);
    printArray(arr);
    sort(arr, begin, fromLeft);
    sort(arr, fromLeft + 1, end);
  }

  private static void choosePivot(int[] arr, int begin, int end) {
    if (end - begin < 2) {
      return;
    }
    int middle = (begin + end) / 2;

    if (arr[begin] > arr[middle]) {
      swap(arr, begin, middle);
    }
    if (arr[middle] > arr[end - 1]) {
      swap(arr, middle, end - 1);
    }
    if (arr[begin] > arr[middle]) {
      swap(arr, begin, middle);
    }
    swap(arr, middle, end - 1);
  }
}
