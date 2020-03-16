package view;

import java.util.List;
import java.util.Map;

import model.Product;
import controller.CartController;
import controller.ProductController;
import enums.Status;

public class DisplayOutputView {
    private static DisplayInputView input = new DisplayInputView();
    private static CartController cartController = new CartController();
    private static ProductController productController = new ProductController();
    
    public void welcomeMessage() {
        System.out.println("Welcome to Shopping Cart Application :)");
    }

    public void showInstructions() {
        System.out.println("=======================Instructions=======================");
        System.out.println("Press below keys to perform the operations...");
        System.out.println("1) Add item to the cart.");
        System.out.println("2) Delete item from the cart.");
        System.out.println("3) Show all items of the cart.");
        System.out.println("4) Edit quantity of the item.");
        System.out.println("5) Exit.");
        System.out.println("6) See Instructions again.");
        System.out.println("7) Get the list of available products.");
        System.out.println("==========================================================");
    }
    
    public void showCartItems() {
        Map<Product, Integer> cartItemsMap = cartController.getCartItems();
        if (cartItemsMap == null) {
            showStatus(Status.CART_EMPTY);
        } else {
            for (Product product : cartItemsMap.keySet()) {
                System.out.println(product + " , Quantity : " + cartItemsMap.get(product));
            }
        }
        
    }

    public void addItem() {
        String itemName = input.getItemName();
        String itemType = input.getItemType();
        Status status = cartController.addItem(itemName, itemType);
        showStatus(status);
    }

    public void deleteItem() {
        String itemName = input.getItemName();
        String itemType = input.getItemType();
        Status status = cartController.deleteItem(itemName, itemType);
        showStatus(status);
    }

    public void updateQuantity() {
        String itemName = input.getItemName();
        String itemType = input.getItemType();
        int quantity = input.getItemQuantity();
        Status status = cartController.updateItem(itemName, itemType, quantity);
        showStatus(status);
    }
    
    public void showAllProducts() {
        System.out.println("====================Available products====================");
        List<Product> productsList = productController.getProducts();
        for (Product product : productsList) {
            System.out.println(product);
        }
        System.out.println("==========================================================");
    }

    public void showStatus(Status status) {
        switch (status) {
        case OK:
            System.out.println("Operation successfully done.");
            break;

        case INVALID_ITEM:
            System.out.println("Item not present in the shop.");
            break;

        case ITEM_NOT_IN_CART:
            System.out.println("Item not present in the cart");
            break;

        case CART_EMPTY:
            System.out.println("Cart is empty.");
            break;
        }
    }
    
    public void invalidInstruction() {
        System.out.println("Invalid instruction.");
    }
}
