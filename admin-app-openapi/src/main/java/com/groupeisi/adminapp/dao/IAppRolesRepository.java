package com.groupeisi.adminapp.dao;

import com.groupeisi.adminapp.entities.AppRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAppRolesRepository extends JpaRepository<AppRoles, Integer> {
    Optional<AppRoles> findByNom(String nom);
}
