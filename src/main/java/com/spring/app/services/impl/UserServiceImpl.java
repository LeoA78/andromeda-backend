package com.spring.app.services.impl;

import com.spring.app.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements IUserService {
}
