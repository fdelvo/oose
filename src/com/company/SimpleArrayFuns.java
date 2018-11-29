package com.company;

public class SimpleArrayFuns {
  private SimpleArrayFuns() {
  }

  static boolean contains(int[] xs, int y) {
    for (int x : xs) {
      if (x == y) return true;
    }
    return false;
  }

  static long sum(int[] xs) {
    long result = 0;
    for (int x : xs) {
      result = result + Math.abs(x);
    }
    return result;
  }

  static int avg(int[] xs) {
    return xs.length == 0 ? 0 : (int)sum(xs) / xs.length;
  }

  static boolean isSorted(int[] xs) {
    for (int i = 0; i < xs.length-1; i++) {
      if (xs[i] >= xs[i+1]) return false;
    }
    return true;
  }

  static int max(int[] xs) {
    int highestValue = 0;
    if (xs.length != 0) {
      for (int x : xs) {
        if (x >= highestValue) highestValue = x;
      }
    } else {
      highestValue = Integer.MIN_VALUE;
    }
    return highestValue;
  }

  public static void main (String[] args) {
    int[] sortedArray = {1,2,3,4,5,6,7,8};
    int[] unsortedArray = {1,2,3,5,4,6,7,8};
    int[] emptyArray = {};
    System.out.println("Array contains 1: " + contains(sortedArray, 1));
    System.out.println("Array contains 10: " + contains(sortedArray, 10));
    System.out.println("Sum of array: " + sum(sortedArray));
    System.out.println("Average of array: " + avg(sortedArray));
    System.out.println("Average of empty array: " + avg(emptyArray));
    System.out.println("Array is sorted (sortedArray): " + isSorted(sortedArray));
    System.out.println("Array is sorted (unsortedArray): " + isSorted(unsortedArray));
    System.out.println("Max of array: " + max(sortedArray));
    System.out.println("Max of empty array: " + max(emptyArray));
  }
}
