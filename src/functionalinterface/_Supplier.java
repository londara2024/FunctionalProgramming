package functionalinterface;

import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBConnection());
        System.out.println(getDBConnectionSupplier.get());
        System.out.println(getDBConnectionSupplierTest.get());
    }

    static String getDBConnection () {
        return "jdbc://localhost:8080";
    }

    static Supplier<String> getDBConnectionSupplier = ()
            -> "jdbc://localhost:8080";

    static Supplier<String> getDBConnectionSupplierTest = ()
            -> {
        return "jdbc://localhost:8080";
    };
}
