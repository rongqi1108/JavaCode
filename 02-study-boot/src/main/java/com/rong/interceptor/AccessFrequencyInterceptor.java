package com.rong.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 方法访问频率限制
 * @Author: RQ
 * @Date: 2023-02-17 15:09:50
 */
@Slf4j
@Component
public class AccessFrequencyInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) return true;// 判断请求是否属于方法的请求
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            AccessFrequencyLimit accessFrequencyLimit = handlerMethod.getMethodAnnotation(AccessFrequencyLimit.class);//判断该方法是否有该注解
            if (accessFrequencyLimit == null) return true;//没有就放行
            int seconds = accessFrequencyLimit.seconds();
            int maxCount = accessFrequencyLimit.maxCount();
            boolean needLogin = accessFrequencyLimit.needLogin();
            String key = request.getRequestURI();
        //    //如果需要登录
        //    if(login){
        //        //获取登录的session进行判断
        //        //.....
        //        key+=""+"1";  //这里假设用户是1,项目中是动态获取的userId
        //    }
        //
        //    //从redis中获取用户访问的次数
        //    AccessKey ak = AccessKey.withExpire(seconds);
        //    Integer count = redisService.get(ak,key,Integer.class);
        //    if(count == null){
        //        //第一次访问
        //        redisService.set(ak,key,1);
        //    }else if(count < maxCount){
        //        //加1
        //        redisService.incr(ak,key);
        //    }else{
        //        //超出访问次数
        //        render(response,CodeMsg.ACCESS_LIMIT_REACHED); //这里的CodeMsg是一个返回参数
        //        return false;
        //    }
        //}
        log.info("成功拦截，进行了一些逻辑判断");
        return true;
    }

    //private void render(HttpServletResponse response, String str)throws Exception {
    //    response.setContentType("application/json;charset=UTF-8");
    //    OutputStream out = response.getOutputStream();
    //    //String str  = JSON.toJSONString(Result.error(cm));
    //    out.write(str.getBytes("UTF-8"));
    //    out.flush();
    //    out.close();
    //}

}
