package com.spring.app.mappers.impl;

import com.spring.app.dtos.request.AddressDTO;
import com.spring.app.entities.Address;

public interface IAddressMapper {
    Address requestDtoToEntity(AddressDTO requestDto);
}
