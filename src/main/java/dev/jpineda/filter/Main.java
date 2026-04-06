package dev.jpineda.filter;

import java.util.Optional;

public class Main {
    static void main() {
        // filter
        Optional<String> id = Optional.of("123456789");
        Optional<String> result = id.filter(value -> value.startsWith("1"));
        System.out.println("result = " + result.orElse("ID does not start with 1"));

        Optional<String> email = Optional.ofNullable("  test@email.com ");
        email.map(String::trim)
                .filter(value -> value.contains("@"))
                .ifPresentOrElse(
                        value -> System.out.println("Valid email: " + value),
                        () -> System.out.println("Invalid email")
                );
    }
}
