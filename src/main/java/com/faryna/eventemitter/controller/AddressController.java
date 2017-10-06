package com.faryna.eventemitter.controller;

import com.faryna.eventemitter.DTO.DTOBuilder;
import com.faryna.eventemitter.DTO.impl.AddressDTO;
import com.faryna.eventemitter.DTO.impl.EventDTO;
import com.faryna.eventemitter.domain.Address;
import com.faryna.eventemitter.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class AddressController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/api/address/{addressId}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Integer addressId) {
        Address event = addressService.getAddressById(addressId);
        Link selfLink = linkTo(methodOn(AddressController.class).getAddressById(addressId)).withSelfRel();
        AddressDTO linkDTO = DTOBuilder.buildDtoForEntity(event, AddressDTO.class, selfLink);
        return new ResponseEntity<>(linkDTO, HttpStatus.OK);
    }

    @PostMapping("/api/address")
    public ResponseEntity<AddressDTO> addEvent(@RequestBody Address address) {
        LOGGER.debug("Added new Event with name: {}", address.getName());
        addressService.addAddress(address);
        Link selfLink = linkTo(methodOn(AddressController.class).getAddressById(address.getId())).withSelfRel();
        AddressDTO addressDTO = DTOBuilder.buildDtoForEntity(address, AddressDTO.class, selfLink);
        return new ResponseEntity<>(addressDTO, HttpStatus.CREATED);
    }

}
