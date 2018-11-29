package com.company;

public class Num {
    //n is assumed to be a positive number
    final long n;
    Num(long n){
        assert n>=0;
        this.n = n;
    }

    String toBin(long i){
        if(i > 0) return toBin(i / 2)  + Long.toString(i % 2);
        return "0";
    }

    String toBin() {
        return toBin(n);
    }

    String toOct(long i){
        if(i > 0) return toOct(i / 8) + Long.toString(i % 8);
        return "0";
    }

    String toOct() {
        return toOct(n);
    }

    String toBase(int b, long i){
        if(i > 0) return toBase(b, i / b) + getDigit(i % b);
        return "0";
    }

    String toBase(int b) {
        return toBase(b, n);
    }

    static char getDigit(long d){
        return (char) (d<10? '0'+d : 'A'+d-10);
    }

    public static void main(String[] args) {
        Num num = new Num(42);
        System.out.println(num.toBin());
        System.out.println(num.toOct());
        System.out.println(num.toBase(2));
        System.out.println(num.toBase(8));
        System.out.println(num.toBase(16));
    }
}
