package com.groupeisi.adminapp.mapping;

import com.groupeisi.adminapp.entities.AppUser;
import com.groupeisi.generated.model.AppUserDto;
import org.mapstruct.Mapper;

@Mapper
public interface AppUserMapper {
    AppUser toAppUser(AppUserDto appUserDto);

    AppUserDto toAppUserDto(AppUser appUser);
}
