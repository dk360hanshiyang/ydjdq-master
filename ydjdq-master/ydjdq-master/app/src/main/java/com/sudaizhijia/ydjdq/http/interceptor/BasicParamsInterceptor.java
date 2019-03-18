package com.sudaizhijia.ydjdq.http.interceptor;

import android.text.TextUtils;

import com.zhy.http.okhttp.request.CountingRequestBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * Author: 王强
 * Version:  1.0
 * Date:    2016/3/4
 * Modify:
 * Description: Application
 * Copyright notice: 北京周周网络科技有限公司
 */
public class BasicParamsInterceptor implements Interceptor {

    Map<String, String> queryParamsMap = new HashMap<>();
    Map<String, String> paramsMap = new HashMap<>();
    Map<String, String> headerParamsMap = new HashMap<>();
    List<String> headerLinesList = new ArrayList<>();

    private BasicParamsInterceptor() {

    }

    public void setQueryParamsMap(Map<String, String> queryParamsMap) {
        this.queryParamsMap = queryParamsMap;
    }

    public void setParamsMap(Map<String, String> paramsMap) {
        this.paramsMap = paramsMap;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();
        // process header params inject
        Headers.Builder headerBuilder = request.headers().newBuilder();
        if (headerParamsMap.size() > 0) {
            Iterator iterator = headerParamsMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                headerBuilder.add((String) entry.getKey(), (String) entry.getValue());
            }
        }

        if (headerLinesList.size() > 0) {
            for (String line : headerLinesList) {
                headerBuilder.add(line);
            }
        }
        requestBuilder.headers(headerBuilder.build());
        // process header params end


        // 如果是get方法 拼接字符串

        if (queryParamsMap.size() > 0 && (request.method().equals("GET"))) {
            request = injectParamsIntoUrl(request.url().newBuilder(), requestBuilder, queryParamsMap);
        }
        if (queryParamsMap.size() > 0 && request.body() != null && request.body().contentType().type().equals("multipart")) {
            request = injectParamsIntoUrl(request.url().newBuilder(), requestBuilder, queryParamsMap);
        }

        // process post body inject
        if (paramsMap != null && paramsMap.size() > 0 && request.method().equals("POST")) {
            if (request.body() instanceof CountingRequestBody) {
                CountingRequestBody oldbody = (CountingRequestBody) request.body();
//                LogUtils.i("wangyu",oldbody.delegate.toString());
                if (oldbody.delegate instanceof FormBody) {
                    request = FormBody(requestBuilder, oldbody.delegate);
                } else if (oldbody.delegate instanceof MultipartBody) {
                    request = MultipartBody(requestBuilder, oldbody.delegate);
                }
            } else if (request.body() instanceof FormBody) {
                request = FormBody(requestBuilder, request.body());
            } else if (request.body() instanceof MultipartBody) {
                request = MultipartBody(requestBuilder, request.body());
            }
        }
        return chain.proceed(request);
    }

    private Request FormBody(Request.Builder requestBuilder, RequestBody requestBody) {
        FormBody.Builder newFormBodyBuilder = new FormBody.Builder();
        if (paramsMap.size() > 0) {
            Iterator iterator = paramsMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                newFormBodyBuilder.add((String) entry.getKey(), (String) entry.getValue());
            }
        }

        FormBody oldFormBody = (FormBody) requestBody;
        int paramSize = oldFormBody.size();
        if (paramSize > 0) {
            for (int i = 0; i < paramSize; i++) {
                newFormBodyBuilder.add(oldFormBody.name(i), oldFormBody.value(i));
            }
        }

        requestBuilder.post(newFormBodyBuilder.build());
        return requestBuilder.build();
    }

    private Request MultipartBody(Request.Builder requestBuilder, RequestBody requestBody) {
        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);

        Iterator iterator = paramsMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            multipartBuilder.addFormDataPart((String) entry.getKey(), (String) entry.getValue());
        }

        List<MultipartBody.Part> oldParts = ((MultipartBody) requestBody).parts();
        if (oldParts != null && oldParts.size() > 0) {
            for (MultipartBody.Part part : oldParts) {
                multipartBuilder.addPart(part);
            }
        }
        requestBuilder.post(multipartBuilder.build());
        return requestBuilder.build();
    }


    private boolean canInjectIntoBody(Request request) {
        if (request == null) {
            return false;
        }
        if (!TextUtils.equals(request.method(), "POST")) {
            return false;
        }
        RequestBody body = request.body();
        if (body == null) {
            return false;
        }
        MediaType mediaType = body.contentType();
        if (mediaType == null) {
            return false;
        }
        if (!TextUtils.equals(mediaType.subtype(), "x-www-form-urlencoded")) {
            return false;
        }
        return true;
    }

    // func to inject params into url
    private Request injectParamsIntoUrl(HttpUrl.Builder httpUrlBuilder, Request.Builder requestBuilder, Map<String, String> paramsMap) {
        if (paramsMap.size() > 0) {
            Iterator iterator = paramsMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                httpUrlBuilder.addQueryParameter((String) entry.getKey(), (String) entry.getValue());
            }
            requestBuilder.url(httpUrlBuilder.build());
            return requestBuilder.build();
        }

        return null;
    }

    private static String bodyToString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }

    public static class Builder {

        BasicParamsInterceptor interceptor;

        public Builder() {
            interceptor = new BasicParamsInterceptor();
        }

        public Builder addParam(String key, String value) {
            interceptor.paramsMap.put(key, value);
            return this;
        }

        public Builder addParamsMap(Map<String, String> paramsMap) {
            interceptor.paramsMap.putAll(paramsMap);
            return this;
        }

        public Builder addHeaderParam(String key, String value) {
            interceptor.headerParamsMap.put(key, value);
            return this;
        }

        public Builder addHeaderParamsMap(Map<String, String> headerParamsMap) {
            interceptor.headerParamsMap.putAll(headerParamsMap);
            return this;
        }

        public Builder addHeaderLine(String headerLine) {
            int index = headerLine.indexOf(":");
            if (index == -1) {
                throw new IllegalArgumentException("Unexpected header: " + headerLine);
            }
            interceptor.headerLinesList.add(headerLine);
            return this;
        }

        public Builder addHeaderLinesList(List<String> headerLinesList) {
            for (String headerLine : headerLinesList) {
                int index = headerLine.indexOf(":");
                if (index == -1) {
                    throw new IllegalArgumentException("Unexpected header: " + headerLine);
                }
                interceptor.headerLinesList.add(headerLine);
            }
            return this;
        }

        public Builder addQueryParam(String key, String value) {
            interceptor.queryParamsMap.put(key, value);
            return this;
        }

        public Builder addQueryParamsMap(Map<String, String> queryParamsMap) {
            interceptor.queryParamsMap.putAll(queryParamsMap);
            return this;
        }

        public BasicParamsInterceptor build() {
            return interceptor;
        }

    }
}
