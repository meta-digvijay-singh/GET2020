package controller;

import java.util.List;

import model.Product;
import dao.ProductDao;

public class ProductController {
    private ProductDao productDao = new ProductDao();

    public Product isProductPresent(String productName, String productType) {
        return productDao.isProductPresent(productName, productType);
    }
    
    public List<Product> getProducts() {
        return productDao.getAllProducts();
    }
}
