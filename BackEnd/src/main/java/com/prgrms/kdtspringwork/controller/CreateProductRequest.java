package com.prgrms.kdtspringwork.controller;

import com.prgrms.kdtspringwork.model.Category;

public record CreateProductRequest(String productName, Category category, long price, String description) {
}
