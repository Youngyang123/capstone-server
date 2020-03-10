package cn.yg.capstoneserver.utils.jwt.utils;


import cn.hutool.core.convert.Convert;
import cn.yg.capstoneserver.exception.BaseUncheckedException;
import cn.yg.capstoneserver.exception.code.ExceptionCode;
import cn.yg.capstoneserver.utils.jwt.server.constants.JwtConstants;
import io.jsonwebtoken.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class JwtHelper {
    private static final RsaKeyHelper RSA_KEY_HELPER = new RsaKeyHelper();

    /**
     * 生成用户token
     *
     * @param jwtInfo
     * @param priKeyPath
     * @param expire
     * @return
     * @throws BaseUncheckedException
     */
    public static Token generateUserToken(JwtInfo jwtInfo, String priKeyPath, int expire) throws BaseUncheckedException {
        JwtBuilder jwtBuilder = Jwts.builder()
                //设置主题
                .setSubject(String.valueOf(jwtInfo.getUserId()))
                .claim(JwtConstants.JWT_KEY_NAME, jwtInfo.getName());
        return generateToken(jwtBuilder, priKeyPath, expire);
    }


    /**
     * 获取token中的用户信息
     *
     * @param token      token
     * @param pubKeyPath 公钥路径
     * @return
     * @throws BaseUncheckedException
     */
    public static JwtInfo getJwtFromToken(String token, String pubKeyPath) throws BaseUncheckedException{
        Jws<Claims> claimsJws = parserToken(token, pubKeyPath);
        Claims body = claimsJws.getBody();
        String userId = body.getSubject();
        String name = Convert.toStr(body.get(JwtConstants.JWT_KEY_NAME), "");
        return new JwtInfo(userId, name);
    }

    /**
     * 公钥解析token
     *
     * @param token
     * @param pubKeyPath 公钥路径
     * @return
     * @throws BaseUncheckedException
     */
    private static Jws<Claims> parserToken(String token, String pubKeyPath) throws BaseUncheckedException {
        try {
            return Jwts.parser().setSigningKey(RSA_KEY_HELPER.getPublicKey(pubKeyPath)).parseClaimsJws(token);
        } catch (ExpiredJwtException ex) {
            //过期
            throw new BaseUncheckedException(ExceptionCode.JWT_TOKEN_EXPIRED);
        } catch (SignatureException ex) {
            //签名错误
            throw new BaseUncheckedException(ExceptionCode.JWT_SIGNATURE);
        } catch (IllegalArgumentException ex) {
            //token 为空
            throw new BaseUncheckedException(ExceptionCode.JWT_ILLEGAL_ARGUMENT);
        } catch (Exception e) {
            throw new BaseUncheckedException(ExceptionCode.JWT_PARSER_TOKEN_FAIL);
        }
    }

    /**
     * 生成token
     *
     * @param builder
     * @param priKeyPath
     * @param expire
     * @return
     * @throws BaseUncheckedException
     */
    protected static Token generateToken(JwtBuilder builder, String priKeyPath, int expire) throws BaseUncheckedException  {
        try {
            //返回的字符串便是我们的jwt串了
            String compactJws = builder.setExpiration(localDateTime2Date(LocalDateTime.now().plusSeconds(expire)))
                    //设置算法（必须）
                    .signWith(SignatureAlgorithm.RS256, RSA_KEY_HELPER.getPrivateKey(priKeyPath))
                    //这个是全部设置完成后拼成jwt串的方法
                    .compact();
            return new Token(compactJws, expire);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new BaseUncheckedException(ExceptionCode.JWT_GEN_TOKEN_FAIL.getCode(), ExceptionCode.JWT_GEN_TOKEN_FAIL.getMessage());
        }
    }

    /**
     * LocalDateTime转换为Date
     *
     * @param localDateTime
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }
}
