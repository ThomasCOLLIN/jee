package com.mti.mtispring;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    @WebMethod
    @Path("/download")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    Response getDownload(@Context HttpServletRequest request) throws Exception;

}
