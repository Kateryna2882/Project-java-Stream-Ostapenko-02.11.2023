import java.time.LocalDate;

import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product(1, "Book", 300, true, LocalDate.of(2023, 1, 1)),
                new Product(2, "Book", 150, false, LocalDate.of(2023, 2, 10)),
                new Product(3, "DVD", 200, false, LocalDate.of(2023, 3, 20)),
                new Product(4, "Book", 270, true, LocalDate.of(2023, 4, 30)),
                new Product(5, "Toy", 180, false, LocalDate.of(2023, 5, 1)));

        List<Product> expensiveBooks = Product.getExpensiveBooks(products);
        System.out.println("Books of great value : " + expensiveBooks);
        System.out.println("************************************************************************************************");

        List<Product> discountedBooks = Product.getDiscountedBooks(products);
        System.out.println("Books at a discounted price - 10% :  " + discountedBooks);
        System.out.println("************************************************************************************************");

        Product cheapestBook = Product.getFindCheapestBook(products);
        System.out.println("Cheapest book : " + cheapestBook);
        System.out.println("*************************************************************************************************");

        List<Product> latestProducts = Product.getLatestProducts(products);
        System.out.println("Latest products : " + latestProducts);
        System.out.println("***************************************************************************************************");

        double totalCost = Product.calculateTotalCost(products);
        System.out.println(" Total cost : " + totalCost);
        System.out.println("****************************************************************************************************");

        Map<String, List<Product>> groupedProducts = Product.groupProductsByType(products);
        System.out.println("Group products by type : " + groupedProducts);

    }
}