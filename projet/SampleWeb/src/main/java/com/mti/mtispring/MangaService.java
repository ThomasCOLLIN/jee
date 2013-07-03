package com.mti.mtispring;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.apache.cxf.jaxrs.impl.MediaTypeHeaderProvider;
import com.mti.mtispring.businessManagament.MangaList;
import org.springframework.transaction.annotation.Transactional;

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
    @Path("/manga")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Transactional(readOnly=true)
    public MangaList getManga();

//    @GET
//    @Path("/download")
//    @Produces("application/octet-stream")
//    Response getDownload(@Context UriInfo info);
    @WebMethod
    @Path("/download")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Transactional(readOnly=true)
    Response getDownload();
    


}
