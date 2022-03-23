package com.flowcode;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer(50,true);
        int pagesPrinted;

        System.out.println("initial page count = " + printer.getPagesPrinted());

        pagesPrinted = printer.printPages(2);
        System.out.println("Pages printed was " + pagesPrinted + "  new total print count for printer = " + printer.getPagesPrinted());

        pagesPrinted = printer.printPages(2);
        System.out.println("Pages printed was " + pagesPrinted + "  new total print count for printer = " + printer.getPagesPrinted());

        pagesPrinted = printer.printPages(3);
        System.out.println("Pages printed was " + pagesPrinted + "  new total print count for printer = " + printer.getPagesPrinted());

    }
}
