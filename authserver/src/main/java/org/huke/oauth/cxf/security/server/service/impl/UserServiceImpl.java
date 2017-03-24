package org.huke.oauth.cxf.security.server.service.impl;

import org.huke.oauth.cxf.security.server.domian.Result;
import org.huke.oauth.cxf.security.server.domian.User;
import org.huke.oauth.cxf.security.server.service.UserService;

/**
 * @author huke
 * @create 2017/3/23
 */
public class UserServiceImpl implements UserService {

    @Override
    public Result<User> login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPhone("12345678");
        user.setUserId(124);

        return new Result<>(user, "200", "登陆成功");
    }

    @Override
    public Result<User> getUser(long userId) {
        User user = new User();
        user.setUsername("huke");
        user.setUserId(userId);

        return new Result<>(user, "200", "获取数据成功");
    }
}
