package com.groupeisi.adminapp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppRolesDto {

    private int id;

    @NotNull(message = "Le nom ne doit pas être null")
    private String nom;

}
