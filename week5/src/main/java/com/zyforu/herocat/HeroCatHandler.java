package com.zyforu.herocat;

import com.zyforu.servlet.HeroServlet;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author zy
 * @date 2023/9/8 15:06
 */
public class HeroCatHandler extends ChannelInboundHandlerAdapter {
    private Map<String, HeroServlet> nameToServletMap;
    private Map<String, String> nametoClassNameMap;


    public HeroCatHandler(Map<String, HeroServlet> nameToServletMap,
                          Map<String, String> nametoClassNameMap) {
        this.nametoClassNameMap = nametoClassNameMap;
        this.nameToServletMap = nameToServletMap;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpRequest) {
            HttpRequest request = (HttpRequest) msg;
            String uri = request.uri();

            // 匹配动态资源或者静态资源
            if (uri.contains("servlet")) {
                String serlvetName = uri.substring(uri.lastIndexOf("/") + 1, uri.indexOf("?"));
                HeroServlet heroServlet = new DefaultHeroServlet();
                if (nameToServletMap.containsKey(serlvetName)) {
                    heroServlet = nameToServletMap.get(serlvetName);
                } else if (nametoClassNameMap.containsKey(serlvetName)) {
                    // double-check
                    if (nameToServletMap.get(serlvetName) == null) {
                        synchronized (this) {
                            if (nameToServletMap.get(serlvetName) == null) {
                                String className = nametoClassNameMap.get(serlvetName);
                                heroServlet = (HeroServlet) Class.forName(className).newInstance();
                                nameToServletMap.put(serlvetName, heroServlet);
                            }
                        }
                    }
                }

                HttpHeroRequest req = new HttpHeroRequest(request);
                HttpHeroResponse resp = new HttpHeroResponse(request, ctx);

                if (req.getMethod().equalsIgnoreCase("GET")) {
                    heroServlet.doGet(req, resp);
                } else if (req.getMethod().equalsIgnoreCase("POST")) {
                    heroServlet.doPost(req, resp);
                }

            } else {
                byte[] content;
                InputStream in = this.getClass().getClassLoader().getResourceAsStream(uri.substring(1));
                if (in == null) {
                    content = ("sorry, can not static resouces: " + uri).getBytes(StandardCharsets.UTF_8);
                } else {
                    int size = in.available();
                    content = new byte[size];
                    in.read(content);
                    in.close();
                }
                HttpHeroResponse resp = new HttpHeroResponse(request, ctx);
                resp.write(content);
            }

        }

    }
}
