package cn.yg.capstoneserver.utils.jwt.server.utils;



import cn.yg.capstoneserver.exception.BaseUncheckedException;
import cn.yg.capstoneserver.utils.jwt.server.properties.AuthServerProperties;
import cn.yg.capstoneserver.utils.jwt.utils.JwtHelper;
import cn.yg.capstoneserver.utils.jwt.utils.JwtInfo;
import cn.yg.capstoneserver.utils.jwt.utils.Token;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JwtTokenServerUtils {

    private AuthServerProperties authServerProperties;

    /**
     * 生成token
     *
     * @param jwtInfo
     * @param expire
     * @return
     * @throws BaseUncheckedException
     */
    public Token generateUserToken(JwtInfo jwtInfo, Integer expire) throws BaseUncheckedException {
        AuthServerProperties.TokenInfo userTokenInfo = authServerProperties.getTokenInfo();
        if (expire == null || expire <= 0) {
            expire = userTokenInfo.getExpire();
        }
        return JwtHelper.generateUserToken(jwtInfo, userTokenInfo.getPriKeyPath(), expire);
    }

    /**
     * 解析token
     *
     * @param token
     * @return
     * @throws BaseUncheckedException
     */
    public JwtInfo getUserInfo(String token) throws BaseUncheckedException {
        AuthServerProperties.TokenInfo userTokenInfo = authServerProperties.getTokenInfo();
        return JwtHelper.getJwtFromToken(token, userTokenInfo.getPubKeyPath());
    }
}
