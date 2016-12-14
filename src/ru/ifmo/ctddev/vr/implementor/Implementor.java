package ru.ifmo.ctddev.vr.implementor;


public class Implementor {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Implementor classOrInterfaceFullName");
            return;
        }
        String name = args[0];

    }

}
