package com.flowcode;

public class Main {

    public static void main(String[] args) {
	    ITelephone timsPhone = new DeskPhone(12345678);

        timsPhone.powerOn();
        timsPhone.callPhone(12345678);
        timsPhone.answer();
        System.out.println("---------------------------");

        timsPhone = new MobilePhone(12345);

        //timsPhone.powerOn();
        timsPhone.callPhone(12345);
        timsPhone.answer();
        System.out.println("---------------------------");

    }
}
