package cn.easybuy.dao;

import cn.easybuy.entity.User;

public interface UserDao {
    /**
     * 根据用户名和密码作为条件
     * @param userParam
     * @return
     */
    User findUser(User userParam);

    /**
     * 注册用户
     * @param user
     * @return
     */
    int addUser(User user);
}
