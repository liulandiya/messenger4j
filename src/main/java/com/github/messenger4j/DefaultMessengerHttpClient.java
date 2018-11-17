package com.github.messenger4j;

import com.github.messenger4j.spi.MessengerHttpClient;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.*;

/**
 * @author Max Grabenhorst
 * @since 1.0.0
 */
final class DefaultMessengerHttpClient implements MessengerHttpClient {

    private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json; charset=utf-8";

    private static final OkHttpClient OK_HTTP = new OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .connectionPool(new ConnectionPool(20, 2, TimeUnit.MINUTES))
            .build();

    @Override
    public HttpResponse execute(HttpMethod httpMethod, String url, String jsonBody) throws IOException {
        final Request.Builder requestBuilder = new Request.Builder().url(url);
        if (httpMethod != HttpMethod.GET) {
            final MediaType jsonMediaType = MediaType.parse(APPLICATION_JSON_CHARSET_UTF_8);
            final RequestBody requestBody = RequestBody.create(jsonMediaType, jsonBody);
            requestBuilder.method(httpMethod.name(), requestBody);
        }
        final Request request = requestBuilder.build();
        try (Response response = OK_HTTP.newCall(request).execute()) {
            return new HttpResponse(response.code(), response.body().string());
        }
    }
}
