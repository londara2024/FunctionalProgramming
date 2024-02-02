package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegistrationValidator
        extends Function <Customer, CustomerRegistrationValidator.ValidationResult> {

    static CustomerRegistrationValidator isEmailValid () {
        return customer -> customer.getEmail().contains("@")
             ? CustomerRegistrationValidator.ValidationResult.SUCCESS
                : CustomerRegistrationValidator.ValidationResult.EMAIL_NOT_INVALID;
    }
    static CustomerRegistrationValidator isPhoneNumberValid () {
        return customer -> customer.getPhoneNumber().startsWith("+0")
           ? CustomerRegistrationValidator.ValidationResult.SUCCESS
                : CustomerRegistrationValidator.ValidationResult.PHONE_NUMBER_INVALID_NOT;
    }

    static CustomerRegistrationValidator isAnAdult () {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16
         ? CustomerRegistrationValidator.ValidationResult.SUCCESS
                : CustomerRegistrationValidator.ValidationResult.IS_NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        EMAIL_NOT_INVALID,
        PHONE_NUMBER_INVALID_NOT,
        IS_NOT_AN_ADULT
    }
}
