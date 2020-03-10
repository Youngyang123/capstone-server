package cn.yg.capstoneserver.config;

import cn.yg.capstoneserver.interceptor.UserAuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 配置interceptor
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getUserAuthRestInterceptor()).
                addPathPatterns(getIncludePathPatterns());
    }

    @Bean
    UserAuthInterceptor getUserAuthRestInterceptor() {
        return new UserAuthInterceptor();
    }

    /**
     * 拦截的路径
     * @return
     */
    private ArrayList<String> getIncludePathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "/academy/**",
                "/artical/**",
                "/category/**",
                "/clazz/**",
                "/comment/**",
                "/import/**",
                "/major",
                "/school/**",
                "/setting/**",
                "/test/**",
                "/upload/**",
                "/collection/**",
                "/focus/**",
                "/like/**",
                "/user/myFocus/**",
                "/user/focusMe/**",
                "/user/import"
        };
        Collections.addAll(list, urls);
        return list;
    }

}
