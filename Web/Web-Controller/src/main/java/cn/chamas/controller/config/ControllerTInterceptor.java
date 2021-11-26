package cn.chamas.controller.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class ControllerTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //放行所有访问
        return true;
        // 重写preHandle方法，在请求发生前执行，此处对每个请求的token进行校验
        // 但是登陆的时候没有token就不能对登陆的接口进行拦截，所以要设置自定义的拦截规则
//        HashMap<String, Object> map = new HashMap<>();
//        String token = request.getHeader("token");  //从request中获取到请求头中的token,进行解析校验
//        try {
//            jwtUtil.verifyToken(token);//调用token解析的工具类进行解析
//            return true;  //请求放行
//        } catch (SignatureVerificationException e) {
//            e.printStackTrace();
//            map.put("msg", "签名不一致异常");
//        } catch (TokenExpiredException e) {
//            e.printStackTrace();
//            map.put("msg", "令牌过期异常");
//        } catch (AlgorithmMismatchException e) {
//            e.printStackTrace();
//            map.put("msg", "算法不匹配异常");
//        } catch (InvalidClaimException e) {
//            e.printStackTrace();
//            map.put("msg", "失效的payload异常");
//        } catch (Exception e) {
//            e.printStackTrace();
//            map.put("msg", "token无效");
//        }
//        //map异常的数据要返回给客户端需要转换成json格式  @ResponseBody 内置了jackson
//        String resultJson = new ObjectMapper().writeValueAsString(map);
//        response.setContentType("application/json;charset=utf-8");
//        response.getWriter().print(resultJson);
//        return false;  //异常不放行
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        // 当preHandle方法返回值为true的时候才会执行
        // 重写postHandle方法,在请求完成后执行
//        System.out.println("postHandle执行了");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        // 当preHandle方法返回值为true的时候才会执行
        // 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等.返回处理(已经渲染了页面)
//        System.out.println("afterCompletion执行了");
    }
}
