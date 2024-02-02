package combinatorpattern;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        Customer customer = new Customer(
//                "Sok",
//                "sok@gmail.com",
//                "+0123456789",
//                LocalDate.of(1990, 1, 1)
//        );

        Customer customer = new Customer(
                "Sok",
                "sok@gmail.com",
                "+0123456789",
                LocalDate.of(1990, 1, 1)
        );



//        CustomerValidatorService service = new CustomerValidatorService();
//        System.out.println(service.isValid(customer));

        //If valid we can store customer in db

        // Using combinator pattern
        CustomerRegistrationValidator.ValidationResult applyValidator = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAnAdult())
                .apply(customer);
        System.out.println(applyValidator);
        if (applyValidator != CustomerRegistrationValidator.ValidationResult.SUCCESS) {
            throw new IllegalStateException(applyValidator.name());
        }
    }
}
