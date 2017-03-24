package org.huke.oauth.cxf.security.server.service;

import org.huke.oauth.cxf.security.server.domian.Result;
import org.huke.oauth.cxf.security.server.domian.User;
import org.springframework.stereotype.Service;

/**
 * @author huke
 * @create 2017/3/23
 */
@Service
public interface AccountService {

    /**
     * 判断用户名, 密码是否合法
     *
     * @param username
     * @param password
     */
    Result<User> validAccount(String username, String password);
}
