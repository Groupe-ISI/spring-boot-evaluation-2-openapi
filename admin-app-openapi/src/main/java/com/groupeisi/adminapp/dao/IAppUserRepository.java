package com.groupeisi.adminapp.dao;

import com.groupeisi.adminapp.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByEmail(String email);
}
