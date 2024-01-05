package com.groupeisi.adminapp.service;

import com.groupeisi.adminapp.dao.IAppRolesRepository;
import com.groupeisi.adminapp.entities.AppRoles;
import com.groupeisi.adminapp.exception.EntityNotFoundException;
import com.groupeisi.adminapp.exception.RequestException;
import com.groupeisi.adminapp.mapping.AppRolesMapper;
import com.groupeisi.generated.model.AppRoleDto;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

@Service
@CacheConfig(cacheNames = "roles")
@AllArgsConstructor
public class AppRolesService {
    private final IAppRolesRepository iAppRolesRepository;
    private final AppRolesMapper appRolesMapper;
    private final MessageSource messageSource;

    @Transactional(readOnly = true)
    public List<AppRoleDto> getAppRoles(Integer currentPage, Integer sizePage) {
        Page<AppRoles> appRolesPage = iAppRolesRepository.findAll(PageRequest.of(currentPage, sizePage));
        return appRolesPage.getContent()
                .stream()
                .map(appRolesMapper::toAppRolesDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public AppRoleDto getAppRole(int id) {
        return iAppRolesRepository.findById(id)
                .map(appRolesMapper::toAppRolesDto)
                .orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id}, Locale.getDefault())));
    }

    @Transactional(readOnly = true)
    public AppRoleDto getAppRoleByName(String name) {
        return iAppRolesRepository.findByNom(name)
                .map(appRolesMapper::toAppRolesDto)
                .orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("role.notfound.name", new Object[]{name}, Locale.getDefault())));
    }

    @Transactional
    public AppRoleDto createAppRoles(AppRoleDto appRolesDto) {
        iAppRolesRepository.findByNom(appRolesDto.getNom())
                .ifPresent(role -> {
                    throw new RequestException(messageSource.getMessage(
                            "role.exists",
                            new Object[]{role.getNom()},
                            Locale.getDefault()
                    ), HttpStatus.CONFLICT);
                });
        return appRolesMapper.toAppRolesDto(iAppRolesRepository.save(appRolesMapper.toAppRoles(appRolesDto)));
    }

    @Transactional
    public AppRoleDto updateAppRoles(int id, AppRoleDto appRolesDto) {
        return iAppRolesRepository.findById(id)
                .map(entity -> {
                    appRolesDto.setId(id);
                    return appRolesMapper.toAppRolesDto(iAppRolesRepository.save(appRolesMapper.toAppRoles(appRolesDto)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id}, Locale.getDefault())));
    }

    @Transactional
    public void deleteAppRoles(int id) {
        try {
            iAppRolesRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(
                    messageSource.getMessage(
                            "role.errordeletion",
                            new Object[]{id},
                            Locale.getDefault())
                    , HttpStatus.CONFLICT);
        }

    }
}
