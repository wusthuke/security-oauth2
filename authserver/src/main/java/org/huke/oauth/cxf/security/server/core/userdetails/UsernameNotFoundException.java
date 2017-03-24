package org.huke.oauth.cxf.security.server.core.userdetails;

/**
 * @author huke
 * @create 2017/3/24
 */
public class UsernameNotFoundException extends RuntimeException {

    public UsernameNotFoundException(String message) {
        super(message);
    }

    public UsernameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
