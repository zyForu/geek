package com.zyforu;

import com.zyforu.herocat.HeroCatServer;

/**
 * @author zy
 * @date 2023/9/8 16:07
 */
public class WebApplication {

    public static void run(String[] args) throws Exception {
        HeroCatServer server = new HeroCatServer("com.zyforu.webapp");
        server.start();
    }
}
