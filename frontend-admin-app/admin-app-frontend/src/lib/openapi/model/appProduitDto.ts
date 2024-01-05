/**
 * APIs de la gestion de stock.
 * Microservice de gestion de stock avec AppRole, AppUser, et AppProduit...
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


export interface AppProduitDto { 
    /**
     * Functional id of the product.
     */
    id?: number;
    /**
     * Name of the product.
     */
    nom?: string;
    /**
     * Stock quantity of the product.
     */
    qteStock?: number;
}
