package com.zyforu;

import com.zyforu.herocat.HeroCatServer;

/**
 * @author zy
 * @date 2023/9/8 15:45
 */
public class HeroCat {
    public static void main(String[] args) throws Exception {
        HeroCatServer server = new HeroCatServer("com.zyforu.webapp");
        server.start();
    }
}
