package com.faryna.eventemitter.DTO.impl;

import com.faryna.eventemitter.DTO.DTO;
import com.faryna.eventemitter.domain.Address;
import org.springframework.hateoas.Link;

public class AddressDTO extends DTO<Address> {

    public  AddressDTO(Address address, Link link) {super(address, link);}


    public Integer getEventId(){return  getEntity().getId();}

    public String getName() {
        return getEntity().getName();
    }


}
