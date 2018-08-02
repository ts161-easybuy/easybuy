package cn.easybuy.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{

    private String encode;//编码
    @Override
    public void destroy() {
        encode=null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        //System.out.println("执行过滤器");
        if(null==request.getCharacterEncoding()){
            request.setCharacterEncoding(encode);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encode=filterConfig.getInitParameter("encode");
    }

}
