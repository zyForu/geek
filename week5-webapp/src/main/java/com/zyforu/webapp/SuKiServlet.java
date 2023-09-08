package com.zyforu.webapp;

import com.zyforu.servlet.HeroRequest;
import com.zyforu.servlet.HeroResponse;
import com.zyforu.servlet.HeroServlet;

/**
 * @author zy
 * @date 2023/9/8 16:10
 */
public class SuKiServlet extends HeroServlet {
    @Override
    public void doGet(HeroRequest request, HeroResponse response) throws Exception {
        String path = request.getPath();
        String method = request.getMethod();
        String name = request.getParameter("name");

        response.write("访问方法:" + method + "\r\n"
                    + "访问路径: " + path + "\r\n"
                    + "访问参数: " + name + "\r\n"
                    );

    }

    @Override
    public void doPost(HeroRequest request, HeroResponse response) throws Exception {
        doGet(request, response);
    }
}
