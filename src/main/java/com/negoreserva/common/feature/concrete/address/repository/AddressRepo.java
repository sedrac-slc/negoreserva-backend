package com.negoreserva.common.feature.concrete.address.repository;

import com.negoreserva.common.feature.concrete.address.model.Address;
import com.negoreserva.common.feature.core.repository.ConcreteRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressRepo extends ConcreteRepository<Address> {
    List<Address> findByUuidIn(List<UUID> uuids);
    Optional<Address> findByZipCode(String zipCode);
}
