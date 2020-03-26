package com.yzl.study.logindemo.controller;

import com.yzl.study.logindemo.model.User;
import com.yzl.study.logindemo.service.UserService;
import com.yzl.study.logindemo.util.BeanCopierUti;
import com.yzl.study.logindemo.util.JwtUtilBean;
import com.yzl.study.logindemo.util.ResponseResult;
import com.yzl.study.logindemo.vo.UserRegisterReqVO;
import com.yzl.study.logindemo.vo.UserLoginReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")

public class UserController {
    @Value("${sessionOutTimeSeconde}")
    private Integer  sessionOutTimeSeconde;

    @Autowired
    private UserService userService;


    @Autowired
    private RedisTemplate<String, Object> redisTemplate ;

    @Autowired
    private JwtUtilBean jwtUtilBean ;





    @PostMapping("/register")
    public Object register(@Validated UserRegisterReqVO userReq) {

        String  cachedValidCode = (String) redisTemplate.opsForValue().get(userReq.getPhone());
        if(cachedValidCode == null || !cachedValidCode.equals(userReq.getValidCode())){

            return ResponseResult.failMsg("验证码过期，请重新获取验证码注册");
        }
        User user = new User();
        BeanCopierUti.copy(userReq, user);
        int i = userService.create(user);
        if (i == 1) {
            return ResponseResult.successMsg();
        }
        return ResponseResult.failMsg();
    }

    @PostMapping("/login")
    public Object login(@Validated UserLoginReqVO userRVO, HttpSession session) {

        User sessionUser = (User) session.getAttribute("user");
         if(sessionUser!=null){ //已经登录则直接返回
             return ResponseResult.successMsg("用户已登录，无需再次登录");
         }
        User user = new User();
        BeanCopierUti.copy(userRVO, user);
        User userResult = userService.login(user);
        if (userResult != null) {
            session.setAttribute("user", user);
            //session.setMaxInactiveInterval(sessionOutTimeSeconde);  //设置过期时间以秒为单位，会自动刷新
            return ResponseResult.successMsg();
        }
        return ResponseResult.failMsg();
    }

    @GetMapping("/logout")
    public Object logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return ResponseResult.successMsg();
    }
    @GetMapping("/jwt")
    public Object getJwt(@Validated UserLoginReqVO userRVO) {


        User user = new User();
        BeanCopierUti.copy(userRVO, user);
        User userResult = userService.login(user);
        if (userResult != null) {
            String jwtToken = jwtUtilBean.createJWT(userResult.getId()+"" ,userResult.getName() ,1000*60*1  );
            return ResponseResult.successMsgObject(jwtToken);
        }

        return ResponseResult.failMsg("登录失败");
    }


}
