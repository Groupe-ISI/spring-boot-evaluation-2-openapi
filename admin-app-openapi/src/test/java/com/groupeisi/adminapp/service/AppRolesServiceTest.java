package com.groupeisi.adminapp.service;

import com.groupeisi.adminapp.dto.AppRolesDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppRolesServiceTest {

    @Autowired
    private AppRolesService appRolesService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAppRoles() {
        List<AppRolesDto> appRolesDtos = appRolesService.getAppRoles();
        Assertions.assertTrue(true);
    }

//    @Test
//    void getAppRole() {
//        AppRolesDto appRolesDto = appRolesService.getAppRole(4);
//
//        Assertions.assertNotNull(appRolesDto);
//    }
//
//    @Test
//    void createAppRoles() {
//
//        AppRolesDto appRolesDto = new AppRolesDto();
//        appRolesDto.setNom("ROLE_TEST1");
//
//        //Appel service d'enregistrement
//        AppRolesDto savedAppRolesDto = appRolesService.createAppRoles(appRolesDto);
//
//        Assertions.assertNotNull(savedAppRolesDto);
//        Assertions.assertEquals(appRolesDto.getNom(), savedAppRolesDto.getNom());
//    }
//
//    @Test
//    void updateAppRoles() {
//        AppRolesDto appRolesDto = new AppRolesDto();
//        appRolesDto.setNom("ROLE_TECH");
//
//        //Appel service de modification
//        AppRolesDto updatedAppRolesDto = appRolesService.updateAppRoles(6, appRolesDto);
//
//        Assertions.assertNotNull(updatedAppRolesDto);
//        Assertions.assertEquals("ROLE_TECH", updatedAppRolesDto.getNom());
//    }
//
//    @Test
//    void deleteAppRoles() {
//        appRolesService.deleteAppRoles(5);
//        Assertions.assertTrue(true);
//    }

    @Test
    void operation() {
        int val1 = 1;
        int val2 = 2;
        int val3 = val1 + val2;
        Assertions.assertEquals(3, val3);
    }
}