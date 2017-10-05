package com.faryna.eventemitter.repository;

import com.faryna.eventemitter.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address getAddressById(Integer id);
}
