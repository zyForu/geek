package com.zyforu.herocat;

import com.zyforu.servlet.HeroRequest;
import com.zyforu.servlet.HeroResponse;
import com.zyforu.servlet.HeroServlet;

/**
 * @author zy
 * @date 2023/9/8 14:31
 */
public class DefaultHeroServlet extends HeroServlet {
    @Override
    public void doGet(HeroRequest request, HeroResponse response) throws Exception {
        String uri = request.getUri();
        String name = uri.substring(0, uri.indexOf("?"));
        response.write("404-no this servlet : " + name);
    }

    @Override
    public void doPost(HeroRequest request, HeroResponse response) throws Exception {
        doGet(request, response);
    }
}
