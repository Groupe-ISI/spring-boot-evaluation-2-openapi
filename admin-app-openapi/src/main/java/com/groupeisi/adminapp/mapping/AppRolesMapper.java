package com.groupeisi.adminapp.mapping;

import com.groupeisi.adminapp.dto.AppRolesDto;
import com.groupeisi.adminapp.entities.AppRoles;
import org.mapstruct.Mapper;

@Mapper
public interface AppRolesMapper {
    AppRoles toAppRoles(AppRolesDto appRolesDto);

    AppRolesDto toAppRolesDto(AppRoles appRoles);
}
