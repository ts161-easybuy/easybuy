package cn.easybuy.web;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;



public class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        // 例如：http://localhost:8080/demo1/xxx?method=login
        String methodName = request.getParameter("method");// 它是一个方法名称

        // 当没用指定要调用的方法时，那么默认请求的是execute()方法。
        if(methodName == null || methodName.isEmpty()) {
            methodName = "execute";
        }
        Class c = this.getClass();
        try {
            // 通过方法名称获取方法的反射对象
            Method m = c.getMethod(methodName, HttpServletRequest.class,
                    HttpServletResponse.class);
            // 反射方法目标方法，也就是说，如果methodName为add，那么就调用add方法。
            String result = (String) m.invoke(this, request, response);
            // 通过返回值完成请求转发
            if(result != null && !result.isEmpty()) {
                request.getRequestDispatcher(result).forward(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
