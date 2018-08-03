package cn.easybuy.services.Impl;

import cn.easybuy.dao.Impl.UserDaoImpl;
import cn.easybuy.dao.UserDao;
import cn.easybuy.entity.User;
import cn.easybuy.services.UserServices;

public class UserServicesImpl implements UserServices {
private UserDao userInfo=new UserDaoImpl();
    @Override
    public User login(User user) {
        return userInfo.findUser(user);
    }

    @Override
    public boolean regist(User user) {
        int result=userInfo.addUser(user);
        if(result==1){
            return true;
        }
        return false;
    }
}
