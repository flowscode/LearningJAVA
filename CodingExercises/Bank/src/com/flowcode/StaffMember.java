package com.flowcode;

import java.util.ArrayList;

class StaffMember {

    private String staffName;
    private int idNumber;
    private String department;
    private String staffEmail;
    private static int staffCount;
    private String password = "password";
    private ArrayList<String> accountHolders = new ArrayList<String>();

                           //--------------CONSTRUCTORS & OVERLOADED CONSTRUCTORS----------------\\

    protected StaffMember(String staffName, int idNumber, String department) {
        this.staffName = staffName;
        this.idNumber = idNumber;
        this.department = department;
        this.staffEmail = staffName.replace(" ",".")+"@flowBankStaff.co.uk";
        staffCount++;
    }

    protected StaffMember(String name) {
        this(name,000,"Unknown Department");
        this.idNumber = this.idNumber + getStaffCount();
    }


                                 //--------------GETTER AND SETTERS----------------\\

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     protected int getStaffCount() {
        return staffCount;
    }

     protected String getStaffName() {
        return staffName;
    }

     protected void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    protected int getIdNumber() {
        return idNumber;
    }

    protected void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    protected String getDepartment() {
        return department;
    }

    protected void setDepartment(String department) {
        this.department = department;
    }


    protected String getStaffEmail() {
        return staffEmail;
    }


    protected void setStaffEmail(String email) {
        this.staffEmail = email;
    }

                         //--------------STAFF LOGIC----------------\\

    protected void showAccountHolderInfo(BankAccount accountHolder){
        accountHolder.showAccountInfo();
    }
    protected void showAccountHolderInfo(VipAccount accountHolder){
        accountHolder.showAccountInfo();
    }

    protected void setCreditLimit(VipAccount accountHolder, double newAmount){
        double setWithThis = newAmount;
        accountHolder.setCreditLimit(setWithThis);
    }

    protected  void setCardNumber(BankAccount accountHolder, long newCardNumber){
        accountHolder.setCardNumber(newCardNumber);
    }

    protected void setCardPinNumber(BankAccount accountHolder, int newPin){
        if (newPin < 1000 || newPin > 9999) {
            System.out.println("{ERROR: INCORRECT NUMBER OF DIGITS}");
        } else {
        accountHolder.setCardPinNumber(newPin);
        }
    }

    protected  void setCardNumber(VipAccount accountHolder, long newCardNumber){
        accountHolder.setCardNumber(newCardNumber);
    }

    protected void setCardPinNumber(VipAccount accountHolder, int newPin){
        if (newPin < 1000 || newPin > 9999) {
            System.out.println("{ERROR: INCORRECT NUMBER OF DIGITS}");
        } else {
            accountHolder.setCardPinNumber(newPin);
        }
    }

    protected void showCardInfo(BankAccount accountHolder){
        System.out.println("NAME:        " + accountHolder.getCustomerName());
        System.out.println("CARD NUMBER: " + accountHolder.getCardNumber());
        System.out.println("PIN NUMBER:  " + accountHolder.getCardPinNumber());
    }

    protected void showCardInfo(VipAccount accountHolder){
        System.out.println("NAME:        " + accountHolder.getCustomerName());
        System.out.println("CARD NUMBER: " + accountHolder.getCardNumber());
        System.out.println("PIN NUMBER:  " + accountHolder.getCardPinNumber());
    }


}
