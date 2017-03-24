package org.huke.cxf.security.oauth2.client.web;

import org.huke.cxf.security.oauth2.client.web.domain.Student;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

/**
 * @author huke
 * @create 2017/3/18
 */
@Path("student")
public interface StudentResource {

    @GET
    @Path("${id}")
    Student getStudent(@PathParam("id") String id);

    @POST
    @RolesAllowed("admin")
    Student postStudent(Student student, @Context SecurityContext securityContext);
}
