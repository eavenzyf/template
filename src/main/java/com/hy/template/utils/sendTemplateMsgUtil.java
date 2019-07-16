package com.hy.template.utils;

import com.hy.template.dao.wxTemplate;
import net.sf.json.JSONObject;

import static com.hy.template.utils.httpRequestUtil.httpsRequest;

/**
 * @Classname sendTemplateMsgUtil
 * @Description TODO
 * @Date 2019/7/16 11:52
 * @Created by Eaven
 */
public class sendTemplateMsgUtil {
    public static boolean sendTemplateMsg(String token, wxTemplate template){
        boolean flag = false;
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", token);

        JSONObject jsonResult = JSONObject.fromObject(httpsRequest(requestUrl, "POST", template.toJSON()));
        System.err.println(template.toJSON());
        if (jsonResult != null) {
            Integer errorCode = jsonResult.getInt("errcode");
            String errorMessage = jsonResult.getString("errmsg");
            if (errorCode == 0) {
                flag = true;
            } else {
                System.out.println("模板消息发送失败:" + errorCode + "," + errorMessage);
                flag = false;
            }
        }
        return flag;
    }
}
