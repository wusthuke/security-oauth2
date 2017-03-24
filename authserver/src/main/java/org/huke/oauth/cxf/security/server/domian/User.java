package org.huke.oauth.cxf.security.server.domian;

import java.io.Serializable;

/**
 * @author huke
 * @create 2017/3/23
 */
public class User implements Serializable {

    private static final long serialVersionUID = 8442939123930276195L;

    private long userId;

    private String username;

    private String phone;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
