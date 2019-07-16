package com.hy.template.utils;

import com.hy.template.dao.Token;
import net.sf.json.JSONObject;

import static com.hy.template.utils.httpRequestUtil.httpsRequest;

/**
 * @Classname GetToken
 * @Description TODO
 * @Date 2019/7/16 11:30
 * @Created by Eaven
 */
public class GetToken {
    public static Token getToken(String token_url,String appID,String secret){
        Token token = null;
        String requestUrl = token_url.replace("APPID", appID).replace("APPSECRET", secret);
        // 发起GET请求获取凭证
        JSONObject jsonObject = JSONObject.fromObject(httpsRequest(requestUrl, "GET", null));

        if (null != jsonObject) {
            try {
                token = new Token();
                token.setAccessToken(jsonObject.getString("access_token"));
                token.setExpiresIn(jsonObject.getInt("expires_in"));
            } catch (Exception e) {
                token = null;
                // 获取token失败
                //log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
                  //      jsonObject.getString("errmsg"));
            }
        }
        return token;
    }
}
