package com.spring.app.mappers.impl;


import com.spring.app.dtos.request.AddressDTO;
import com.spring.app.entities.Address;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddressMapperImpl implements com.spring.app.mappers.IAddressMapper {

    private final ModelMapper modelMapper;

    @Override
    public Address requestDtoToEntity(AddressDTO requestDto) {
        return modelMapper.map(requestDto, Address.class);
    }



}
