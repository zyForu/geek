package com.zyforu.servlet;

import java.util.List;
import java.util.Map;

/**
 * @author zy
 * @date 2023/9/8 14:06
 * 简易的Servlet规范之Request
 */
public interface HeroRequest {

    String getUri();

    String getPath();

    String getMethod();

    Map<String, List<String>> getParameters();

    List<String> getParameters(String name);

    String getParameter(String name);
}
