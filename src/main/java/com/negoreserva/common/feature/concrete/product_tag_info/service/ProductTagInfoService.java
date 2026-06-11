package com.negoreserva.common.feature.concrete.product_tag_info.service;

import com.negoreserva.common.feature.core.service.ConcreteService;
import com.negoreserva.common.feature.concrete.product_tag_info.model.ProductTagInfo;
import com.negoreserva.common.feature.concrete.product_tag_info.repository.ProductTagInfoRepo;
import org.springframework.stereotype.Service;

@Service
public class ProductTagInfoService extends ConcreteService<ProductTagInfo> {
    private final ProductTagInfoRepo repository;

    public ProductTagInfoService(ProductTagInfoRepo repository) {
        super(repository);
        this.repository = repository;
    }

    public ProductTagInfo save(ProductTagInfo productTagInfo) {
        return repository.save(productTagInfo);
    }
}
