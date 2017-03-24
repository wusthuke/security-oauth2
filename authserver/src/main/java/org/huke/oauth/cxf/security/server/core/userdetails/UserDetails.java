package org.huke.oauth.cxf.security.server.core.userdetails;

import java.io.Serializable;

/**
 * @author huke
 * @create 2017/3/24
 */
public interface UserDetails extends Serializable {

    String getPassword();

    String getUsername();

}
