package com.zyforu.herocat;

import com.zyforu.servlet.HeroServlet;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zy
 * @date 2023/9/8 14:33
 */
public class HeroCatServer {
    private Map<String, HeroServlet> nameToServletMap = new ConcurrentHashMap<>();

    private Map<String, String> nameToClassNameMap = new HashMap<>();

    private String basePackage;


    public HeroCatServer(String basePackage) {
        this.basePackage = basePackage;
    }

    // 启动HeroCat
    public void start() throws Exception {
        cacheClassName(basePackage);
        runServer();
    }



    private void cacheClassName(String basePackage) {
        URL resource = this.getClass().getClassLoader().getResource(basePackage.replace(".", "/"));

        if(resource == null) {
            return;
        }


        File dir = new File(resource.getFile());
        for(File file : dir.listFiles()) {
            if(file.isDirectory()) {
                cacheClassName(basePackage + "." + file.getName());
            }else if(file.getName().endsWith(".class")) {
                String simpleClassName = file.getName().replace(".class", "").trim();
                nameToClassNameMap.put(simpleClassName.toLowerCase(), basePackage + "." + simpleClassName);
            }
        }
    }

    private void runServer() throws InterruptedException, DocumentException, IOException {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workGroup)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new HttpServerCodec());
                            pipeline.addLast(new HeroCatHandler(nameToServletMap, nameToClassNameMap));
                        }
                    });
            int port = initPort();
            ChannelFuture future = bootstrap.bind(port).sync();
            System.out.println("HeroCat启动成功:" + "监听端口号为:" + port);
            future.channel().closeFuture().sync();
        }
        finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }

    private int initPort() throws DocumentException, IOException {
        InputStream in = HeroCatServer.class.getClassLoader().getResourceAsStream("server.xml");
        SAXReader saxReader = new SAXReader();
        Document doc = saxReader.read(in);
        Element ele = (Element) doc.selectSingleNode("//port");
        in.close();
        return Integer.valueOf(ele.getText());
    }
}
