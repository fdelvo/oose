package com.company;

public class Aufgabe2a {
  static int e(int a, int b) {
    if (a == 0) return b;
    if (b == 0) return a;
    return a > b ? e(a % b, b) : e(a, b % a);
  }

  public static void main(String[] args) {
    System.out.println(e(19,51));
  }
}
