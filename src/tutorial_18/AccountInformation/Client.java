package tutorial_18.AccountInformation;

// Exercise 18.13: Client.java
// Represents account information and contains get and set methods.

public class Client {
    private String firstName;
    private String lastName;
    private int accountNumber;
    private double balanceAmount;

    public Client(String firstName, String lastName, int accountNumber, double balanceAmount) {
        setFirstName(firstName);
        setLastName(lastName);
        setAccountNumber(accountNumber);
        setBalanceAmount(balanceAmount);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

} // end class Client
