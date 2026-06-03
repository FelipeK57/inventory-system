package com.kevin.inventorysystem.product.mapper;

import com.kevin.inventorysystem.product.entity.Product;
import com.kevin.inventorysystem.product.dto.ProductRequestDto;
import com.kevin.inventorysystem.product.dto.ProductResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }

        Product product = new Product();
        product.setSku(requestDto.sku());
        product.setName(requestDto.name());
        return product;
    }

    public ProductResponseDTO toResponseDto(Product product) {
        if (product == null) {
            return null;
        }

        return new ProductResponseDTO(
                product.getId(),
                product.getSku(),
                product.getName(),
                product.getIsActive(),
                product.getCreatedAt()
        );
    }
}
