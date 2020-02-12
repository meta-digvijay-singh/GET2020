package dao;

import java.util.HashMap;
import java.util.Map;

import model.Product;
import enums.Status;

public class CartDao {
    private Map<Product, Integer> cartMap = new HashMap<Product, Integer>();

    public Status addProduct(Product newProduct) {
        boolean isPresent = false;
        for (Product cartProduct : cartMap.keySet()) {
            if (cartProduct.getProductName().equals(newProduct.getProductName())
                    && cartProduct.getProductType().equals(newProduct.getProductType())) {
                int quantity = cartMap.get(cartProduct);
                cartMap.put(cartProduct, quantity + 1);
                isPresent = true;
            }
        }
        if (!isPresent) {
            cartMap.put(newProduct, 1);
        }
        return Status.OK;
    }

    public Status deleteProduct(Product product) {
        for (Product cartProduct : cartMap.keySet()) {
            if (cartProduct.getProductName().equals(product.getProductName())
                    && cartProduct.getProductType().equals(product.getProductType())) {
                cartMap.remove(cartProduct);
                return Status.OK;
            }
        }
        return Status.ITEM_NOT_IN_CART;
    }

    public Status updateProduct(Product product, int quantity) {
        if (cartMap.isEmpty()) {
            return Status.CART_EMPTY;
        } else {
            for (Product cartProduct : cartMap.keySet()) {
                if (cartProduct.getProductName().equals(product.getProductName())
                        && cartProduct.getProductType().equals(product.getProductType())) {
                    cartMap.put(cartProduct, quantity);
                    return Status.OK;
                }
            }
        }
        return Status.ITEM_NOT_IN_CART;
    }

    public Map<Product, Integer> getCartItems() {
        return cartMap;
    }
}
