package org.huke.cxf.security.oauth2.client.web.impl;

import org.huke.cxf.security.oauth2.client.web.StudentResource;
import org.huke.cxf.security.oauth2.client.web.domain.Student;
import org.springframework.stereotype.Service;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

/**
 * @author huke
 * @create 2017/3/18
 */
@Service
public class StudentResourceImpl implements StudentResource {

    @Override
    public Student getStudent(String id) {
        return null;
    }

    @Override
    public Student postStudent(Student student, @Context SecurityContext securityContext) {
        if (! securityContext.isUserInRole("admin")) {
            throw new WebApplicationException(403);
        }
        return null;
    }
}
