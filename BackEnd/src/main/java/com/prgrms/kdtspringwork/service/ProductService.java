package com.prgrms.kdtspringwork.service;

import com.prgrms.kdtspringwork.model.Category;
import com.prgrms.kdtspringwork.model.Product;
import java.util.List;

public interface ProductService {

    List<Product> getProductsByCategory(Category category);

    List<Product> getAllProducts();

    Product createProduct(String productName, Category category, long price);

    Product createProduct(String productName, Category category, long price, String description);

}
