package com.company;

import java.math.BigInteger;
public final class BigIntegerFactorial {

  BigIntegerFactorial() {
  }

  static BigInteger factorial(long n){
    BigInteger result = BigInteger.ONE;
    for(long i = 2; i <= n; i ++) {
      result = result.multiply(BigInteger.valueOf(i));
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(factorial(1000000));
  }
}