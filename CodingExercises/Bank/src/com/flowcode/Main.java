package com.flowcode;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static int randomPin(){
        int pin = (int)(Math.random()*10000);
        if (pin < 1000 && pin > 99){
            pin = pin * 10;
        } else if (pin > 9999){
            pin = 1234;
        }
        return pin;
    }
    static long regRandomCardNumber(){
        long first12 = (long)(Math.random()  * 100000000000L);
        return 1717_0000_0000_0000L + first12;
    }
    static long vipRandomCardNumber(){
        long first12 = (long)(Math.random()  * 100000000000L);
        return 1212_0000_0000_0000L + first12;
    }


    public static void main(String[] args) throws InterruptedException {
	// write your code here
        FileWriter locFile = null;
        FileWriter locFile2 = null;

        Scanner scanner = new  Scanner(System.in);
        StaffMember bossJosh = new StaffMember("Joshua Dawkins",170195,"Cashier");
        ArrayList<BankAccount> bankAccountArrayList = new ArrayList<>();
        ArrayList<VipAccount> vipAccountArrayList = new ArrayList<>();

        ArrayList<String> vipNames = new ArrayList<>();
        ArrayList<String> regNames = new ArrayList<>();

        ArrayList<Integer> vipAcNumbers = new ArrayList<>();
        ArrayList<Integer> regAcNumbers = new ArrayList<>();

        ArrayList<Integer> vipPinNumbers = new ArrayList<>();
        ArrayList<Integer> regPinNumbers = new ArrayList<>();

        ArrayList<Long> vipCardNumbers = new ArrayList<>();
        ArrayList<Long> regCardNumbers = new ArrayList<>();

        int o = 0;

        for (int i = 0; i < 1; i++) {
            System.out.println("""
                                               
                                                ---- MAIN MENU ----
                                     ...PLEASE SELECT FROM THE BELOW OPTIONS...
                                   (1) CUSTOMER         (2) STAFF        (3) EXIT""");
            System.out.print("\nOPTION: ");
            int option1;
            try {
                 option1 = scanner.nextInt();

            } catch (InputMismatchException inputMismatchException){
                scanner.nextLine();
                System.out.println("""
                                        
                        ------------------------------------------------------------
                        ERROR: USE NUMBERS ONLY - [ CUSTOMER ] SELECTED BY 'DEFAULT'
                        ------------------------------------------------------------
                                        
                        """);
                option1 = 1;
            }
            System.out.println();
            if (option1 == 1){
                for (int j = 0; j < 1; j++) {
                System.out.println("""
                                                                                   
                                                                                   ---- CUSTOMER ----
                                                                         PLEASE SELECT FROM THE BELOW OPTIONS...
                                 (1) CREATE ACCOUNT        (2) ACCOUNT INFO        (3) WITHDRAW/DEPOSIT     (4) TRANSFER   (5) MAKE PURCHASE    (6) EXIT""");
                System.out.print("\nOPTION: ");
                    //System.out.println(j);
                    int option2;
                try {
                    option2 = scanner.nextInt();

                } catch (InputMismatchException inputMismatchException){
                    scanner.nextLine();
                    System.out.println("""
                            
                            -----------------------------
                               ERROR: 'USE NUMBERS ONLY'
                            
                                RETURNED TO 'MAIN MENU'
                            -----------------------------
                            """);

                    i--;
                    break;
                }
                scanner.nextLine();
                    if(option2 == 1){
                        for (int u = 0; u < 1; u++) {
                            System.out.print("""
                            
                            WHAT TYPE OF ACCOUNT WILL YOU BE OPENING TODAY?
                                          "VIP" or "REGULAR"
                            (1) VIP
                            (2) REGULAR
                            -----------------------------
                            OR (0) TO 'CANCEL'
                            -----------------------------
                            OPTION: """);
                            int vipOrReg;
                            try{
                                vipOrReg = scanner.nextInt();

                            } catch (InputMismatchException inputMismatchException){
                                scanner.nextLine();
                                System.out.println("""
                                        -----------------------------------------------
                                         OPTION OUT OF SCOPE || NO ACCOUNT WAS CREATED
                                        -----------------------------------------------""");

                                i--;
                                break;
                            }
                            if (vipOrReg == 0){
                                scanner.nextLine();
                                System.out.println("""
                                        ----------------------------------------------
                                           CANCELLED   ||    NO ACCOUNT WAS CREATED
                                        ----------------------------------------------""");
                                i--;
                                break;
                            }
                            scanner.nextLine();
                            System.out.println();
                            if(vipOrReg == 1){
                                int vipArraySize = vipAccountArrayList.size();
                                for (int k = 0; k < 1; k++) {
                                    vipAccountArrayList.add(vipArraySize,new VipAccount());
                                    //UPDATE INFO LOOP K
                                    System.out.print("ENTER FIRST NAME: ");
                                    String yourFirstName = scanner.nextLine();

                                    System.out.print("ENTER LAST NAME: ");
                                    String yourLastName = scanner.nextLine();

                                    System.out.print("CONTACT NUMBER: ");
                                    String yourContactNumber = scanner.nextLine();

                                    if (yourFirstName.trim().equals("") || yourLastName.trim().equals("")){
                                        System.out.println("-----NO NAME ENTERED------\n  NO ACCOUNT WAS CREATED\n--------------------------\n");
                                        vipAccountArrayList.remove(vipAccountArrayList.size()-1);
                                        i--;
                                        break;
                                    }
                                    System.out.println("""
                                    -------------------------------
                                    ------CHECK DETAILS BELOW------
                                    -------------------------------""");
                                    vipAccountArrayList.get(vipArraySize).setFirstName((yourFirstName.trim()).toUpperCase());
                                    vipAccountArrayList.get(vipArraySize).setLastName((yourLastName.trim()).toUpperCase());
                                    vipAccountArrayList.get(vipArraySize).setAccountNumber(200001+vipArraySize);
                                    vipAccountArrayList.get(vipArraySize).setCardNumber(vipRandomCardNumber());
                                    vipAccountArrayList.get(vipArraySize).setCardPinNumber(randomPin());
                                    vipAccountArrayList.get(vipArraySize).setPhoneNumber(yourContactNumber.trim());
                                    vipAccountArrayList.get(vipArraySize).setCustomerName((yourFirstName.trim()).toUpperCase(),(yourLastName.trim()).toUpperCase());
                                    vipAccountArrayList.get(vipArraySize).setEmail("NOT SET");

                                    for (int l = 0; l < 1; l++) {
                                        //SHOW INFO AND CONFIRM IF CORRECT LOOP l
                                        vipAccountArrayList.get(vipArraySize).showAccountInfo();
                                        System.out.print("CONFIRM CORRECT: (Y) YES    (N) NO \nOPTION: ");
                                        String conf1 = scanner.nextLine();
                                        char yesNo1;
                                        try{
                                            yesNo1 = conf1.toUpperCase().charAt(0);
                                        } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException){
                                            System.out.println("-----------------------------------------");
                                            System.out.println("OPTION NOT SELECTED : ACCOUNT NOT CREATED");
                                            System.out.println("-----------------------------------------");
                                            vipAccountArrayList.remove(vipAccountArrayList.size()-1);
                                            vipAccountArrayList.trimToSize();
                                            j--;
                                            break;
                                        }
                                        if (yesNo1 == 'Y'){
                                            System.out.println("\n-------------------");
                                            System.out.println("VIP ACCOUNT HOLDERS");
                                            for (VipAccount object: vipAccountArrayList) {
                                                System.out.println(object.getCustomerName());
                                            }
                                            System.out.println("-------------------");
                                            try {
                                                locFile = new FileWriter("vipAccounts.txt");
                                                for (VipAccount account : vipAccountArrayList) {
                                                    locFile.write("NAME: " + account.getCustomerName() + "\nACCOUNT NUMBER: " + account.getAccountNumber() + "\nCARD NUMBER: " + account.getCardNumber() + "\nPIN: " + account.getCardPinNumber() + "\n----------------------------------------------------------\n");
                                                }
                                                locFile.close();
                                            } catch (IOException ioException){
                                                System.out.println("didn't save file");
                                            }
                                            j--;
                                        } else if (yesNo1 == 'N'){
                                            System.out.println();
                                            vipAccountArrayList.remove(vipAccountArrayList.size()-1);
                                            vipAccountArrayList.trimToSize();
                                            k--;
                                        } else {
                                            System.out.println("-------------------------------");
                                            System.out.println("ERROR: OPTION IS OUT OF SCOPE!!");
                                            System.out.println("-------------------------------");
                                            l--;
                                        }
                                    }
                                }

                            } else if (vipOrReg == 2){
                                int regularArraySize = bankAccountArrayList.size();
                                for (int k = 0; k < 1; k++) {
                                bankAccountArrayList.add(regularArraySize,new BankAccount());
                                    //UPDATE INFO LOOP K
                                    System.out.print("ENTER FIRST NAME: ");
                                    String yourFirstName = scanner.nextLine();

                                    System.out.print("ENTER LAST NAME: ");
                                    String yourLastName = scanner.nextLine();

                                    System.out.print("CONTACT NUMBER: ");
                                    String yourContactNumber = scanner.nextLine();

                                    if (yourFirstName.trim().equals("") || yourLastName.trim().equals("")){
                                        System.out.println("-----NO NAME ENTERED------\n  NO ACCOUNT WAS CREATED\n--------------------------\n");
                                        bankAccountArrayList.remove(bankAccountArrayList.size()-1);
                                        i--;
                                        break;
                                    }
                                    System.out.println("""
                                    -------------------------------
                                    ------CHECK DETAILS BELOW------
                                    -------------------------------""");
                                    bankAccountArrayList.get(regularArraySize).setFirstName(yourFirstName.trim());
                                    bankAccountArrayList.get(regularArraySize).setLastName(yourLastName.trim());
                                    bankAccountArrayList.get(regularArraySize).setAccountNumber(100001+regularArraySize);
                                    bankAccountArrayList.get(regularArraySize).setCardNumber(regRandomCardNumber());
                                    bankAccountArrayList.get(regularArraySize).setCardPinNumber(randomPin());
                                    bankAccountArrayList.get(regularArraySize).setPhoneNumber(yourContactNumber.trim());
                                    bankAccountArrayList.get(regularArraySize).setCustomerName(yourFirstName,yourLastName);
                                    bankAccountArrayList.get(regularArraySize).setEmail("NOT SET");

                                    for (int l = 0; l < 1; l++) {
                                        //SHOW INFO AND CONFIRM IF CORRECT LOOP l
                                        bankAccountArrayList.get(regularArraySize).showAccountInfo();
                                        System.out.print("CONFIRM CORRECT: (Y) YES    (N) NO \nOPTION: ");
                                        String conf1 = scanner.nextLine();
                                        char yesNo1;
                                        try{
                                            yesNo1 = conf1.toUpperCase().charAt(0);
                                        } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException){
                                            System.out.println("-----------------------------------------");
                                            System.out.println("OPTION NOT SELECTED : ACCOUNT NOT CREATED");
                                            System.out.println("-----------------------------------------");
                                            bankAccountArrayList.remove(bankAccountArrayList.size()-1);
                                            j--;
                                            break;
                                        }
                                        if (yesNo1 == 'Y'){
                                            System.out.println("\n-------------------");
                                            System.out.println("REGULAR ACCOUNT HOLDERS");
                                            for (BankAccount object: bankAccountArrayList) {
                                                System.out.println(object.getCustomerName());
                                            }
                                            System.out.println("-------------------");
                                            try {
                                                locFile2 = new FileWriter("regAccounts.txt");
                                                for (BankAccount account : bankAccountArrayList) {
                                                    locFile2.write("NAME: " + account.getCustomerName() + "\nACCOUNT NUMBER: " + account.getAccountNumber() + "\nCARD NUMBER: " + account.getCardNumber() + "\nPIN: " + account.getCardPinNumber() + "\n----------------------------------------------------------\n");
                                                }
                                                locFile2.close();
                                            } catch (IOException ioException){
                                                System.out.println("didn't save file");
                                            }
                                            j--;
                                        } else if (yesNo1 == 'N'){
                                            System.out.println();
                                            bankAccountArrayList.remove(regularArraySize);
                                            bankAccountArrayList.trimToSize();
                                            regularArraySize = bankAccountArrayList.size();
                                            k--;
                                        } else {
                                            System.out.println("-------------------------------");
                                            System.out.println("ERROR: OPTION IS OUT OF SCOPE!!");
                                            System.out.println("-------------------------------");
                                            l--;
                                        }
                                    }
                                }
                            } else {
                                System.out.println("""
                                        -----------------------------
                                        ERROR: OPTION IS OUT OF SCOPE
                                        -----------------------------""");
                                u--;
                            }
                        }

                    } else if(option2 == 2){
                        for (int n = 0; n < 1; n++) {
                            int vip;

                            System.out.print("\nVIP? (1) YES       (2) NO     (B) BACK\nOPTION:   ");
                            try {
                                vip = scanner.nextInt();
                                //scanner.nextLine();
                            } catch (InputMismatchException inputMismatchException){
                                scanner.nextLine();
                                System.out.println("""
                                        -----------------------
                                                 BACK
                                        -----------------------""");
                                break;
                            }

                            System.out.println();

                            if (vip == 1){
                                for (int t = 0; t < 1; t++) {
                                    vipAcNumbers.clear();
                                    vipPinNumbers.clear();
                                    vipCardNumbers.clear();
                                    for (VipAccount object: vipAccountArrayList) {
                                        vipAcNumbers.add(object.getAccountNumber());
                                        vipPinNumbers.add(object.getCardPinNumber());
                                        vipCardNumbers.add(object.getCardNumber());
                                    }
                                    int vipUserAccountNum;
                                    int vipUserPinNum;
                                    long vipUserCardNum;
                                    int vipNumIndex;
                                    int accountNumIndex = 1;
                                    int pinNumIndex = 0;
                                    try {
                                        System.out.print("(VIP) INSERT CARD: ");
                                        vipUserCardNum = scanner.nextLong();
                                        //scanner.nextLine();
                                        System.out.print("ENTER PIN NUMBER:  ");
                                        vipUserPinNum = scanner.nextInt();
                                        //scanner.nextLine();

                                        if((vipUserCardNum < 1212_0000_0000_0000L) || (vipUserCardNum > 1212_9999_9999_9999L)){
                                            System.out.println("""
                                                    ----------------------
                                                          CHECK CARD
                                                    ----------------------""");
                                            j--;
                                            break;
                                        }

                                        if((vipUserPinNum < 1000) || (vipUserPinNum > 9999)){
                                            System.out.println("""
                                                    ----------------------
                                                       CHECK PIN NUMBER
                                                    ----------------------""");
                                            j--;
                                            break;
                                        }

                                        vipNumIndex = vipCardNumbers.indexOf(vipUserCardNum);
                                        pinNumIndex = vipPinNumbers.indexOf(vipUserPinNum);

                                        if (vipAcNumbers.size() == 0){
                                            scanner.nextLine();
                                            System.out.println("""
                                                    -----------------------
                                                    NO ACCOUNTS CREATED YET
                                                    -----------------------""");
                                            j--;
                                            break;
                                        }
                                    } catch (InputMismatchException inputMismatchException){
                                        scanner.nextLine();
                                        System.out.println("""
                                                -----------------------------------
                                                 ACCOUNT NOT FOUND | CHECK DETAILS
                                                -----------------------------------""");
                                        j--;
                                        break;
                                    }

                                    System.out.println("""
                                        ---------------------
                                            LOGGING IN...
                                        ---------------------""");
                                    Thread.sleep(3000);

                                    if(vipCardNumbers.contains(vipUserCardNum) && vipPinNumbers.contains(vipUserPinNum)){

                                        if (!(vipCardNumbers.indexOf(vipUserCardNum) == vipPinNumbers.indexOf(vipUserPinNum))) {
                                            System.out.println("""
                                                        -------------------------------------
                                                               'PIN' & 'CARD' MISMATCH
                                                        -------------------------------------""");
                                            j--;
                                            break;
                                        } else {

                                            System.out.println("""
                                                        -------------------
                                                         | LOGIN SUCCESS |
                                                        -------------------""");
                                            System.out.println("""
                                                                                     ---- ACCOUNT INFO ----
                                                                                                            
                                                        """);
                                            vipAccountArrayList.get(vipNumIndex).showAccountInfo();
                                        }
                                    } else {
                                        System.out.println("""
                                                        -------------------------------------
                                                              INCORRECT 'PIN' OR 'CARD'
                                                        -------------------------------------""");
                                        j--;
                                        break;
                                    }
                                }
                            } else if (vip == 2){
                                for (int t = 0; t < 1; t++) {
                                    regAcNumbers.clear();
                                    regPinNumbers.clear();
                                    regCardNumbers.clear();
                                    for (BankAccount object: bankAccountArrayList) {
                                        regAcNumbers.add(object.getAccountNumber());
                                        regPinNumbers.add(object.getCardPinNumber());
                                        regCardNumbers.add(object.getCardNumber());
                                    }
                                    int regUserAccountNum;
                                    int regUserPinNum;
                                    long regUserCardNum;
                                    int accountNumIndex = 1;
                                    int cardNumIndex;
                                    int pinNumIndex = 0;
                                    try {
                                        System.out.print("(REGULAR) INSERT CARD: ");
                                        regUserCardNum = scanner.nextLong();
                                        //scanner.nextLine();
                                        System.out.print("ENTER PIN NUMBER:     ");
                                        regUserPinNum = scanner.nextInt();
                                        scanner.nextLine();

                                        if((regUserCardNum < 1717_0000_0000_0000L) || (regUserCardNum > 1717_9999_9999_9999L)){
                                            System.out.println("""
                                                    ----------------------
                                                       ERROR: CHECK CARD
                                                    ----------------------""");
                                            j--;
                                            break;
                                        }

                                        if((regUserPinNum < 1000) || (regUserPinNum > 9999)){
                                            System.out.println("""
                                                    ------------------------
                                                     ERROR:CHECK PIN NUMBER
                                                    ------------------------""");
                                            j--;
                                            break;
                                        }

                                        cardNumIndex = regCardNumbers.indexOf(regUserCardNum);
                                        pinNumIndex = regPinNumbers.indexOf(regUserPinNum);

                                        if (regAcNumbers.size() == 0){
                                            scanner.nextLine();
                                            System.out.println("""
                                                    -----------------------
                                                    NO ACCOUNTS CREATED YET
                                                    -----------------------""");
                                            j--;
                                            break;
                                        }
                                    } catch (InputMismatchException inputMismatchException){
                                        scanner.nextLine();
                                        System.out.println("""
                                                -----------------------------------
                                                 ACCOUNT NOT FOUND | CHECK DETAILS
                                                -----------------------------------""");
                                        j--;
                                        break;
                                    }

                                    System.out.println("""
                                        ---------------------
                                            LOGGING IN...
                                        ---------------------""");
                                    Thread.sleep(3000);

                                    if(regCardNumbers.contains(regUserCardNum) && regPinNumbers.contains(regUserPinNum)){

                                        if (!(regCardNumbers.indexOf(regUserCardNum) == regPinNumbers.indexOf(regUserPinNum))) {
                                            System.out.println("""
                                                        -------------------------------------
                                                               'PIN' & 'CARD' MISMATCH
                                                        -------------------------------------""");
                                            j--;
                                            break;
                                        } else {

                                            System.out.println("""
                                                        -------------------
                                                         | LOGIN SUCCESS |
                                                        -------------------""");
                                            System.out.println("""
                                                                                     ---- ACCOUNT INFO ----      
                                                                                                            
                                                        """);
                                            //SHOW ACCOUNT INFO BELOW
                                            bankAccountArrayList.get(cardNumIndex).showAccountInfo();
                                        }
                                    } else {
                                        System.out.println("""
                                                        -------------------------------------
                                                              INCORRECT 'PIN' OR 'CARD'
                                                        -------------------------------------""");
                                        j--;
                                        break;
                                    }
                                }
                            } else {
                                n--;
                            }
                        }
                        j--;
                        i--;
                    } else if(option2 == 3){
                        for (int n = 0; n < 1; n++) {
                            int vip;

                            System.out.print("\nVIP? (1) YES       (2) NO     (B) BACK\nOPTION:   ");
                            try {
                                vip = scanner.nextInt();
                                scanner.nextLine();
                            } catch (InputMismatchException inputMismatchException){
                                scanner.nextLine();
                                System.out.println("""
                                        -----------------------
                                                 BACK
                                        -----------------------""");
                                break;
                            }

                            System.out.println();

                            if (vip == 1){
                                for (int t = 0; t < 1; t++) {
                                    vipAcNumbers.clear();
                                    vipPinNumbers.clear();
                                    vipCardNumbers.clear();
                                    for (VipAccount object: vipAccountArrayList) {
                                        vipAcNumbers.add(object.getAccountNumber());
                                        vipPinNumbers.add(object.getCardPinNumber());
                                        vipCardNumbers.add(object.getCardNumber());
                                    }
                                    int vipUserAccountNum;
                                    int vipUserPinNum;
                                    long vipUserCardNum;
                                    int vipNumIndex = 1;
                                    int accountNumIndex = 1;
                                    int pinNumIndex = 0;
                                    try {
                                        System.out.print("(VIP) INSERT CARD: ");
                                        vipUserCardNum = scanner.nextLong();
                                        //scanner.nextLine();
                                        System.out.print("ENTER PIN NUMBER:  ");
                                        vipUserPinNum = scanner.nextInt();
                                        scanner.nextLine();

                                        if((vipUserCardNum < 1212_0000_0000_0000L) || (vipUserCardNum > 1212_9999_9999_9999L)){
                                            System.out.println("""
                                                    ----------------------
                                                          CHECK CARD
                                                    ----------------------""");
                                            j--;
                                            break;
                                        }

                                        if((vipUserPinNum < 1000) || (vipUserPinNum > 9999)){
                                            System.out.println("""
                                                    ----------------------
                                                       CHECK PIN NUMBER
                                                    ----------------------""");
                                            j--;
                                            break;
                                        }

                                        vipNumIndex = vipCardNumbers.indexOf(vipUserCardNum);
                                        pinNumIndex = vipPinNumbers.indexOf(vipUserPinNum);

                                        if (vipAcNumbers.size() == 0){
                                            scanner.nextLine();
                                            System.out.println("""
                                                    -----------------------
                                                    NO ACCOUNTS CREATED YET
                                                    -----------------------""");
                                            j--;
                                            break;
                                        }
                                    } catch (InputMismatchException inputMismatchException){
                                        scanner.nextLine();
                                        System.out.println("""
                                                -----------------------------------
                                                 ACCOUNT NOT FOUND | CHECK DETAILS
                                                -----------------------------------""");
                                        j--;
                                        break;
                                    }

                                    System.out.println("""
                                        ---------------------
                                            LOGGING IN...
                                        ---------------------""");
                                    Thread.sleep(3000);

                                    if(vipCardNumbers.contains(vipUserCardNum) && vipPinNumbers.contains(vipUserPinNum)){

                                        if (!(vipCardNumbers.indexOf(vipUserCardNum) == vipPinNumbers.indexOf(vipUserPinNum))) {
                                            System.out.println("""
                                                        -------------------------------------
                                                               'PIN' & 'CARD' MISMATCH
                                                        -------------------------------------""");
                                            j--;
                                            break;
                                        } else {

                                            System.out.println("""
                                                        -------------------
                                                         | LOGIN SUCCESS |
                                                        -------------------""");
                                            for (int k = 0; k < 1; k++) {
                                                System.out.println("""
                                                                                     ---- WITHDRAW/DEPOSIT ----
                                                        
                                                        WHAT WOULD YOU LIKE TO DO TODAY?
                                                        (1) WITHDRAW     (2) DEPOSIT      PRESS 'ENTER' TO GO BACK
                                                                               
                                                        """);
                                                System.out.print("OPTION: ");
                                                String wOrT = scanner.nextLine();
                                                switch (wOrT){
                                                    case "1" :
                                                        System.out.println("--------------------");
                                                        System.out.println("BALANCE: £" + vipAccountArrayList.get(vipNumIndex).getBalance());
                                                        System.out.println();
                                                        System.out.print("WITHDRAWAL AMOUNT: ");
                                                        try {
                                                            double withdrawalAmount = scanner.nextDouble();
                                                            vipAccountArrayList.get(vipNumIndex).withdrawal(withdrawalAmount);
                                                            scanner.nextLine();
                                                            k--;
                                                            break;
                                                        } catch(InputMismatchException inputMismatchException){
                                                            System.out.println("""
                                                                    ---------------------
                                                                     INCOMPATIBLE OPTION
                                                                    ---------------------""");
                                                            k--;
                                                            break;
                                                        }
                                                    case "2":
                                                        System.out.println("--------------------");
                                                        System.out.println("BALANCE: £" + vipAccountArrayList.get(vipNumIndex).getBalance());
                                                        System.out.println();
                                                        System.out.print("DEPOSIT AMOUNT: ");
                                                        try {
                                                            double depositAmount = scanner.nextDouble();
                                                            vipAccountArrayList.get(vipNumIndex).deposit(depositAmount);
                                                            scanner.nextLine();
                                                            k--;
                                                            break;
                                                        } catch(InputMismatchException inputMismatchException){
                                                            System.out.println("""
                                                                    ---------------------
                                                                     INCOMPATIBLE OPTION
                                                                    ---------------------""");
                                                            k--;
                                                            break;
                                                        }
                                                    case "":
                                                        System.out.println("BACK");
                                                        break;
                                                    default:
                                                        System.out.println("""
                                                                ----------------
                                                                 INVALID OPTION
                                                                ----------------""");
                                                        k--;
                                                        break;
                                                }
                                            }


                                        }
                                    } else {
                                        System.out.println("""
                                                        -------------------------------------
                                                              INCORRECT 'PIN' OR 'CARD'
                                                        -------------------------------------""");
                                        j--;
                                        break;
                                    }
                                }
                            } else if (vip == 2){
                                for (int t = 0; t < 1; t++) {
                                    regAcNumbers.clear();
                                    regPinNumbers.clear();
                                    regCardNumbers.clear();
                                    for (BankAccount object: bankAccountArrayList) {
                                        regAcNumbers.add(object.getAccountNumber());
                                        regPinNumbers.add(object.getCardPinNumber());
                                        regCardNumbers.add(object.getCardNumber());
                                    }
                                    int regUserAccountNum;
                                    int regUserPinNum;
                                    long regUserCardNum;
                                    int accountNumIndex = 1;
                                    int cardNumIndex = 1;
                                    int pinNumIndex = 0;
                                    try {
                                        System.out.print("(REGULAR) INSERT CARD: ");
                                        regUserCardNum = scanner.nextLong();
                                        System.out.print("ENTER PIN NUMBER:     ");
                                        regUserPinNum = scanner.nextInt();
                                        scanner.nextLine();

                                        if((regUserCardNum < 1717_0000_0000_0000L) || (regUserCardNum > 1717_9999_9999_9999L)){
                                            System.out.println("""
                                                    ----------------------
                                                       ERROR: CHECK CARD
                                                    ----------------------""");
                                            j--;
                                            break;
                                        }

                                        if((regUserPinNum < 1000) || (regUserPinNum > 9999)){
                                            System.out.println("""
                                                    ------------------------
                                                     ERROR:CHECK PIN NUMBER
                                                    ------------------------""");
                                            j--;
                                            break;
                                        }

                                        cardNumIndex = regCardNumbers.indexOf(regUserCardNum);
                                        pinNumIndex = regPinNumbers.indexOf(regUserPinNum);

                                        if (regAcNumbers.size() == 0){
                                            scanner.nextLine();
                                            System.out.println("""
                                                    -----------------------
                                                    NO ACCOUNTS CREATED YET
                                                    -----------------------""");
                                            j--;
                                            break;
                                        }
                                    } catch (InputMismatchException inputMismatchException){
                                        scanner.nextLine();
                                        System.out.println("""
                                                -----------------------------------
                                                 ACCOUNT NOT FOUND | CHECK DETAILS
                                                -----------------------------------""");
                                        j--;
                                        break;
                                    }

                                    System.out.println("""
                                        ---------------------
                                            LOGGING IN...
                                        ---------------------""");
                                    Thread.sleep(3000);

                                    if(regCardNumbers.contains(regUserCardNum) && regPinNumbers.contains(regUserPinNum)){

                                        if (!(regCardNumbers.indexOf(regUserCardNum) == regPinNumbers.indexOf(regUserPinNum))) {
                                            System.out.println("""
                                                        -------------------------------------
                                                               'PIN' & 'CARD' MISMATCH
                                                        -------------------------------------""");
                                            j--;
                                            break;
                                        } else {

                                            System.out.println("""
                                                        -------------------
                                                         | LOGIN SUCCESS |
                                                        -------------------""");
                                            for (int k = 0; k < 1; k++) {
                                                System.out.println("""
                                                                                     ---- WITHDRAW/DEPOSIT ----
                                                        
                                                        WHAT WOULD YOU LIKE TO DO TODAY?
                                                        (1) WITHDRAW     (2) DEPOSIT      PRESS 'ENTER' TO GO BACK
                                                                               
                                                        """);
                                                System.out.print("OPTION: ");
                                                String wOrT = scanner.nextLine();
                                                switch (wOrT){
                                                    case "1" :
                                                        System.out.println("--------------------");
                                                        System.out.println("BALANCE: £" + bankAccountArrayList.get(cardNumIndex).getBalance());
                                                        System.out.println();
                                                        System.out.print("WITHDRAWAL AMOUNT: ");
                                                        try {
                                                            double withdrawalAmount = scanner.nextDouble();
                                                            bankAccountArrayList.get(cardNumIndex).withdrawal(withdrawalAmount);
                                                            scanner.nextLine();
                                                            k--;
                                                            break;
                                                        } catch(InputMismatchException inputMismatchException){
                                                            System.out.println("""
                                                                    ---------------------
                                                                     INCOMPATIBLE OPTION
                                                                    ---------------------""");
                                                            k--;
                                                            break;
                                                        }
                                                    case "2":
                                                        System.out.println("--------------------");
                                                        System.out.println("BALANCE: £" + bankAccountArrayList.get(cardNumIndex).getBalance());
                                                        System.out.println();
                                                        System.out.print("DEPOSIT AMOUNT: ");
                                                        try {
                                                            double depositAmount = scanner.nextDouble();
                                                            bankAccountArrayList.get(cardNumIndex).deposit(depositAmount);
                                                            scanner.nextLine();
                                                            k--;
                                                            break;
                                                        } catch(InputMismatchException inputMismatchException){
                                                            System.out.println("""
                                                                    ---------------------
                                                                     INCOMPATIBLE OPTION
                                                                    ---------------------""");
                                                            k--;
                                                            break;
                                                        }
                                                    case "":
                                                        System.out.println("BACK");
                                                        break;
                                                    default:
                                                        System.out.println("""
                                                                ----------------
                                                                 INVALID OPTION
                                                                ----------------""");
                                                        k--;
                                                        break;
                                                }
                                            }
                                        }
                                    } else {
                                        System.out.println("""
                                                        -------------------------------------
                                                              INCORRECT 'PIN' OR 'CARD'
                                                        -------------------------------------""");
                                        j--;
                                        break;
                                    }
                                }
                            } else {
                                n--;
                            }
                        }
                        j--;
                        i--;
                    } else if(option2 == 4){
                        for (int n = 0; n < 1; n++) {
                        int vip;

                        System.out.print("\nVIP? (1) YES       (2) NO     (B) BACK\nOPTION:   ");
                        try {
                            vip = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException inputMismatchException){
                            scanner.nextLine();
                            System.out.println("""
                                        -----------------------
                                                 BACK
                                        -----------------------""");
                            break;
                        }

                        System.out.println();

                        if (vip == 1){
                            for (int t = 0; t < 1; t++) {
                                vipAcNumbers.clear();
                                vipPinNumbers.clear();
                                vipCardNumbers.clear();
                                for (VipAccount object: vipAccountArrayList) {
                                    vipAcNumbers.add(object.getAccountNumber());
                                    vipPinNumbers.add(object.getCardPinNumber());
                                    vipCardNumbers.add(object.getCardNumber());
                                }
                                regAcNumbers.clear();
                                regPinNumbers.clear();
                                regCardNumbers.clear();
                                for (BankAccount object: bankAccountArrayList) {
                                    regAcNumbers.add(object.getAccountNumber());
                                    regPinNumbers.add(object.getCardPinNumber());
                                    regCardNumbers.add(object.getCardNumber());
                                }
                                int vipUserAccountNum;
                                int vipUserPinNum;
                                long vipUserCardNum;
                                int vipNumIndex = 1;
                                int accountNumIndex = 1;
                                int pinNumIndex = 0;
                                try {
                                    System.out.print("(VIP) INSERT CARD: ");
                                    vipUserCardNum = scanner.nextLong();
                                    //scanner.nextLine();
                                    System.out.print("ENTER PIN NUMBER:  ");
                                    vipUserPinNum = scanner.nextInt();
                                    //scanner.nextLine();

                                    if((vipUserCardNum < 1212_0000_0000_0000L) || (vipUserCardNum > 1212_9999_9999_9999L)){
                                        System.out.println("""
                                                    ----------------------
                                                          CHECK CARD
                                                    ----------------------""");
                                        j--;
                                        break;
                                    }

                                    if((vipUserPinNum < 1000) || (vipUserPinNum > 9999)){
                                        System.out.println("""
                                                    ----------------------
                                                       CHECK PIN NUMBER
                                                    ----------------------""");
                                        j--;
                                        break;
                                    }

                                    vipNumIndex = vipCardNumbers.indexOf(vipUserCardNum);
                                    pinNumIndex = vipPinNumbers.indexOf(vipUserPinNum);

                                    if (vipAcNumbers.size() == 0){
                                        scanner.nextLine();
                                        System.out.println("""
                                                    -----------------------
                                                    NO ACCOUNTS CREATED YET
                                                    -----------------------""");
                                        j--;
                                        break;
                                    }
                                } catch (InputMismatchException inputMismatchException){
                                    scanner.nextLine();
                                    System.out.println("""
                                                -----------------------------------
                                                 ACCOUNT NOT FOUND | CHECK DETAILS
                                                -----------------------------------""");
                                    j--;
                                    break;
                                }

                                System.out.println("""
                                        ---------------------
                                            LOGGING IN...
                                        ---------------------""");
                                Thread.sleep(3000);

                                if(vipCardNumbers.contains(vipUserCardNum) && vipPinNumbers.contains(vipUserPinNum)){

                                    if (!(vipCardNumbers.indexOf(vipUserCardNum) == vipPinNumbers.indexOf(vipUserPinNum))) {
                                        System.out.println("""
                                                        -------------------------------------
                                                               'PIN' & 'CARD' MISMATCH
                                                        -------------------------------------""");
                                        j--;
                                        break;
                                    } else {

                                        System.out.println("""
                                                        -------------------
                                                         | LOGIN SUCCESS |
                                                        -------------------""");
                                        for (int k = 0; k < 1; k++) {
                                            int accountNum;
                                            double transferAmount = 0;
                                            for (int l = 0; l < 1; l++) {

                                                System.out.println("""
                                                                                     ---- TRANSFER ----
                                                        
                                                        WHO WILL YOU BE SENDING MONEY TO?
                                                        """);
                                                System.out.print("ENTER ACCOUNT NUMBER: ");
                                                try {
                                                    accountNum = scanner.nextInt();
                                                    scanner.nextLine();
                                                }catch(InputMismatchException inputMismatchException){
                                                    System.out.println("Input Mismatch Exception : USE NUMBERS ONLY");

                                                    break;
                                                }
                                                System.out.print("TRANSFER AMOUNT: £");
                                                try {
                                                    transferAmount = scanner.nextDouble();
                                                } catch (InputMismatchException inputMismatchException) {
                                                    System.out.println("Input Mismatch Exception : USE NUMBERS ONLY");

                                                    break;
                                                }
                                                int indexOfVipAccountNum = vipAcNumbers.indexOf(accountNum);
                                                int indexOfRegAccountNum = regAcNumbers.indexOf(accountNum);
                                                if(vipAcNumbers.contains(accountNum)){
                                                    vipAccountArrayList.get(vipNumIndex).transfer(transferAmount,vipAccountArrayList.get(indexOfVipAccountNum));
                                                } else if (regAcNumbers.contains(accountNum)){
                                                    vipAccountArrayList.get(vipNumIndex).transfer(transferAmount,bankAccountArrayList.get(indexOfRegAccountNum));
                                                } else {
                                                    System.out.println("ACCOUNT NOT FOUND");
                                                    l--;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("""
                                                        -------------------------------------
                                                              INCORRECT 'PIN' OR 'CARD'
                                                        -------------------------------------""");
                                    j--;
                                    break;
                                }
                            }
                        } else if (vip == 2){
                            for (int t = 0; t < 1; t++) {
                                vipAcNumbers.clear();
                                vipPinNumbers.clear();
                                vipCardNumbers.clear();
                                for (VipAccount object: vipAccountArrayList) {
                                    vipAcNumbers.add(object.getAccountNumber());
                                    vipPinNumbers.add(object.getCardPinNumber());
                                    vipCardNumbers.add(object.getCardNumber());
                                }
                                regAcNumbers.clear();
                                regPinNumbers.clear();
                                regCardNumbers.clear();
                                for (BankAccount object: bankAccountArrayList) {
                                    regAcNumbers.add(object.getAccountNumber());
                                    regPinNumbers.add(object.getCardPinNumber());
                                    regCardNumbers.add(object.getCardNumber());
                                }
                                int regUserAccountNum;
                                int regUserPinNum;
                                long regUserCardNum;
                                int accountNumIndex = 1;
                                int cardNumIndex = 1;
                                int pinNumIndex = 0;
                                try {
                                    System.out.print("(REGULAR) INSERT CARD: ");
                                    regUserCardNum = scanner.nextLong();
                                    System.out.print("ENTER PIN NUMBER:     ");
                                    regUserPinNum = scanner.nextInt();
                                    scanner.nextLine();

                                    if((regUserCardNum < 1717_0000_0000_0000L) || (regUserCardNum > 1717_9999_9999_9999L)){
                                        System.out.println("""
                                                    ----------------------
                                                       ERROR: CHECK CARD
                                                    ----------------------""");
                                        j--;
                                        break;
                                    }

                                    if((regUserPinNum < 1000) || (regUserPinNum > 9999)){
                                        System.out.println("""
                                                    ------------------------
                                                     ERROR:CHECK PIN NUMBER
                                                    ------------------------""");
                                        j--;
                                        break;
                                    }

                                    cardNumIndex = regCardNumbers.indexOf(regUserCardNum);
                                    pinNumIndex = regPinNumbers.indexOf(regUserPinNum);

                                    if (regAcNumbers.size() == 0){
                                        scanner.nextLine();
                                        System.out.println("""
                                                    -----------------------
                                                    NO ACCOUNTS CREATED YET
                                                    -----------------------""");
                                        j--;
                                        break;
                                    }
                                } catch (InputMismatchException inputMismatchException){
                                    scanner.nextLine();
                                    System.out.println("""
                                                -----------------------------------
                                                 ACCOUNT NOT FOUND | CHECK DETAILS
                                                -----------------------------------""");
                                    j--;
                                    break;
                                }

                                System.out.println("""
                                        ---------------------
                                            LOGGING IN...
                                        ---------------------""");
                                Thread.sleep(3000);

                                if(regCardNumbers.contains(regUserCardNum) && regPinNumbers.contains(regUserPinNum)){

                                    if (!(regCardNumbers.indexOf(regUserCardNum) == regPinNumbers.indexOf(regUserPinNum))) {
                                        System.out.println("""
                                                        -------------------------------------
                                                               'PIN' & 'CARD' MISMATCH
                                                        -------------------------------------""");
                                        j--;
                                        break;
                                    } else {

                                        System.out.println("""
                                                        -------------------
                                                         | LOGIN SUCCESS |
                                                        -------------------""");
                                        for (int k = 0; k < 1; k++){
                                            int accountNum;
                                            double transferAmount = 0;
                                            for (int l = 0; l < 1; l++) {

                                                System.out.println("""
                                                                                     ---- TRANSFER ----
                                                        
                                                        WHO WILL YOU BE SENDING MONEY TO?
                                                        """);
                                                System.out.print("ENTER ACCOUNT NUMBER: ");
                                                try {
                                                    accountNum = scanner.nextInt();
                                                    scanner.nextLine();
                                                }catch(InputMismatchException inputMismatchException){
                                                    System.out.println("Input Mismatch Exception : USE NUMBERS ONLY");
                                                    break;
                                                }
                                                System.out.print("TRANSFER AMOUNT: £");
                                                try {
                                                    transferAmount = scanner.nextDouble();
                                                } catch (InputMismatchException inputMismatchException) {
                                                    System.out.println("Input Mismatch Exception : USE NUMBERS ONLY");
                                                    break;
                                                }
                                                int indexOfVipAccountNum = vipAcNumbers.indexOf(accountNum);
                                                int indexOfRegAccountNum = regAcNumbers.indexOf(accountNum);
                                                if(vipAcNumbers.contains(accountNum)){
                                                    bankAccountArrayList.get(cardNumIndex).transfer(transferAmount,vipAccountArrayList.get(indexOfVipAccountNum));
                                                } else if (regAcNumbers.contains(accountNum)){
                                                    bankAccountArrayList.get(cardNumIndex).transfer(transferAmount,bankAccountArrayList.get(indexOfRegAccountNum));
                                                } else {
                                                    System.out.println("ACCOUNT NOT FOUND");
                                                    l--;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("""
                                                        -------------------------------------
                                                              INCORRECT 'PIN' OR 'CARD'
                                                        -------------------------------------""");
                                    j--;
                                    break;
                                }
                            }
                        } else {
                            n--;
                        }
                    }
                        j--;
                        i--;
                    } else if (option2 == 5){
                        for (int k = 0; k < 1; k++) {
                        vipCardNumbers.clear();
                        regCardNumbers.clear();
                        vipPinNumbers.clear();
                        regPinNumbers.clear();
                        for (VipAccount object: vipAccountArrayList) {
                            vipCardNumbers.add(object.getCardNumber());
                            vipPinNumbers.add(object.getCardPinNumber());
                        }
                        for (BankAccount object: bankAccountArrayList) {
                            regCardNumbers.add(object.getCardNumber());
                            regPinNumbers.add(object.getCardPinNumber());
                        }
                        long userCardNumber;
                        int userPinNumber;
                            System.out.print("INSERT CARD: ");
                            try{
                                userCardNumber = scanner.nextLong();
                            } catch (InputMismatchException inputMismatchException){
                                System.out.println("""
                                        ERROR : INPUT MISMATCH""");
                                scanner.nextLine();
                                j--;
                                i--;
                                break;
                            }
                            System.out.print("PIN: ");
                            try {
                                userPinNumber = scanner.nextInt();
                                scanner.nextLine();
                            } catch (InputMismatchException inputMismatchException){
                                System.out.println("""
                                        ERROR : INPUT MISMATCH""");
                                scanner.nextLine();
                                j--;
                                i--;
                                break;
                            }

                            if (!(vipCardNumbers.contains(userCardNumber) || regCardNumbers.contains(userCardNumber))){
                                System.out.println("DETAILS NOT FOUND, PLEASE CHECK AND TRY AGAIN.");
                                j--;
                                i--;
                                break;
                            }

                            if (vipCardNumbers.contains(userCardNumber)) {
                                if (vipCardNumbers.indexOf(userCardNumber) == vipPinNumbers.indexOf(userPinNumber)) {
                                    int indexHolder = vipCardNumbers.indexOf(userCardNumber);
                                    String customerName = vipAccountArrayList.get(indexHolder).getFirstName();
                                    System.out.println("Hi " + customerName + ", what will you be purchasing today?");
                                    System.out.print("ITEM: ");
                                    String item = scanner.nextLine();
                                    //scanner.nextLine();
                                    System.out.print("PRICE: ");
                                    double price;
                                    try {
                                        price = scanner.nextDouble();
                                        scanner.nextLine();
                                    } catch (InputMismatchException inputMismatchException) {
                                        System.out.println("""
                                                ERROR : INPUT MISMATCH""");
                                        scanner.nextLine();
                                        j--;
                                        i--;
                                        break;
                                    }

                                    vipAccountArrayList.get(indexHolder).makePurchase(item, price);
                                    System.out.println("----------------------------");
                                    System.out.println("NEW BALANCE: " + vipAccountArrayList.get(indexHolder).getBalance());

                                }
                            }
                            if (regCardNumbers.contains(userCardNumber)){
                                    if (regCardNumbers.indexOf(userCardNumber) == regPinNumbers.indexOf(userPinNumber)){
                                        int indexHolder = regCardNumbers.indexOf(userCardNumber);
                                        String customerName = bankAccountArrayList.get(indexHolder).getFirstName();
                                        System.out.println("Hi "+ customerName + ", what will you be purchasing today?");
                                        System.out.print("ITEM: ");
                                        String item = scanner.nextLine();
                                        //scanner.nextLine();
                                        System.out.print("PRICE: ");
                                        double price;
                                        try{
                                            price = scanner.nextDouble();
                                            scanner.nextLine();
                                        } catch (InputMismatchException inputMismatchException){
                                            System.out.println("""
                                        ERROR : INPUT MISMATCH""");
                                            scanner.nextLine();
                                            j--;
                                            i--;
                                            break;
                                        }
                                        bankAccountArrayList.get(indexHolder).makePurchase(item, price);
                                        System.out.println("----------------------------");
                                        System.out.println("NEW BALANCE: " + bankAccountArrayList.get(indexHolder).getBalance());
                                    }
                                } else {
                                System.out.println("CHECK DETAILS");
                            }
                        }
                        j--;
                        i--;
                    } else if (option2 == 6){
                        j+=11;
                        i--;
                    } else {
                        System.out.println("""
                                        -----------------------------
                                        ERROR: OPTION IS OUT OF SCOPE
                                        -----------------------------""");
                        j--;
                        i--;
                    }

                }
            } else if(option1 == 2){
                for (int r = 0; r < 1; r++) {
                    System.out.print("ENTER PASSWORD: ");
                    scanner.nextLine();
                    String password1 = scanner.nextLine();
                    if(!(password1.equals(bossJosh.getPassword()))){
                        System.out.println("""
                                
                                ----------------------
                                  PASSWORD INCORRECT
                                ----------------------
                                
                                """);
                        i--;
                        break;
                    }
                    password1 = "not set";
                    System.out.println("""
                                                                ---- STAFF ----
                                                      PLEASE SELECT FROM THE BELOW OPTIONS...
                                      (1) SETUP ACCOUNT INFO        (2) SHOW ACCOUNT INFO        (3) EXIT""");
                    System.out.print("\nOPTION: ");
                    int option2;
                    try {
                        option2 = scanner.nextInt();
                        scanner.nextLine();
                    } catch(InputMismatchException inputMismatchException){
                        System.out.println("""
                                ----------------------------
                                ERROR: OPTION NOT COMPATIBLE
                                ----------------------------
                                
                                """);
                        i--;
                        scanner.nextLine();
                        break;
                    }
                        if (option2 == 1) {
                            for (int n = 0; n < 1; n++) {
                                System.out.print("\nVIP? (Y) YES       (N) NO\nOPTION:   ");
                                String vip = scanner.nextLine();
                                String vipUpperCase = vip.toUpperCase();
                                char vipChar = 0;
                                try {
                                    vipChar = vipUpperCase.charAt(0);
                                    System.out.println();
                                } catch(StringIndexOutOfBoundsException stringIndexOutOfBoundsException){
                                    i--;
                                }
                                if (vipChar == 'Y'){
                                    for (int t = 0; t < 1; t++) {
                                        //VIP
                                        for (VipAccount object: vipAccountArrayList) {
                                            vipNames.add(o, object.getCustomerName().toUpperCase());
                                            vipAcNumbers.add(o,object.getAccountNumber());
                                            o++;
                                        }
                                        System.out.print("ENTER ACCOUNT NUMBER: ");
                                        int acNumberEntered;
                                        try {
                                             acNumberEntered = scanner.nextInt();
                                        } catch (InputMismatchException inputMismatchException){
                                            scanner.nextLine();
                                            System.out.println("""
                                            ------------------------------------
                                            ERROR: USE [COMPATIBLE] NUMBERS ONLY
                                            ------------------------------------""");
                                            break;
                                        }
                                        try {
                                            int indexOfAcNumber = vipAcNumbers.indexOf(acNumberEntered);
                                            System.out.println("\nVIP: #"+(indexOfAcNumber+1));
                                            vipAccountArrayList.get(indexOfAcNumber).showAccountInfo();

                                            System.out.print("SET FIRST NAME:     ");
                                            scanner.nextLine();
                                            String newFirstName = scanner.nextLine();
                                            if (newFirstName.strip().equals("")){
                                                newFirstName = vipAccountArrayList.get(indexOfAcNumber).getFirstName();
                                            }
                                            System.out.print("SET LAST NAME:      ");
                                            String newLastName = scanner.nextLine();
                                            if (newLastName.strip().equals("")){
                                                newLastName = vipAccountArrayList.get(indexOfAcNumber).getLastName();
                                            }
                                            System.out.print("SET EMAIL ADDRESS:  ");

                                            String newEmail = scanner.nextLine();
                                            if (newEmail.strip().equals("")){
                                                newEmail = "NOT SET";
                                            }
                                            System.out.print("SET PHONE NUMBER:   ");
                                            String newPhoneNumber = scanner.nextLine();
                                            if (newPhoneNumber.strip().equals("")){
                                                newPhoneNumber = vipAccountArrayList.get(indexOfAcNumber).getPhoneNumber();
                                            }
                                            System.out.print("SET PIN NUMBER:     ");
                                            int newPinNumber;
                                            try {
                                                newPinNumber = scanner.nextInt();

                                            } catch (InputMismatchException inputMismatchException){

                                                newPinNumber = randomPin();
                                            }
                                            if (newPinNumber == (vipAccountArrayList.get(indexOfAcNumber).getCardPinNumber()) || newPinNumber < 1000 || newPinNumber > 9999 ){
                                                newPinNumber = randomPin();
                                                scanner.nextLine();
                                            } else {
                                                scanner.nextLine();
                                            }
                                            vipAccountArrayList.get(indexOfAcNumber).setFirstName(newFirstName);
                                            vipAccountArrayList.get(indexOfAcNumber).setLastName(newLastName);
                                            vipAccountArrayList.get(indexOfAcNumber).setEmail(newEmail);
                                            vipAccountArrayList.get(indexOfAcNumber).setCustomerName(newFirstName,newLastName);
                                            vipAccountArrayList.get(indexOfAcNumber).setPhoneNumber(newPhoneNumber);
                                            vipAccountArrayList.get(indexOfAcNumber).setCardPinNumber(newPinNumber);
                                            System.out.println("""
                                                    ------------------------------
                                                     SETUP COMPLETED SUCCESSFULLY
                                                    ------------------------------""");
                                            vipAccountArrayList.get(indexOfAcNumber).showAccountInfo();
                                            o=0;

                                        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                                            System.out.println("ACCOUNT NOT FOUND!!");
                                            o = 0;
                                            break;
                                        }

                                    }
                                } else if (vipChar == 'N'){
                                    for (int t = 0; t < 1; t++) {
                                        //NOT VIP
                                        for (BankAccount object: bankAccountArrayList) {
                                            regNames.add(o, object.getCustomerName().toUpperCase());
                                            regAcNumbers.add(o,object.getAccountNumber());
                                            o++;
                                        }
                                        System.out.print("ENTER ACCOUNT NUMBER: ");
                                        int acNumberEntered;
                                            try {
                                                acNumberEntered = scanner.nextInt();
                                            } catch (InputMismatchException inputMismatchException){
                                                System.out.println("USE NUMBERS ONLY");
                                                scanner.nextLine();

                                                break;
                                            }
                                            try {
                                                int indexOfAcNumber = regAcNumbers.indexOf(acNumberEntered);
                                                System.out.println("\nREGULAR ACCOUNT: #"+(indexOfAcNumber+1));
                                                bankAccountArrayList.get(indexOfAcNumber).showAccountInfo();

                                                System.out.print("SET FIRST NAME:     ");
                                                scanner.nextLine();
                                                String newFirstName = scanner.nextLine();
                                                if (newFirstName.strip().equals("")){
                                                    newFirstName = bankAccountArrayList.get(indexOfAcNumber).getFirstName();
                                                }
                                                System.out.print("SET LAST NAME:      ");
                                                String newLastName = scanner.nextLine();
                                                if (newLastName.strip().equals("")){
                                                    newLastName = bankAccountArrayList.get(indexOfAcNumber).getLastName();
                                                }

                                                System.out.print("SET EMAIL ADDRESS:  ");
                                                String newEmail = scanner.nextLine();
                                                if (newEmail.strip().equals("")){
                                                    newEmail = "NOT SET";
                                                }

                                                System.out.print("SET PHONE NUMBER:   ");
                                                String newPhoneNumber = scanner.nextLine();
                                                if (newPhoneNumber.strip().equals("")){
                                                    newPhoneNumber = bankAccountArrayList.get(indexOfAcNumber).getPhoneNumber();
                                                }

                                                System.out.print("SET PIN NUMBER:     ");
                                                int newPinNumber;
                                                try {
                                                    newPinNumber = scanner.nextInt();
                                                    scanner.nextLine();
                                                } catch (InputMismatchException inputMismatchException){
                                                    newPinNumber = randomPin();
                                                    scanner.nextLine();
                                                }
                                                if (newPinNumber == (bankAccountArrayList.get(indexOfAcNumber).getCardPinNumber()) || newPinNumber < 1000 || newPinNumber > 9999 ){
                                                    newPinNumber = randomPin();
                                                }
                                                bankAccountArrayList.get(indexOfAcNumber).setFirstName(newFirstName);
                                                bankAccountArrayList.get(indexOfAcNumber).setLastName(newLastName);
                                                bankAccountArrayList.get(indexOfAcNumber).setEmail(newEmail);
                                                bankAccountArrayList.get(indexOfAcNumber).setCustomerName(newFirstName,newLastName);
                                                bankAccountArrayList.get(indexOfAcNumber).setPhoneNumber(newPhoneNumber);
                                                bankAccountArrayList.get(indexOfAcNumber).setCardPinNumber(newPinNumber);
                                                System.out.println("""
                                                    ------------------------------
                                                     SETUP COMPLETED SUCCESSFULLY
                                                    ------------------------------""");
                                                bankAccountArrayList.get(indexOfAcNumber).showAccountInfo();
                                                o=0;

                                            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                                                System.out.println("ACCOUNT NOT FOUND!!");
                                                o = 0;
                                                break;
                                            }
                                        }
                                } else {
                                    System.out.println("""
                                                --------------------------------
                                                ERROR : OPTION IS NOT COMPATIBLE
                                                --------------------------------""");
                                    n--;
                                }
                            }
                            //r--;
                            i--;
                        } else if (option2 == 2) {
                            System.out.println();
                            int vipAccountCounter = vipAccountArrayList.size();
                            int regAccountCounter = bankAccountArrayList.size();

                            for (VipAccount object: vipAccountArrayList) {
                                object.showAccountInfo();
                            }
                            for (BankAccount object: bankAccountArrayList) {
                                object.showAccountInfo();
                            }

                            regAccountCounter += bankAccountArrayList.size();

                            if (regAccountCounter + vipAccountCounter < 1){
                                System.out.println("""
                                         ,......................
                                        /_____________________/|
                                        | ZERO ACCOUNTS FOUND ||
                                        |_____________________|/""");
                                i--;
                                break;
                            } else{
                                System.out.println("\nNUMBER OF ACCOUNTS OPENED: #" + (vipAccountArrayList.size() + bankAccountArrayList.size()+"\n"));
                                System.out.println("REGULAR ACCOUNTS OPEN: #" + bankAccountArrayList.size());
                                System.out.println("VIP ACCOUNTS OPEN: #" + vipAccountArrayList.size());
                                System.out.println("-------------------------------\n");
                                i--;
                            }
                            i--;
                        } else if (option2 >= 3) {
                            i--;
                        } else {
                            r--;
                        }
                    }
            }else if (option1 == 3){
                System.out.println("""
                        --------------------------------------------------
                        SYSTEM SHUTDOWN - ALL INFORMATION HAS BEEN CLEARED
                        --------------------------------------------------""");
                break;
            } else {
                System.out.println("""
                        -------------------------------
                        ERROR: OPTION IS OUT OF SCOPE!!
                        -------------------------------""");
                i--;
            }
        }

    }
}