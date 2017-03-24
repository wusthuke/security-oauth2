package org.huke.oauth.cxf.security.server.core.userdetails;

/**
 * @author huke
 * @create 2017/3/24
 */
public interface UserDetailService {

    UserDetails loadUserByUserName(String username);

}
