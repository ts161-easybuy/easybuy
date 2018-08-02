package cn.easybuy.utils;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库操作工具类
 * @author Clearlove
 *
 */
public class BaseUtils {


    //4个属性
    private static String driver;//驱动
    private static String url;//连接字符串
    private static String username;//用户名
    private static String pwd;//密码

    static {
        init();//初始化方法，加载配置文件
    }
    public static void init() {
        Properties properties=new Properties();
        String configFile="database.properties";
        //获取配置文件的输入流
        InputStream is= BaseUtils.class.getClassLoader().getResourceAsStream(configFile);
        try {
            properties.load(is);//从输入流加载配置文件
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //获取对应的键
        driver=properties.getProperty("driver");
        url=properties.getProperty("url");
        username=properties.getProperty("username");
        pwd=properties.getProperty("password");

    }
    //3个方法
    /**
     * 获取数据库连接对象
     * @return
     */
    public Connection getConnection() {
        Connection conn=null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,username,pwd);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }
    /**
     * 获取资源从近到远
     * @param conn
     * @param stmt
     * @param rs
     */
    public void closeAll(Connection conn,PreparedStatement stmt,ResultSet rs) {
        if (rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (stmt!=null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    /**
     * 增删改的通用方法
     * @param sql
     * @param param
     * @return
     */
    public int executeUpdate(String sql,Object[] param) {
        int num=0;
        Connection conn=getConnection();
        PreparedStatement pstmt=null;
        try {
            pstmt=conn.prepareStatement(sql);
            if (param!=null) {
                //动态添加参数到sql
                for(int i=0;i<param.length;i++) {
                    pstmt.setObject(i+1, param[i]);
                }
            }
            num=pstmt.executeUpdate();//执行sql得到受影响行数
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn, pstmt, null);
        }
        return num;
    }
    public static void main(String[] args) {
        BaseUtils dao=new BaseUtils();
        Connection conn=dao.getConnection();
        System.out.println("连接成功");
        dao.closeAll(conn, null, null);
        System.out.println("关闭成功");
    }
}
