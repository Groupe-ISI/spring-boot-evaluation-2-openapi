package com.groupeisi.adminapp.controller;

import com.groupeisi.adminapp.service.AppRolesService;
import com.groupeisi.generated.api.RoleControllerApi;
import com.groupeisi.generated.model.AppRoleDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AppRolesController implements RoleControllerApi {
    private AppRolesService appRolesService;


    @Override
    public ResponseEntity<AppRoleDto> createAppRole(AppRoleDto appRoleDto) throws Exception {
        return new ResponseEntity<>(appRolesService.createAppRoles(appRoleDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteAppRole(Integer id) throws Exception {
        appRolesService.deleteAppRoles(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<AppRoleDto> getAppRole(Integer id) throws Exception {
        return ResponseEntity.ok(appRolesService.getAppRole(id));
    }

    @Override
    public ResponseEntity<List<AppRoleDto>> getAppRoles(Integer currentPage, Integer sizePage) throws Exception {
        return ResponseEntity.ok(appRolesService.getAppRoles(currentPage, sizePage));
    }

    @Override
    public ResponseEntity<AppRoleDto> updateAppRole(Integer id, AppRoleDto appRoleDto) throws Exception {
        return new ResponseEntity<>(appRolesService.updateAppRoles(id, appRoleDto), HttpStatus.OK);
    }

}
