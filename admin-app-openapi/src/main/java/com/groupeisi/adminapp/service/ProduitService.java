package com.groupeisi.adminapp.service;

import com.groupeisi.adminapp.dao.IProduitRepository;
import com.groupeisi.adminapp.mapping.ProduitMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProduitService {
    private final IProduitRepository iProduitRepository;
    private final ProduitMapper produitMapper;
}
