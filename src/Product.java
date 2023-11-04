import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.min;

public class Product {
    private int id;

    private String type;
    private double price;
    private boolean discount;
    private LocalDate addDate;

    public void setPrice(double price) {
        this.price = price;
    }

    public static List<Product> getExpensiveBooks
            (List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals("Book") && product.getPrice() > 250)
                .collect(Collectors.toList());
    }

    public static List<Product> getDiscountedBooks(List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals("Book") && product.isDiscount())
                .map(product -> {
                    product.setPrice(product.getPrice() * 0.9);
                    return product;
                })
                .collect(Collectors.toList());
    }

    public static Product getFindCheapestBook(List<Product> products) {
        return products.stream()
                .filter(product ->
                        product.getType().equals("Book"))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() ->
                        new RuntimeException("Product [category : Book ]  not found"));
    }

    public static List<Product> getLatestProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getaddDate).reversed()).limit(3).collect(Collectors.toList());
    }

    public static double calculateTotalCost(List<Product> products) {
        int currentYear = LocalDate.now().getYear();
        return products.stream()
                .filter(product -> product.getaddDate().getYear() == currentYear && product.getType().equals("Book")
                        && product.getPrice() <= 300)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static Map<String, List<Product>> groupProductsByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }

    public Product(int id, String type, double price, boolean discount, LocalDate addDate) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.addDate = addDate;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public LocalDate getaddDate() {
        return addDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", addDate=" + addDate +
                '}';
    }

}