package cn.easybuy.services;

import cn.easybuy.entity.User;

public interface UserServices {
    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 注册一个用户
     * @param user
     * @return
     */
    boolean regist(User user);
}
