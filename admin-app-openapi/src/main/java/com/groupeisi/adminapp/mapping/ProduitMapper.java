package com.groupeisi.adminapp.mapping;

import com.groupeisi.adminapp.entities.Produit;
import com.groupeisi.generated.model.AppProduitDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProduitMapper {
    Produit toProduit(AppProduitDto produitDto);

    AppProduitDto toProduitDto(Produit produit);
}
