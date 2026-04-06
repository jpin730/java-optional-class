package dev.jpineda.collections;

import java.util.List;
import java.util.Optional;

public class Main {
    static void main() {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        System.out.println("names = " + names);
        Optional<String> first = names.stream().findFirst();
        first.ifPresent(name -> System.out.println("first: " + name));

        List<String> emptyList = List.of("");
        System.out.println("emptyList = " + emptyList);
        Optional<String> firstEmpty = emptyList.stream().findFirst();
        System.out.println("firstEmpty.isPresent() = " + firstEmpty.isPresent());

        record Product(String name, double price) {
        }
        ;

        List<Product> products = List.of(
                new Product("Laptop", 999.99),
                new Product("Smartphone", 499.99),
                new Product("Tablet", 299.99)
        );

        Optional<Product> maybeLaptop = products.stream()
                .filter(p -> p.name().equalsIgnoreCase("laptop"))
                .findFirst();
        Product foundProduct = maybeLaptop.orElse(new Product("Default Product", 0.0));
        System.out.println("foundProduct = " + foundProduct);

        List<Optional<String>> optionals = List.of(
                Optional.of("Hello"),
                Optional.empty(),
                Optional.of("Bye")
        );

        optionals
                .stream().filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);
    }
}
