package controller;

import java.util.Map;

import model.Product;
import dao.CartDao;
import enums.Status;

public class CartController {
    public ProductController productController = new ProductController();
    public CartDao cartDao = new CartDao();

    public Status addItem(String itemName, String itemType) {
        Product product = productController.isProductPresent(itemName, itemType);
        if (product == null) {
            return Status.INVALID_ITEM;
        }
        return cartDao.addProduct(product);
    }

    public Status deleteItem(String itemName, String itemType) {
        Product product = productController.isProductPresent(itemName, itemType);
        if (product == null) {
            return Status.INVALID_ITEM;
        }
        return cartDao.deleteProduct(product);
    }

    public Status updateItem(String itemName, String itemType, int quantity) {
        Product product = productController.isProductPresent(itemName, itemType);
        if (product == null) {
            return Status.INVALID_ITEM;
        }
        return cartDao.updateProduct(product, quantity);
    }

    public Map<Product, Integer> getCartItems() {
        Map<Product, Integer> cartItems = cartDao.getCartItems();
        if (cartItems.isEmpty()) {
            return null;
        }
        return cartItems;   
    }
}
