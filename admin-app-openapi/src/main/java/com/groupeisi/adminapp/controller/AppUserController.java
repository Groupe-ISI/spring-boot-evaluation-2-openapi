package com.groupeisi.adminapp.controller;

import com.groupeisi.generated.api.UserControllerApi;
import com.groupeisi.generated.model.AppUserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class AppUserController implements UserControllerApi {

    /**
     * POST /users : Create a user.
     *
     * @param appUserDto A user model request body... (required)
     * @return User crée avec succès. (status code 201)
     * or BAD REQUEST (status code 400)
     * or Unauthorized (status code 401)
     * or NOT FOUND (status code 404)
     * or Unexpected error. (status code 5XX)
     */
    @Override
    public ResponseEntity<AppUserDto> createAppUser(AppUserDto appUserDto) throws Exception {
        return UserControllerApi.super.createAppUser(appUserDto);
    }

    /**
     * DELETE /users/{id} : Delete a user by the given id.
     *
     * @param id The given user ID (required)
     * @return The resource was deleted successfully. (status code 204)
     * or BAD REQUEST (status code 400)
     * or Unauthorized (status code 401)
     * or NOT FOUND (status code 404)
     * or Unexpected error. (status code 5XX)
     */
    @Override
    public ResponseEntity<Void> deleteAppUser(Integer id) throws Exception {
        return UserControllerApi.super.deleteAppUser(id);
    }

    /**
     * GET /users/{id} : Get a user by the given id.
     *
     * @param id The given user ID (required)
     * @return Ok (status code 200)
     * or BAD REQUEST (status code 400)
     * or Unauthorized (status code 401)
     * or NOT FOUND (status code 404)
     * or Unexpected error. (status code 5XX)
     */
    @Override
    public ResponseEntity<AppUserDto> getAppUser(Integer id) throws Exception {
        return UserControllerApi.super.getAppUser(id);
    }

    /**
     * GET /users : List of users.
     *
     * @param currentPage (required)
     * @param sizePage    (required)
     * @return SUCCESS (status code 200)
     * or The resource was deleted successfully. (status code 204)
     * or BAD REQUEST (status code 400)
     * or Unauthorized (status code 401)
     * or NOT FOUND (status code 404)
     * or Unexpected error. (status code 5XX)
     */
    @Override
    public ResponseEntity<List<AppUserDto>> getAppUsers(Integer currentPage, Integer sizePage) throws Exception {
        return UserControllerApi.super.getAppUsers(currentPage, sizePage);
    }

    /**
     * PUT /users/{id} : Update a user by the given id.
     *
     * @param id         The given user ID (required)
     * @param appUserDto A user model request body... (required)
     * @return Ok (status code 200)
     * or BAD REQUEST (status code 400)
     * or Unauthorized (status code 401)
     * or NOT FOUND (status code 404)
     * or Unexpected error. (status code 5XX)
     */
    @Override
    public ResponseEntity<AppUserDto> updateAppUser(Integer id, AppUserDto appUserDto) throws Exception {
        return UserControllerApi.super.updateAppUser(id, appUserDto);
    }
}
