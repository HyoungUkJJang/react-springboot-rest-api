package com.prgrms.kdtspringwork.repository;

import com.prgrms.kdtspringwork.model.Category;
import com.prgrms.kdtspringwork.model.Product;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

    List<Product> findAll();

    Product insert(Product product);

    Product update(Product product);

    Optional<Product> findById(UUID productId);

    Optional<Product> findByName(String productName);

    List<Product> findByCategory(Category category);

    void deleteAll();

}
