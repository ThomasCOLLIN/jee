/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.apache.cxf.jaxrs.impl.MediaTypeHeaderProvider;

/**
 *
 * @author REMI
 */
@WebService
@Path("/")
public interface MangaService {

//    @GET
//    @Path("/manga")
//    @Produces("application/xml")
//    MangaList getManga(@Context UriInfo info);

//    @GET
//    @Path("/download")
//    @Produces("application/octet-stream")
//    Response getDownload(@Context UriInfo info);
    @WebMethod
    @Path("/download")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    Response getDownload(@Context HttpServletRequest request);

}
