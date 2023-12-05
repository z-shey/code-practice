package com.shey.servlet;

import com.mysql.cj.util.StringUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/*
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求和响应的字符编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        // 获取请求参数
        String flag = req.getParameter("flag");

        // 判断参数是否为空
        if (StringUtils.isNullOrEmpty(flag)) {
            throw new RuntimeException("请正确传递参数");
        }

        // 获取当前类
        Class<? extends BaseServlet> aClass = this.getClass();

        try {
            // 获取指定方法
            Method method = aClass.getDeclaredMethod(flag, HttpServletRequest.class, HttpServletResponse.class);

            // 调用方法
            String result = (String) method.invoke(this, req, resp);

            // 判断返回值是否为空
            if (StringUtils.isNullOrEmpty(result)) {
                return;
            }
            // 判断返回值是否为重定向或请求转发的字符串
            int i = result.indexOf(":");
            if (i != -1) {
                // result = redirect:xxx.jsp
                // redirect 重定向
                // forward 请求转发
                String prefix = result.substring(0, i);
                String path = result.substring(i + 1);
                if (prefix.equalsIgnoreCase("redirect")) {
                    resp.sendRedirect(req.getContextPath() + path);
                } else if (prefix.equalsIgnoreCase("forward")) {
                    req.getRequestDispatcher(path).forward(req, resp);
                } else {
                    throw new RuntimeException("不支持的请求方式");
                }
            } else {
                req.getRequestDispatcher(result).forward(req, resp); // 默认请求转发
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
*/