package com.shopme.mapper;

import com.shopme.common.entity.product.Product;
import com.shopme.dto.ProductDTO;

public class ProductMapper {

    public static ProductDTO mapToProductBuilder(Product entity) {

        return ProductDTO.builder()
                .name(entity.getName())
                .imagePath(entity.getMainImagePath())
                .cost(entity.getCost())
                .price(entity.getPrice())
                .build();

    }
}
