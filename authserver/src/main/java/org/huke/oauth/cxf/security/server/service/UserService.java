package org.huke.oauth.cxf.security.server.service;

import org.huke.oauth.cxf.security.server.annotation.Authenticated;
import org.huke.oauth.cxf.security.server.annotation.Tokened;
import org.huke.oauth.cxf.security.server.domian.Result;
import org.huke.oauth.cxf.security.server.domian.User;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * 用户服务
 *
 * @author huke
 * @create 2017/3/22
 */
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public interface UserService {

    /**
     * 登陆, 需要验证用户名密码
     *
     * @param username
     * @param password
     * @return
     */
    @POST
    @Path("login")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    Result<User> login(String username, String password);

    @GET
    @Path("{userId}")
    @Authenticated
    Result<User> getUser(@PathParam("userId") long userId);
}
