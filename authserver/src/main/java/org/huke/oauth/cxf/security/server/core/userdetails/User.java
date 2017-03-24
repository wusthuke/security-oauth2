package org.huke.oauth.cxf.security.server.core.userdetails;

/**
 * @author huke
 * @create 2017/3/24
 */
public class User implements UserDetails {

    private static final long serialVersionUID = -6339151132524256675L;

    private String username;

    private String password;

    private String userToken;

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
