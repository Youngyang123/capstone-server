package cn.yg.capstoneserver.utils.jwt.server.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "authentication")
@Data
@NoArgsConstructor
public class AuthServerProperties {

    private TokenInfo tokenInfo;

    @Data
    public static class TokenInfo{
        private Integer expire;
        private String headerName;
        private String priKeyPath;
        private String pubKeyPath;
    }
}
