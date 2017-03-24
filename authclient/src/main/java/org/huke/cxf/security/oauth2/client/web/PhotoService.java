package org.huke.cxf.security.oauth2.client.web;

import org.huke.cxf.security.oauth2.client.web.domain.Photo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author huke
 * @create 2017/3/18
 */
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Path("/photo")
public interface PhotoService {

    @GET
    @Path("/{photoId}")
    Photo getPhoto(@PathParam("photoId") int photoId);
}
