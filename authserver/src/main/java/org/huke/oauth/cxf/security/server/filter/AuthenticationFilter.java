package org.huke.oauth.cxf.security.server.filter;

import org.huke.oauth.cxf.security.server.core.userdetails.UserDetails;
import org.huke.oauth.cxf.security.server.domian.Result;
import org.huke.oauth.cxf.security.server.domian.User;
import org.huke.oauth.cxf.security.server.service.AccountService;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

/**
 * 认证
 *
 * @author huke
 * @create 2017/3/22
 */
@Priority(Priorities.AUTHENTICATION)
@Provider
public class AuthenticationFilter implements ContainerRequestFilter {

    private static final String SAVED_REQUEST = "SAVED_REQUEST";

    private AccountService accountService;

    private String loginPage;   //oauth2.0统一登陆url

    private String indexPage;   //登陆成功后默认url

    private String action_login;    //登陆服务action

    private List<String> contextPathPattern; //需要做匹配拦截的url表达式, 部分接口不由自己实现, 未标注 @Authenticated, 但仍需要使用该filter.

    @Context
    private HttpServletRequest request;

    @Context
    private ResourceInfo resourceInfo;

    @Context
    private UriInfo uriInfo;

    @Context
    private SecurityContext securityContext;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // use logged
        if (securityContext != null) {
            Principal principal = this.securityContext.getUserPrincipal();
            if (principal != null) {
                String username = principal.getName();
                UserDetails userDetails = null;
            }
            //
            return;
        }

        // not login, match url 判断是否需要做登陆验证
        if (this.action_login.equals(this.uriInfo.getPath())) {

        }


        HttpSession session = this.request.getSession(true);

        String requestUri = requestContext.getUriInfo().getRequestUri().getPath();
        if (this.action_login.equals(requestUri)) {
            Result<User> authResult = this.authenticateAccount();
            if (Result.CODE_SUCCESS.equals(authResult.getErrorCode())) {
                //login success
                System.out.println("login success, to get user");
                session.setAttribute("user", authResult.getData());

                String redirect = this.indexPage;
                if (session.getAttribute(SAVED_REQUEST) != null) {
                    redirect = (String) session.getAttribute(SAVED_REQUEST);
                    session.removeAttribute(SAVED_REQUEST);
                }
                requestContext.abortWith(Response.status(Response.Status.FOUND).header("Location", redirect).build());
            } else {
                System.out.println("login failure, return back");
                requestContext.abortWith(Response.status(Response.Status.OK).entity(authResult).build());
            }
            return;
        }

        if (session.getAttribute("user") == null) {
            session.setAttribute(SAVED_REQUEST, requestContext.getUriInfo().getAbsolutePath().toString());
            requestContext.abortWith(Response.status(Response.Status.FOUND).header("Location", this.loginPage).build());
            return;
        }

        /*String authorization = requestContext.getHeaderString("Authorization");
        if (StringUtils.isEmpty(authorization)) {
            requestContext.abortWith(Response.status(Response.Status.FOUND).header("Location", loginPage).header("Refer", requestContext.getUriInfo().getPath()).build());
            return;
        }*/
    }

    private void session() {

    }

    private Result<User> authenticateAccount() {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username + "\t password: " + password);
        return this.accountService.validAccount(username, password);
    }

    public void setContextPathPattern(List<String> contextPathPattern) {
        this.contextPathPattern = contextPathPattern;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public void setAction_login(String action_login) {
        this.action_login = action_login;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setIndexPage(String indexPage) {
        this.indexPage = indexPage;
    }
}
