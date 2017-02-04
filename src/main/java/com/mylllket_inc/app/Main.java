package com.mylllket_inc.app;

public class Main {
    public static void main(String[] args){
        Book book = new Book();
        book.add("abc");
        book.add("def");
        book.add("ffdg");
        book.modify(0, "abc2");
        book.remove(0);
        book.printData();
    }
}
