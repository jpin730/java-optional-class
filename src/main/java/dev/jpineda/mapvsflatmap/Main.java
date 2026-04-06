package dev.jpineda.mapvsflatmap;

import java.util.Optional;

public class Main {
    static void main() {
        // map
        Optional<String> name = Optional.of("     John      ");
        String upperCaseName = name
                .map(String::trim)
                .map(String::toUpperCase)
                .orElse("Default Name");

        System.out.println("upperCaseName = " + upperCaseName);

        // flatMap
        Optional<Optional<String>> optionalOfOptional = Optional.of(Optional.of("     Jane      "));
        String upperCaseNameFlatMap = optionalOfOptional
                .flatMap(opt -> opt)
                .orElse("Default Name");

        System.out.println("upperCaseNameFlatMap = " + upperCaseNameFlatMap);
    }
}
