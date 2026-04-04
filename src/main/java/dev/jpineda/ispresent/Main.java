package dev.jpineda.ispresent;

import java.util.Optional;

public class Main {
    static void main() {
        Optional<String> optionalString = Optional.of("Hello World!");

        if (optionalString.isPresent()) {
            System.out.println("The value is present: " + optionalString.get());
        }

        String nullableValue = null;
        Optional<String> nullableOptional = Optional.ofNullable(nullableValue);

        if (nullableOptional.isPresent()) {
            System.out.println("This will not be printed.");
        } else {
            System.out.println("The value is not present.");
        }

        Optional<String> greeting = Optional.of("Hello, Java!");
        greeting.ifPresent(value -> System.out.println("The value is: " + value));
    }
}
