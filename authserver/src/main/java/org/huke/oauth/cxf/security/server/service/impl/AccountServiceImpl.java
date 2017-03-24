package org.huke.oauth.cxf.security.server.service.impl;

import org.huke.oauth.cxf.security.server.domian.Result;
import org.huke.oauth.cxf.security.server.domian.User;
import org.huke.oauth.cxf.security.server.service.AccountService;

/**
 * @author huke
 * @create 2017/3/23
 */
public class AccountServiceImpl implements AccountService {

    @Override
    public Result<User> validAccount(String username, String password) {
        if (! "huke".equals(username)) {
            return new Result<>(null, "9999", "用户名不存在");
        }

        if (! "huke".equals(password)) {
            return new Result<>(null, "9999", "密码不对");
        }

        User user = new User();
        user.setUserId(1234);
        user.setUsername("huke");
        return new Result<>(user, "0000", "success");
    }
}
