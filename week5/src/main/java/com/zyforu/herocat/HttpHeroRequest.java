package com.zyforu.herocat;

import com.zyforu.servlet.HeroRequest;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

import java.util.List;
import java.util.Map;

/**
 * @author zy
 * @date 2023/9/8 14:13
 * HeroCat对Servlet规范的默认实现
 */
public class HttpHeroRequest implements HeroRequest {
    private HttpRequest request;

    public HttpHeroRequest(HttpRequest request) {
        this.request = request;
    }

    @Override
    public String getUri() {
        return request.uri();
    }

    @Override
    public String getPath() {
        QueryStringDecoder decoder = new QueryStringDecoder(request.uri());
        return decoder.path();
    }

    @Override
    public String getMethod() {
        return request.method().name();
    }

    @Override
    public Map<String, List<String>> getParameters() {
        QueryStringDecoder decoder = new QueryStringDecoder(request.uri());
        return decoder.parameters();
    }

    @Override
    public List<String> getParameters(String name) {
        QueryStringDecoder decoder = new QueryStringDecoder(request.uri());
        return decoder.parameters().get(name);
    }

    @Override
    public String getParameter(String name) {
        QueryStringDecoder decoder = new QueryStringDecoder(request.uri());
        List<String> params = decoder.parameters().get(name);
        if(params == null || params.isEmpty()) {
            return null;
        }
        return params.get(0);
    }
}
