package cn.easybuy.test;

import cn.easybuy.dao.Impl.UserDaoImpl;
import cn.easybuy.dao.UserDao;
import cn.easybuy.entity.User;
import org.junit.Test;

public class TestBaseServlet {
    @Test
    public  void   Scc(){
                UserDao dao=new UserDaoImpl();
                int user=dao.addUser(new User("1233","sdsd","123","sadad","1513520"));
        System.out.println(user);
    }


}
