package com.spring.app.services.impl;

import com.spring.app.services.IAddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class AddressServiceImpl implements IAddressService {
}
