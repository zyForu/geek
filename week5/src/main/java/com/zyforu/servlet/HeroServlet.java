package com.zyforu.servlet;

/**
 * @author zy
 * @date 2023/9/8 14:09
 *
 */
public abstract class HeroServlet {

    // 处理get请求
    public abstract void doGet(HeroRequest request, HeroResponse response) throws Exception;

    // 处理post请求
    public abstract void doPost(HeroRequest request, HeroResponse response) throws Exception;

}
