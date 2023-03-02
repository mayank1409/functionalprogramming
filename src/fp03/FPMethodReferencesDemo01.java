package fp03;

import java.util.List;
import java.util.function.Supplier;

public class FPMethodReferencesDemo01 {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "AWS", "Docker",
                "GCP", "PCF", "Microservices", "Azure", "Kubernetes", "API");

        courses.stream()
                // .map(s -> s.toUpperCase())
                .map(String::toUpperCase)
                .forEach(System.out::println);

        Supplier<String> stringSupplier = String::new;
        stringSupplier.get();
    }

}
