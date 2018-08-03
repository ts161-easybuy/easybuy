package cn.easybuy.services.Servlet;

import cn.easybuy.entity.User;
import cn.easybuy.services.Impl.UserServicesImpl;
import cn.easybuy.services.UserServices;
import cn.easybuy.utils.EmptyUtils;
import org.apache.commons.codec.digest.DigestUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UserService")
public class UserInfoServlet  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
      String action=request.getParameter("action");
       UserServices userServices=new UserServicesImpl();
        PrintWriter out=response.getWriter();
        if ("login".equals(action)){
            String loginName=request.getParameter("loginName");
            String password=request.getParameter("password");
            //String md5= DigestUtils.md5Hex(password);
            User user=new User(loginName,password);

            User userResult=userServices.login(user);
            if (null!=userResult){
                request.getSession().setAttribute("user",userResult);
                response.sendRedirect("index.jsp");
                return;
            }else {
                out.print("<script>alert('您的用户名或者密码错误');location='Login.jsp'</script>");
                out.flush();
                out.close();
                return;
            }
        }else if ("regist".equals(action)) {
            String loginName = request.getParameter("loginName");

            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String affirm = request.getParameter("affirm");
            String email = request.getParameter("email");
            String  phone=request.getParameter("phone");

            String error = "";//提示的消息
            if (EmptyUtils.isEmpty(loginName)) {
               out.print("<script>alert('用户id不能为空')</script>");
                request.getRequestDispatcher("Regist.jsp").forward(request,response);
               return ;
            }
            if (EmptyUtils.isEmpty(userName)) {
                out.print("<script>alert('用户名不能为空')</script>");
                request.getRequestDispatcher("Regist.jsp").forward(request,response);
                return ;
            }
            if (EmptyUtils.isEmpty(password)) {
                out.print("<script>alert('密码不能为空')</script>");
                request.getRequestDispatcher("Regist.jsp").forward(request,response);
                return ;
            }
            if (!password.equals(affirm)) {
                error = "两次输入密码不一致";
            }
            if (EmptyUtils.isEmpty(email)) {
                out.print("<script>alert('邮箱不能为空')</script>");
                request.getRequestDispatcher("Regist.jsp").forward(request,response);
                return ;
            }
           String md5 = DigestUtils.md5Hex(password);
            User user = new User(loginName, userName, md5, email, phone);
            boolean users = userServices.regist(user);
            if (users == true) {
                user.setLoginName(loginName);
                user.setUserName(userName);
                user.setPassword(md5);
                user.setEmail(email);
                user.setMobile(phone);
                request.setAttribute("error", "注册成功");  request.getRequestDispatcher("Login.jsp").forward(request,response);

                return;
            } else {
                request.setAttribute("error", "注册失败");
                request.getRequestDispatcher("Regist.jsp").forward(request,response);
                return;
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
