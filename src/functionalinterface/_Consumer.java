package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        // Java normal function
        printCustomer(new Customer("Maria", "9999999"));

        // Consumer Functional Interface
        greetCustomerConsumer.accept(new Customer("Maria", "9999999"));

        // BiConsumer Functional Interface
        greetCustomerConsumerV2.accept(new Customer("Maria", "9999999"), false);
    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName + ", thank for register phone number "
                    + (showPhoneNumber ? customer.customerPhoneNumber : "**********"));

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName + ", thank for register phone number "
                    + customer.customerPhoneNumber);

    static void printCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName + ", thank for register phone number " +
                customer.customerPhoneNumber);
    }

    static class Customer{
        private final String customerName;
        private final String customerPhoneNumber;
        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

    }

}
