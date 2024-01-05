package com.groupeisi.adminapp.controller;

import com.groupeisi.adminapp.dto.AppRolesDto;
import com.groupeisi.adminapp.service.AppRolesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class AppRolesController {
    private AppRolesService appRolesService;

    @GetMapping
    public List<AppRolesDto> getAppRoles() {
        return appRolesService.getAppRoles();
    }

    @GetMapping("/{id}")
    public AppRolesDto getAppRoles(@PathVariable("id") int id) {
        return appRolesService.getAppRole(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AppRolesDto createAppRoles(@Valid @RequestBody AppRolesDto appRolesDto) {
        return appRolesService.createAppRoles(appRolesDto);
    }

    @PutMapping("/{id}")
    public AppRolesDto updateAppRoles(@PathVariable("id") int id, @Valid @RequestBody AppRolesDto appRolesDto) {
        return appRolesService.updateAppRoles(id, appRolesDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAppRoles(@PathVariable("id") int id) {
        appRolesService.deleteAppRoles(id);
    }

}
