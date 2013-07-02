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
public interface HelloService {

    @WebMethod
    @Path("/hello/{name}")
    @GET
    String hello(@WebParam(name = "name") @PathParam("name") String txt);
}
