package com.negoreserva.common.feature.concrete.address.service;

import com.negoreserva.common.feature.concrete.address.dto.queryparam.AddressFilterQueryParam;
import com.negoreserva.common.feature.concrete.address.dto.response.AddressPaginate;
import com.negoreserva.common.feature.concrete.address.repository.AddressRepo;
import com.negoreserva.common.feature.concrete.address.model.Address;
import com.negoreserva.common.feature.core.dto.request.PaginateRequest;
import com.negoreserva.common.feature.core.service.ConcreteService;
import com.negoreserva.internal.admin.feature.address.query.AddressFilterSpecification;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService extends ConcreteService<Address> {
    private final AddressRepo repository;

    public AddressService(AddressRepo repository) {
        super(repository);
        this.repository = repository;
    }

    public AddressPaginate paginate(Pageable pageable) {
        var page = repository.findAll(pageable);
        return AddressPaginate.of(page);
    }

    public AddressPaginate paginate(PaginateRequest paginateRequest) {
        return paginate(PageRequest.of(paginateRequest.pageNumber(), paginateRequest.pageSize()));
    }

    public AddressPaginate paginate(AddressFilterQueryParam filter) {
        var pageRequest = PageRequest.of(
                Optional.ofNullable(filter.getPageNumber()).orElse(0),
                Optional.ofNullable(filter.getPageSize()).orElse(10)
        );
        var spec = new AddressFilterSpecification(filter);
        var page = findAll(spec, pageRequest);
        return AddressPaginate.of(page);
    }

    public Address findOrCreate(Address address) {
        return repository.findByZipCode(address.getZipCode()).orElseGet(() -> save(address));
    }
}
