package cn.easybuy.dao.Impl;

import cn.easybuy.dao.UserDao;
import cn.easybuy.entity.User;
import cn.easybuy.utils.BaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl extends BaseUtils implements UserDao {
    @Override
    public User findUser(User userParam) {
        String sql = "SELECT loginName,`password` FROM easybuy_user where loginName=? and `password`=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user=null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userParam.getLoginName());
            pstmt.setString(2, userParam.getPassword());
            rs = pstmt.executeQuery();
           while(rs.next()){
               String loginName=rs.getString("loginName");
               String password=rs.getString("password");
                user=new User(loginName,password);
           }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, pstmt, rs);
        }
        return  user;
    }

    @Override
    public int addUser(User user) {
        String sql="INSERT INTO `easybuy`.`easybuy_user`(`loginName`, `userName`, `password`, email,mobile) " +
                "VALUES (?,?,?,?,?)";
        Object[] param={user.getLoginName(),user.getUserName(),user.getPassword(),user.getEmail(),user.getMobile()};
        int result=executeUpdate(sql,param);
        return result;
    }
}