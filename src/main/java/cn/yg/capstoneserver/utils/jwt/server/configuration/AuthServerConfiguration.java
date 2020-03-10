package cn.yg.capstoneserver.utils.jwt.server.configuration;


import cn.yg.capstoneserver.utils.jwt.server.properties.AuthServerProperties;
import cn.yg.capstoneserver.utils.jwt.server.utils.JwtTokenServerUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(value = {
        AuthServerProperties.class,
})
@Configuration
public class AuthServerConfiguration {
    @Bean
    public JwtTokenServerUtils getJwtTokenServerUtils(AuthServerProperties authServerProperties) {
        return new JwtTokenServerUtils(authServerProperties);
    }
}
