package com.groupeisi.adminapp.service;

import com.groupeisi.adminapp.dao.IAppUserRepository;
import com.groupeisi.adminapp.mapping.AppUserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService {
    private final IAppUserRepository iAppUserRepository;
    private final AppUserMapper appUserMapper;
}
