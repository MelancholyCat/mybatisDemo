package xyz.lfans.utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @author Atlantis
 * @create 2019-06-25-20:35
 */
@WebFilter(initParams ={@WebInitParam(name = "encoding",value = "utf-8")},urlPatterns = "/*")
public class EcodeFilter implements Filter {
    // 定义编码方式 默认为空
    private String encoding =null;
    public void destroy() {
    }
    // 自动调用过滤方法 doFilter
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // 如果编码不为空就过滤请求中的数据
        if (encoding != null) {
            // 设置request字符编码
            request.setCharacterEncoding(encoding);
            response.setCharacterEncoding(encoding);
        }
        // 传递给下一个过滤器或者下一个servlet/jsp
        chain.doFilter(request, response);
    }
    public void init(FilterConfig config) throws ServletException {
        //将web.xml中的过滤器的配置编码取出来赋值给  encoding
        encoding=config.getInitParameter("encoding");
    }
}