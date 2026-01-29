package com.bibek.main;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception{
        System.out.println("Hello World!");
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Bye World!");
    }
}
 