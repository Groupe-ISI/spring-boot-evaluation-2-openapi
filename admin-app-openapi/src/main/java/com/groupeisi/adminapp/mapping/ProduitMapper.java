package com.groupeisi.adminapp.mapping;

import com.groupeisi.adminapp.dto.ProduitDto;
import com.groupeisi.adminapp.entities.Produit;
import org.mapstruct.Mapper;

@Mapper
public interface ProduitMapper {
    Produit toProduit(ProduitDto produitDto);

    ProduitDto toProduitDto(Produit produit);
}
