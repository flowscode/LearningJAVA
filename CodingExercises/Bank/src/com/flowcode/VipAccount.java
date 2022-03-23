package com.flowcode;

public class VipAccount extends BankAccount {
    private double creditLimit = 1000;
    private boolean vip = true;

                     //--------------CONSTRUCTORS & OVERLOADED CONSTRUCTORS----------------\\

    public VipAccount(int accountNumber, double balance, String firstName, String lastName, String phoneNumber) {
        super(accountNumber, balance, firstName, lastName, phoneNumber);
        this.creditLimit = creditLimit;
    }

    public VipAccount(double creditLimit, boolean vip) {
        this.creditLimit = creditLimit;
        this.vip = vip;
    }


    public VipAccount(String firstName, String lastName){
        this(121212,0,firstName,lastName,"1212121212");
    }

    public VipAccount(){}

                              // -------  BANKING METHODS ------------ \\


    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double newCreditLimit){
        this.creditLimit = newCreditLimit;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
        if (vip == false){
            setCreditLimit(0);
        }
    }

    @Override
    public void showAccountInfo(){
        System.out.println("Customer Name: " + getCustomerName().toUpperCase());
        System.out.println("VIP: " + isVip());
        System.out.println("ACCOUNT NUMBER: " + getAccountNumber());
        System.out.println("EMAIL: " + getEmail().toUpperCase());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("CARD NUMBER: " + getCardNumber());
        System.out.println("PIN: " + getCardPinNumber());
        System.out.println("BALANCE: £" + getBalance());
        System.out.println("CREDIT LIMIT: £" + getCreditLimit());
        //System.out.println("BANK ACCOUNT #" + getBankAccountCount());
        System.out.println("----------------------------");
    }


    @Override
    public void makePurchase(String item, double cost){
        if (cost > getBalance()){
            if ((getCreditLimit() + getBalance()) < cost){
                System.out.println("\n"+getCustomerName() + " Purchased: " + item.toUpperCase() + "\nCOST: £" + cost +"\nTRANSACTION DECLINED : INSUFFICIENT FUNDS"+ "\n----------------------------");
            } else if (cost > getBalance() && cost <= getCreditLimit()){
                double holder = cost - getBalance();
                setBalance(0);
                setCreditLimit(getCreditLimit()- holder);
                System.out.println("\n"+getCustomerName() + " :) Purchased: " + item.toUpperCase() + "\nCOST: £" + cost + " \n(CREDIT) TRANSACTION ACCEPTED" + "\n----------------------------");
            }else{
                double overdraft = cost - getBalance();
                setCreditLimit(getCreditLimit() - overdraft);
                double balanceCharge = getBalance() - cost;
                setBalance(balanceCharge + overdraft);
                System.out.println("\n"+getCustomerName() + " Purchased: " + item.toUpperCase() + "\nCOST: £" + cost + " \n(CREDIT) TRANSACTION ACCEPTED" + "\n----------------------------");
            }
        } else {
        setBalance(getBalance()-cost);
        System.out.println("\n"+getCustomerName() + " Purchased: " + item.toUpperCase() + "\nCOST: £" + cost + " \nTRANSACTION ACCEPTED" + "\n----------------------------");
        }
    }
}
