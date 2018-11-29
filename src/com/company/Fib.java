package com.company;

public class Fib {
    long firstFib;
    long secondFib;

    Fib() {
        firstFib = 0;
        secondFib = 1;
    }

    static int fib(int n) {
        if(n <= 1) return n;
        else return fib(n-2) + fib(n-1);
    }

    static long fibNonRecursive(int n) {
        double firstTerm = Math.pow(((1+Math.sqrt(5))/2.0), (double)n);
        double secondTerm = Math.pow(((1-Math.sqrt(5))/2.0), (double)n);
        return (long)((firstTerm - secondTerm) / Math.sqrt(5));
    }

    long nextFib() {
        if(firstFib==0) {
            long nextFib = firstFib + secondFib;
            firstFib = secondFib;
            secondFib = nextFib;
            return 0;
        } else if (firstFib==1) {
            long nextFib = firstFib + secondFib;
            firstFib = secondFib;
            secondFib = nextFib;
            return 1;
        } else {
            long nextFib = firstFib;
            firstFib = secondFib;
            secondFib = nextFib + secondFib;
            return nextFib;
        }

    }

    public static void main(String[] args) {
        Fib f = new Fib();
        for (int i = 0; i <= 10; i++) {
            System.out.println(f.nextFib());
        }
    }
}

