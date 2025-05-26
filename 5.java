import java.util.Vector;

// Class representing a product
class Product {
    String name;
    double price;
    String category;

    // Constructor
    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Display product details
    @Override
    public String toString() {
        return "Name: " + name + ", Price: $" + price + ", Category: " + category;
    }
}

// Class for managing the shopping platform
class OnlineShoppingManager {
    private Vector<Product> inventory;

    // Constructor
    public OnlineShoppingManager() {
        inventory = new Vector<>();
    }

    // Add a product to the inventory
    public void addProduct(String name, double price, String category) {
        Product product = new Product(name, price, category);
        inventory.add(product);
        System.out.println("Product added: " + product);
    }

    // Remove a product from the inventory
    public void removeProduct(String name) {
        boolean found = false;
        for (Product product : inventory) {
            if (product.name.equalsIgnoreCase(name)) {
                inventory.remove(product);
                System.out.println("Product removed: " + product);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found: " + name);
        }
    }

    // Display all products in the inventory
    public void displayProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            System.out.println("Inventory:");
            for (Product product : inventory) {
                System.out.println(product);
            }
        }
    }
}

// Main class
public class OnlineShoppingPlatform {
    public static void main(String[] args) {
        OnlineShoppingManager manager = new OnlineShoppingManager();

        // Add some products
        manager.addProduct("Laptop", 800.50, "Electronics");
        manager.addProduct("Shirt", 25.99, "Clothing");
        manager.addProduct("Coffee Maker", 45.00, "Home Appliances");

        // Display products
        manager.displayProducts();

        // Remove a product
        manager.removeProduct("Shirt");

        // Display products again
        manager.displayProducts();

        // Try removing a non-existent product
        manager.removeProduct("Tablet");
    }
}
