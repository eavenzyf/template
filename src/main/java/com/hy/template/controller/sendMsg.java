package com.hy.template.controller;
import com.hy.template.dao.Token;
import com.hy.template.dao.wxTemplate;
import com.hy.template.dao.wxsmallTemplateParam;
import com.hy.template.utils.GetToken;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.hy.template.utils.sendTemplateMsgUtil.sendTemplateMsg;

/**
 * @Classname sendMsg
 * @Description TODO
 * @Date 2019/7/16 14:56
 * @Created by Eaven
 */
public class sendMsg {
    public static void main(String[] args) {
        String token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
        String appID = "wxffc40c2c8d24b734";
        String secret = "f96ad7867ce24675fc8ea37069016dc5";
        //封装了推送实体类，别问我为什么一直封装，java三特性 继承 封装 多态
        wxTemplate tem = new wxTemplate();
        //模板id 刚刚获取废了很成时间 如果还不会，我觉得你应该放弃java了
        //模板id
        tem.setTemplateId("lu1Av74KHk2_KPfp-mZuEdjecc9_LfVU1v4k1u1S0eE");
        //推送给哪位神仙。 这个是openId 不是UnionID 如果是unionId肯定推送不过去。
        //openID
        tem.setToUser("ojOfx5B3kNqCpX0dQUwiINd4vP4M");
        //formId 这个炒鸡重要，没有他百分百推送不成功，formId+openId 才能推送
        //formID
        tem.setForm_id("a7d9f65daeae484a802f440b2aebe826");
        //用户点击之后调到小程序哪个页面 找你们前段工程师提供即可
        tem.setPage("pages/welcome/welcome");
        //有封装了一个实体类 哈哈哈 这个是模板消息参数
        List<wxsmallTemplateParam> paras = new ArrayList<wxsmallTemplateParam>();
        //这个是满参构造 keyword1代表的第一个提示  红包已到账这是提示 #DC143C这是色值不过废弃了
        wxsmallTemplateParam templateParam = new wxsmallTemplateParam(
                "keyword1", "红包已到账", "#DC143C");
        //装进小参数结合中
        paras.add(templateParam);
        //我就不嘚瑟了 省点劲直接扔进去算了哈哈哈哈哈~~~~
        paras.add(new wxsmallTemplateParam("keyword2", "刘骞", ""));
        paras.add(new wxsmallTemplateParam("keyword3", "0.02元", "#DC143C"));
        paras.add(new wxsmallTemplateParam("keyword4", "成功成为您店铺的会员", ""));
        paras.add(new wxsmallTemplateParam("keyword5", "卓志海", ""));
        paras.add(new wxsmallTemplateParam("keyword6", "暂无推荐店铺", ""));
        paras.add(new wxsmallTemplateParam("keyword7", "红包已到您app账户，请尽快查询", "#0000FF"));

        //这里写的挺恶心的，不想抽取工具了。直接转换时间戳把
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date temp = new Date();
        String str = "";
        str = sdf.format(temp);
        paras.add(new wxsmallTemplateParam("keyword8", str, ""));
        //然后把所有参数扔到大的模板中
        tem.setTemplateParamList(paras);
        //模板需要放大的关键词，不填则默认无放大
        tem.setEmphasis_keyword("keyword1.DATA");
        //获取token凭证。
        Token token = GetToken.getToken(token_url,appID,secret);
        String accessToken = token.getAccessToken();
        //最后一步请求接口哈哈哈  推送成功
        boolean result1 = sendTemplateMsg(accessToken, tem);
        if (result1) {
            System.err.println("推送成功");
        } else {
            System.err.println("推送失败");
        }
        
    }
}
