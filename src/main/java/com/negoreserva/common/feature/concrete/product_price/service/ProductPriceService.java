package com.negoreserva.common.feature.concrete.product_price.service;

import com.negoreserva.common.feature.concrete.product.service.ProductService;
import com.negoreserva.common.feature.concrete.product_price.dto.response.ProductPricePaginate;
import com.negoreserva.common.feature.concrete.product_price.repository.ProductPriceRepo;
import com.negoreserva.common.feature.concrete.product.model.Product;
import com.negoreserva.common.feature.concrete.product_price.exception.notfound.ProductPriceNotFoundException;
import com.negoreserva.common.feature.concrete.product_price.model.ProductPrice;
import com.negoreserva.common.feature.core.dto.request.PaginateRequest;
import com.negoreserva.common.feature.core.service.ConcreteService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductPriceService extends ConcreteService<ProductPrice> {
    private final ProductPriceRepo repository;
    private final ProductService productService;

    public ProductPriceService(
            ProductPriceRepo repository,
            ProductService productService
    ) {
        super(repository);
        this.repository = repository;
        this.productService = productService;
    }

    public ProductPricePaginate paginate(Pageable pageable) {
        var page = repository.findAll(pageable);
        return ProductPricePaginate.of(page);
    }

    public ProductPricePaginate paginate(PaginateRequest paginateRequest) {
        return paginate(PageRequest.of(paginateRequest.pageNumber(), paginateRequest.pageSize()));
    }

    public ProductPrice findByUuid(UUID uuid) {
        return repository.findByUuid(uuid).orElseThrow(() -> new ProductPriceNotFoundException(uuid));
    }

    public ProductPrice save(ProductPrice productPrice, UUID productUuid) {
        if (productUuid != null) {
            Product product = productService.findByUuid(productUuid);
            productPrice.setProduct(product);
        }
        return save(productPrice);
    }

    public ProductPrice update(UUID uuid, ProductPrice productPrice, UUID productUuid) {
        var item = findByUuid(uuid);
        item.setType(productPrice.getType());
        item.setValue(productPrice.getValue());
        item.setOrder(productPrice.getOrder());
        item.setIsPrimary(productPrice.getIsPrimary());
        item.setUnit(productPrice.getUnit());

        if (productUuid != null) {
            Product product = productService.findByUuid(productUuid);
            item.setProduct(product);
        }

        return repository.save(item);
    }

    @Override
    public ProductPrice update(UUID uuid, ProductPrice productPrice) {
        var item = findByUuid(uuid);
        item.setType(productPrice.getType());
        item.setValue(productPrice.getValue());
        item.setOrder(productPrice.getOrder());
        item.setIsPrimary(productPrice.getIsPrimary());
        item.setUnit(productPrice.getUnit());
        return repository.save(item);
    }
}
