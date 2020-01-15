import java.util.*;

class BankCustomer {
    private int accountNumber;
    private String customerName;
    private String customerAddress;
    private int customerDateOfBirth;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accNumber) {
        accountNumber = accNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String name) {
        customerName = name;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String address) {
        customerAddress = address;
    }

    public int getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(int dob) {
        customerDateOfBirth = dob;
    }

    public static String findCustomer(ArrayList<BankCustomer> array, int accNumber) {
        int i = 0;
        boolean found = false;
        while (!found) {
            if (array.get(i).accountNumber == accNumber)
                found = true;
            else
                i++;
        }
        return array.get(i).customerName;
    }

    public static void main(String[] args) {
        ArrayList<BankCustomer> bankCustomers = new ArrayList<BankCustomer>();
        bankCustomers.add(new BankCustomer());
        bankCustomers.get(0).setAccountNumber(12345);
        bankCustomers.get(0).setCustomerName("Joe Rooney");
        bankCustomers.get(0).setCustomerAddress("Apt 2, Trinity College");
        bankCustomers.get(0).setCustomerDateOfBirth(210598);

        String cus;
        cus = findCustomer(bankCustomers, 12345);
        System.out.printf("%n%s%n", cus);
    }
}
