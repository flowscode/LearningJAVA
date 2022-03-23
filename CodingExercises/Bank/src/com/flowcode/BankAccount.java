package com.flowcode;

public class BankAccount {

    private int accountNumber;
    private double balance;
    private String firstName;
    private String lastName;
    private String customerName;
    private String email;
    private String phoneNumber;
    private long cardNumber = 0L;
    private int cardPinNumber = 0;
    private static int bankAccountCount;


                    //--------------CONSTRUCTORS & OVERLOADED CONSTRUCTORS----------------\\

    public BankAccount(int accountNumber, double balance, String firstName, String lastName, String phoneNumber) {
        this.accountNumber = accountNumber;
            double balanceTimes100 = balance * 100;
            double rounded = Math.round(balanceTimes100);
            this.balance = rounded/100;
        this.firstName = firstName.toUpperCase();
        this.lastName = lastName.toUpperCase();
        this.customerName = getFirstName() + " "+ getLastName();
        this.email = "[NOT SET]";
        this.phoneNumber = phoneNumber;
        bankAccountCount++;
    }

    public BankAccount(String firstName, String lastName){
        this(000000,0,firstName,lastName,"NO NUMBER");
        customerName = firstName + " " + lastName;

    }

    public BankAccount(String firstName) {
        this(111111, 0,firstName,"UNKNOWN","NO NUMBER");
    }

    public BankAccount() {}

    // -------  BANKING METHODS ------------ \\

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerName(String enteredFirstName, String enteredSecondName) {
        this.customerName = enteredFirstName +" "+enteredSecondName;
    }

    public void setEmail(String email) {
        String newEmail = email.strip();
        if (newEmail.equals("")) {
            this.email = "NOT SET";
        } else {
            this.email = newEmail;
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public static int getBankAccountCount() {
//        return bankAccountCount;
//    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardPinNumber() {
        return cardPinNumber;
    }

    public void setCardPinNumber(int cardPinNumber) {
        this.cardPinNumber = cardPinNumber;
    }



    public void withdrawal(double withdrawalAmount){
        if (withdrawalAmount > getBalance() ){
            System.out.println("\n"+getCustomerName() + "\nWithdrawal Amount: " + withdrawalAmount+"\nINSUFFICIENT FUNDS\n----------------------------\n");
        } else if (withdrawalAmount < 0){
            System.out.println("ERROR\n------");
        } else {
            double amountAfterWithdrawal = this.balance - withdrawalAmount;
            setBalance(amountAfterWithdrawal);
            System.out.println("\n"+getCustomerName() +"\nWithdrawal Amount: " + withdrawalAmount+"\n----------------------------");
            System.out.println("NEW BALANCE: " + getBalance()+"\n----------------------------\n");
        }
    }
    public void deposit(double depositAmount){
        if (depositAmount > 9999999){
            System.out.println("ERROR\n------");
        } else if (depositAmount < 0){
            System.out.println("ERROR\n------");
        } else {
            setBalance(depositAmount + getBalance());
            System.out.println("\n" + getCustomerName() + "\nDeposited: " + depositAmount + "\n----------------------------");
            System.out.println("NEW BALANCE: " + getBalance());
            System.out.println("----------------------------\n");
        }
    }

    public void transfer(double transferAmount, BankAccount transferTo){
        if (transferAmount > this.balance){
            System.out.println("INSUFFICIENT FUNDS, TRANSFER FAILED!!\n----------------------------\n");
        } else if (transferAmount < 0){
            System.out.println("ERROR\n------");
        } else {
        setBalance(getBalance() - transferAmount);
        transferTo.setBalance(transferTo.getBalance() + transferAmount);
        System.out.println(getCustomerName() + " has sent £" + transferAmount + " to " + transferTo.getCustomerName()+"\n----------------------------\n");
        }
    }

    public void transfer(double transferAmount, VipAccount transferTo){
        if (transferAmount > this.balance){
            System.out.println("INSUFFICIENT FUNDS, TRANSFER FAILED!!\n----------------------------\n");
        } else if (transferAmount < 0){
            System.out.println("ERROR\n------");
        } else {
            setBalance(getBalance() - transferAmount);
            transferTo.setBalance(transferTo.getBalance() + transferAmount);
            System.out.println(getCustomerName() + " has sent £" + transferAmount + " to " + transferTo.getCustomerName()+"\n----------------------------\n");
        }
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void showAccountInfo(){
        System.out.println("Customer Name: " + getCustomerName().toUpperCase());
        System.out.println("ACCOUNT NUMBER: " + getAccountNumber());
        System.out.println("EMAIL: " + getEmail().toUpperCase());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("CARD NUMBER: " + getCardNumber());
        System.out.println("PIN: " + getCardPinNumber());
        System.out.println("BALANCE: £" + getBalance());
        //System.out.println("BANK ACCOUNTS #" + getBankAccountCount());
        System.out.println("----------------------------\n");
    }



    public void makePurchase(String item, double cost){
        if (cost > getBalance()){
            System.out.println(this.firstName + " Purchased: " + item.toUpperCase() + "\nCOST: £" + cost + "\nTRANSACTION DECLINED : INSUFFICIENT FUNDS"+ "\n----------------------------\n");
        } else if (cost < 0){
            System.out.println("ERROR\n------");
        } else {
        this.balance = this.balance - cost;
        System.out.println(this.firstName + " Purchased: " + item.toUpperCase() + "\nCOST: £" + cost + " \nTRANSACTION ACCEPTED" + "\n----------------------------\n");
        }
    }

}

