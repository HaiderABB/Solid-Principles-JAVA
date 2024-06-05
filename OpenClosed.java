import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;
    private int availability;

    public Product(String name, double price, int availability) {
        this.name = name;
        this.price = price;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailability() {
        return availability;
    }

}

class ShoppingCart {
    private List<Product> cartItems = new ArrayList<>();

    public void addProduct(Product product) {
        cartItems.add(product);
    }

    public void removeProduct(Product product) {
        cartItems.remove(product);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Product product : cartItems) {
            total += product.getPrice();
        }
        return total;
    }

    public void placeOrder() {
    }

}

class OrderProcessor {
    public boolean validateOrder(ShoppingCart cart) {
        return true;
    }

    public void updateProductAvailability(ShoppingCart cart) {
    }

    public String generateOrderReceipt(ShoppingCart cart) {

        return "Order Receipt\n" +
                "Total Price: " + cart.calculateTotalPrice();
    }
}

public class OpenClosed {
    public static void main(String[] args) {

        Product product1 = new Product("Computer", 5695.99, 6);
        Product product2 = new Product("iPhone", 39.99, 10);

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(product1);
        cart.addProduct(product2);

        OrderProcessor orderProcessor = new OrderProcessor();

        if (orderProcessor.validateOrder(cart)) {
            orderProcessor.updateProductAvailability(cart);
            System.out.println(orderProcessor.generateOrderReceipt(cart));
        } else {
            System.out.println("Please review your cart you have an invalid order");
        }
    }
}