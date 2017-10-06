package com.faryna.eventemitter.service;

import com.faryna.eventemitter.domain.Address;
import com.faryna.eventemitter.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address getAddressById(Integer id) {
        return addressRepository.getAddressById(id);
    }

    public void addAddress(Address address) {
        addressRepository.save(address);
    }
}
