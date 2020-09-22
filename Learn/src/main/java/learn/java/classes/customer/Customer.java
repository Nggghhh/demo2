package learn.java.classes.customer;

import learn.java.classes.Person;

import java.util.Objects;

class Customer extends Person {
    private String address;
    private long creditCardNumber;
    private long bankAccountNumber;

    public Customer() {

    }

    public Customer(int id, String name, String lastName, String patronym, String address, long creditCardNumber, long bankAccountNumber) {
        super(id, name, lastName, patronym);
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return creditCardNumber == customer.creditCardNumber &&
                bankAccountNumber == customer.bankAccountNumber &&
                Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address, creditCardNumber, bankAccountNumber);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "address='" + address + '\'' +
                ", creditCardNumber=" + creditCardNumber +
                ", bankAccountNumber=" + bankAccountNumber +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronym='" + patronym + '\'' +
                '}';
    }

    @Override
    public void printPersonalData() {
        super.printPersonalData();
        System.out.println("Address: " + getAddress() +
                "\n" + "Credit card number: " + getCreditCardNumber() +
                "\n" + "Bank account number: " + getBankAccountNumber() +
                "\n");
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public long getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(long bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }
}
