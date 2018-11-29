package com.company;

import java.util.function.Function;

public final class FunGraph {
  private FunGraph() {
  }

  static String mkStringGraph(Function<Double,Double> f, int xMin, int xMax, int yMin, int yMax) {
    String result = "";
    for (int i = yMax; i >= 0; i--) {
      String row = "";
      for (int j = xMax; j > 0; j--) {
        double expectedX = f.apply((double) j);
        if (i == 0) {
          row = row + "-";
        } else {
          System.out.println("i=" + i);
          System.out.println("Expected X=" + expectedX);
          System.out.println(i-expectedX);
          if(yMax-expectedX<0.05) {
            expectedX = Math.ceil(expectedX);
            System.out.println("Ceil=" +expectedX);
          } else {
            expectedX = Math.floor(expectedX);
            System.out.println("Floor=" +expectedX);
          }
          System.out.println("i=" + i + "| expectedX=" + expectedX);
          if (i == expectedX) {
            row = row + "*";
          } else {
            row = row + " ";
          }
        }
      }
      if (i == 0) {
        row = row + "*";
      } else {
        row = row + "|";
      }
      String subRow = row.substring(0, row.length() - 1);
      String reverseRow = "";
      for (int k = subRow.length() - 1; k >= 0; k--) {
        reverseRow = reverseRow + subRow.charAt(k);
      }
      row = row + reverseRow;
      row = row + "\n";
      result = result + row;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(mkStringGraph(x -> 10*Math.cos(x/10),-50, 50, -10, 10));
  }

}