package cn.yg.capstoneserver.interceptor;

import cn.yg.capstoneserver.exception.BaseUncheckedException;
import cn.yg.capstoneserver.exception.code.ExceptionCode;
import cn.yg.capstoneserver.utils.context.BaseContextHandler;
import cn.yg.capstoneserver.utils.jwt.server.properties.AuthServerProperties;
import cn.yg.capstoneserver.utils.jwt.server.utils.JwtTokenServerUtils;
import cn.yg.capstoneserver.utils.jwt.utils.JwtInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAuthInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private AuthServerProperties authServerProperties;

    @Autowired
    private JwtTokenServerUtils jwtTokenServerUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(authServerProperties.getTokenInfo().getHeaderName());
        if (StringUtils.isEmpty(token)){
            throw new BaseUncheckedException(ExceptionCode.JWT_ILLEGAL_ARGUMENT);
        }

        // 相当于检查token，有问题就会抛出异常
        JwtInfo userInfo = jwtTokenServerUtils.getUserInfo(token);

        // 绑定线程变量
        BaseContextHandler.setName(userInfo.getName());
        BaseContextHandler.setUserId(userInfo.getUserId());

        return super.preHandle(request, response, handler);
    }
}
