package com.groupeisi.adminapp.mapping;

import com.groupeisi.adminapp.entities.AppRoles;
import com.groupeisi.generated.model.AppRoleDto;
import org.mapstruct.Mapper;

@Mapper
public interface AppRolesMapper {
    AppRoles toAppRoles(AppRoleDto appRolesDto);

    AppRoleDto toAppRolesDto(AppRoles appRoles);
}
