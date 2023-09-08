package com.zyforu.servlet;

/**
 * @author zy
 * @date 2023/9/8 14:08
 * 简易Servlet规范之Response
 */
public interface HeroResponse {
    void write(String content) throws Exception;

    void write(byte[] data) throws Exception;
}
