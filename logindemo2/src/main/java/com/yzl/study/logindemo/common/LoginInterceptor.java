package com.yzl.study.logindemo.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yzl.study.logindemo.model.User;
import com.yzl.study.logindemo.util.JwtUtilBean;
import com.yzl.study.logindemo.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;


@Component
@Slf4j
public class LoginInterceptor implements  HandlerInterceptor  {


    @Autowired
    private JwtUtilBean jwtUtilBean ;

    //这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //每一个项目对于登陆的实现逻辑都有所区别，我这里使用最简单的Session提取User来验证登陆。
//        HttpSession session = request.getSession();
//        //这里的User是登陆时放入session的
//        User user = (User) session.getAttribute("user");
//        //如果session中没有user，表示没登陆
//        if (user == null) {
//            //这个方法返回false表示忽略当前请求，如果一个用户调用了需要登陆才能使用的接口，如果他没有登陆这里会直接忽略掉
//            //当然你可以利用response给用户返回一些提示信息，告诉他没登陆
//            return false;
//        } else {
//            return true;    //如果session里有user，表示该用户已经登陆，放行，用户即可继续调用自己需要的接口
//        }
//    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        Authorization: Bearer [BEARER_TOKEN]
        String authorization  = request.getHeader("Authorization");
        String[] ss = authorization.split(" ");
        String token= ss[1];

        JSONObject jsonObject = jwtUtilBean.validateJWT(token);
//        pojo.put("Success", true);
//        pojo.put("Claims", claims);
        Boolean success = jsonObject.getBoolean("Success");
        if (success) {
            return true;
        } else {
            returnJson( response, JSON.toJSONString(ResponseResult.failMsg("token验证失败")));
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,  Exception ex) throws Exception {

    }

    private void returnJson(HttpServletResponse response, String json) throws Exception{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);

        } catch (IOException e) {
            log.error("response error",e);
        } finally {
            if (writer != null){
                writer.close();
            }
        }

}
}

