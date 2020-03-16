package dao;

import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDao {
    private static List<Product> productsList;
    static {
        productsList = new ArrayList<Product>();
        Product firstProduct = createProduct("1", "xiaomi", "smartphone", 8000);
        Product secondProduct = createProduct("2", "oppo", "smartphone", 25000);
        Product thirdProduct = createProduct("3", "apple", "smartphone", 80000);
        productsList.add(firstProduct);
        productsList.add(secondProduct);
        productsList.add(thirdProduct);
    }

    public static Product createProduct(String productCode, String productName,
            String productType, double productPrice) {
        Product newProduct = new Product();
        newProduct.setProductCode(productCode);
        newProduct.setProductName(productName);
        newProduct.setProductType(productType);
        newProduct.setProductPrice(productPrice);

        return newProduct;
    }

    public Product isProductPresent(String productName, String productType) {
        Product tempProduct = null;
        for (Product product : productsList) {
            if (product.getProductName().equals(productName)
                    && product.getProductType().equals(productType)) {
                tempProduct = new Product();
                tempProduct.setProductCode(product.getProductCode());
                tempProduct.setProductName(product.getProductName());
                tempProduct.setProductType(product.getProductType());
                tempProduct.setProductPrice(product.getProductPrice());
            }
        }
        return tempProduct;

    }

    public List<Product> getAllProducts() {
        return productsList;
    }
}
