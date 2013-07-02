/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author boulie_r <remi.boulier@epita.fr>
 */
@WebService
@Path("/")
public interface CalculService {
    
    @WebMethod
    @Path("/Calculatrice/plus/{valeur1}/{valeur2}")
    @GET
    String plus(@WebParam(name = "valeur1") @PathParam("valeur1") String valeur1, 
                @WebParam(name = "valeur2") @PathParam("valeur2") String valeur2);
    
    
    @WebMethod
    @Path("/Calculatrice/fois/{valeur1}/{valeur2}")
    @GET
    String fois(@WebParam(name = "valeur1") @PathParam("valeur1") String valeur1, 
                @WebParam(name = "valeur2") @PathParam("valeur2") String valeur2);
    
    @WebMethod
    @Path("/Calculatrice/moins/{valeur1}/{valeur2}")
    @GET
    String moins(@WebParam(name = "valeur1") @PathParam("valeur1") String valeur1, 
                 @WebParam(name = "valeur2") @PathParam("valeur2") String valeur2);
    
    @WebMethod
    @Path("/Calculatrice/divise/{valeur1}/{valeur2}")
    @GET
    String divise(@WebParam(name = "valeur1") @PathParam("valeur1") String valeur1, 
                  @WebParam(name = "valeur2") @PathParam("valeur2") String valeur2);
}
