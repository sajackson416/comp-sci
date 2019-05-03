package com.itsajackson.util;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;

public class SortUtilities {

  private static final Logger logger = Logger.getLogger("SortUtilities");
  private static Random random = new Random();

  private SortUtilities() {
    //Private constructor to hide public
  }

  public static void swap(int[] arr, int first, int second) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }

  public static void printArray(int[] arr) {
    StringBuilder sb = new StringBuilder(arr.length);
    Arrays.stream(arr).forEach(value -> sb.append(value).append(" "));
    logger.info(sb.toString());
  }

  public static int[] generateRandomArray(int size) {
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = random.nextInt(1000);
    }
    return arr;
  }

  public static int[] stringToIntArr(String[] strArr) {
    return Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
  }

}
