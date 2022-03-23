package com.flowcode;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        if (tonerLevel >= 0 && tonerLevel <= 100){
            this.tonerLevel = tonerLevel;
        } else {
            this.tonerLevel = -1;
        }
        this.duplex = duplex;
        this.pagesPrinted = 0;
    }

    public int addToner (int toner){
        if (toner > 0 && toner <= 100){
            if ((this.tonerLevel + toner) > 100){
                return -1;
            }
            this.tonerLevel += toner;
            return this.tonerLevel;

        } else {
            return -1;
        }
    }

    public int printPages(int pages){
        int pagesToPrint = pages;
        if(this.duplex){
            pagesToPrint = (pages / 2 ) + (pages % 2);
            System.out.println("Printing in duplex mode");
        }
        this.pagesPrinted += pagesToPrint;
        return pagesToPrint;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    /* public void printPage(){
        System.out.println("A page has been printed");
        this.tonerLevel = this.tonerLevel - 10;
        pagesPrinted++;
        System.out.println("Page #" + this.pagesPrinted);
        System.out.println("Toner Level: " + getTonerLevel() + "%");
        System.out.println("-------------------------------");
    }*/


   /* public void addToner(int toner){
        this.tonerLevel = this.tonerLevel + toner;
        System.out.println("Toner add: " + toner + "%");
        System.out.println("Toner Level: " + this.tonerLevel + "%");
        System.out.println("-------------------------------");
    } */

    public int getTonerLevel() {
        return tonerLevel;
    }

    public void showTonerLevel(){
        System.out.println("Toner Level : " + getTonerLevel() + "%");
        System.out.println("-------------------------------");
    }
}
