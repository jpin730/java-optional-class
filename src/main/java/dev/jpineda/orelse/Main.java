package dev.jpineda.orelse;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        Optional<String> optionalFirstName = Optional.ofNullable(firstName).filter(name -> !name.isBlank());
        if (optionalFirstName.isEmpty()) {
            firstName = optionalFirstName.orElse("John");
        }
        System.out.println("firstName = " + firstName);

        System.out.print("Enter your last name: ");
        String inputLastName = scanner.nextLine();
        Optional<String> optionalLastName = Optional.ofNullable(inputLastName).filter(name -> !name.isBlank());
        String lastName = optionalLastName.orElseGet(() -> "Doe");
        System.out.println("lastName = " + lastName);

        System.out.print("Enter your middle name: ");
        String inputMiddleName = scanner.nextLine();
        Optional<String> optionalMiddleName = Optional.ofNullable(inputMiddleName).filter(name -> !name.isBlank());
        try {
            String middleName = optionalMiddleName.orElseThrow(() -> new IllegalArgumentException("Middle name cannot be empty"));
            System.out.println("middleName = " + middleName);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
