package com.groupeisi.adminapp.service;

import com.groupeisi.adminapp.dao.IAppRolesRepository;
import com.groupeisi.adminapp.dto.AppRolesDto;
import com.groupeisi.adminapp.exception.EntityNotFoundException;
import com.groupeisi.adminapp.exception.RequestException;
import com.groupeisi.adminapp.mapping.AppRolesMapper;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.MessageSource;
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
    public List<AppRolesDto> getAppRoles() {
        return iAppRolesRepository.findAll().stream()
                .map(appRolesMapper::toAppRolesDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public AppRolesDto getAppRole(int id) {
        return iAppRolesRepository.findById(id)
                .map(appRolesMapper::toAppRolesDto)
                .orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id}, Locale.getDefault())));
    }

    @Transactional(readOnly = true)
    public AppRolesDto getAppRoleByName(String name) {
        return iAppRolesRepository.findByNom(name)
                .map(appRolesMapper::toAppRolesDto)
                .orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("role.notfound.name", new Object[]{name}, Locale.getDefault())));
    }

    @Transactional
    public AppRolesDto createAppRoles(AppRolesDto appRolesDto) {
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
    public AppRolesDto updateAppRoles(int id, AppRolesDto appRolesDto) {
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
