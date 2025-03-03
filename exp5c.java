import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}

public class exp5c {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200),
            new Product("Phone", "Electronics", 800),
            new Product("TV", "Electronics", 1500),
            new Product("Sofa", "Furniture", 700),
            new Product("Table", "Furniture", 400),
            new Product("Chair", "Furniture", 150)
        );

        // Grouping products by category
        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));

        // Finding the most expensive product in each category
        Map<String, Optional<Product>> maxPricedProducts = products.stream()
                .collect(Collectors.groupingBy(p -> p.category, 
                        Collectors.maxBy(Comparator.comparingDouble(p -> p.price))));

        // Calculating the average price of all products
        double avgPrice = products.stream()
                .mapToDouble(p -> p.price)
                .average()
                .orElse(0.0);

        // Display results
        System.out.println("Products grouped by category:");
        groupedByCategory.forEach((category, productList) -> 
            System.out.println(category + ": " + productList));

        System.out.println("\nMost expensive product in each category:");
        maxPricedProducts.forEach((category, product) -> 
            System.out.println(category + ": " + product.orElse(null)));

        System.out.println("\nAverage price of all products: $" + avgPrice);
    }
}
