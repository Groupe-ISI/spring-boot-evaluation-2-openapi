package com.groupeisi.adminapp.dao;

import com.groupeisi.adminapp.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProduitRepository extends JpaRepository<Produit, Integer> {
}
