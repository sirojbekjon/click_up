package com.example;

import javafx.scene.input.KeyCode;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int enter = KeyCode.ENTER.hashCode();
        BigInteger a = scanner.nextBigInteger();
        BigInteger b = scanner.nextBigInteger();
        System.out.println(a.add(b));
//        System.out.println(enter);
        char ch = scanner.next().charAt(0);
        System.out.println(ch);
    }
}
