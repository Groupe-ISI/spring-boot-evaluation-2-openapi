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
public class AppUserDto {
    private int id;

    @NotNull(message = "Le nom ne doit pas être null")
    private String nom;

    @NotNull(message = "Le prenom ne doit pas être null")
    private String prenom;

    @NotNull(message = "L'email ne doit pas être null")
    private String email;

    @NotNull(message = "Le mot de passe ne doit pas être null")
    private String password;

    @NotNull(message = "L'etat ne doit pas être null")
    private int etat;

}
