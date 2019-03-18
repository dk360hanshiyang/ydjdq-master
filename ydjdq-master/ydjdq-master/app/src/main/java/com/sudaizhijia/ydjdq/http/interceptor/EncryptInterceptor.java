package com.sudaizhijia.ydjdq.http.interceptor;

import com.sudaizhijia.ydjdq.http.encryptutil.AESCipher;
import com.sudaizhijia.ydjdq.http.encryptutil.RSA;
import com.sudaizhijia.ydjdq.http.encryptutil.RandomUtil;
import com.sudaizhijia.ydjdq.utils.LogUtils;
import com.sudaizhijia.ydjdq.utils.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * Author: 王强
 * Version:  1.0
 * Date:    2017/9/6
 * Modify:
 * Description: Application
 * Copyright notice: 北京周周网络科技有限公司
 */

public class EncryptInterceptor implements Interceptor {
    public static final String TAG = "OkHttpUtils";
    public static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDLfTRhBrokOi1Wj+1hbKR0mtUT" +
            "aOBLvAw5wAZz3H5xHG9eBl/c/lRulxDOSHkLVyWb1FYkTexJSxRc20ZtuGEjnvt+" +
            "AtHXQxXssX8Rlly/KcGd7BFzNMgbaMnMvTTrW+UmFinmZ5CD5JkgrTDTwR7SM1cn" +
            "fAqv/SlC11QxWUDfewIDAQAB";

//    public static final String privateKey="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMt9NGEGuiQ6LVaP" +
//            "7WFspHSa1RNo4Eu8DDnABnPcfnEcb14GX9z+VG6XEM5IeQtXJZvUViRN7ElLFFzb" +
//            "Rm24YSOe+34C0ddDFeyxfxGWXL8pwZ3sEXM0yBtoycy9NOtb5SYWKeZnkIPkmSCt" +
//            "MNPBHtIzVyd8Cq/9KULXVDFZQN97AgMBAAECgYEAixYSRjtt4bMuKBuKWmwC4Hyw" +
//            "JWsq3Dk1dgetoWXVuwR/jpn2zju8hDaXUxgwPDMdzqxNENV+Kv65dVqfggFjytf6" +
//            "uK+K/LcvIsozDkrpl5V1L8KLA84mx+ahgyhCEhPP5VNfGIRXLldwdyvtRyE8uyC1" +
//            "RSV1g1DoCXBYKTDosOkCQQDskx5jgFuzeuZU+MMFCZC+kIgaEuEd+bhar9hsZSLA" +
//            "hOAQ09WUt6YZqzIaSIQkFJ5HxmCcflJlFTror1AUgdclAkEA3DKdeqol8diQNBYz" +
//            "PTUm+7qrt/Pqgmo0Ovj8dfOet5uiNmQEOD+t/sgy0bksibrcRgq78S++wEZmfTjm" +
//            "LWDqHwJBAMWaeRaZf38iF8Q/6P2LKNjT9qr4vAqCrKcrHDYmH+n40wObPVo0L8xe" +
//            "/8GOcrmEc1T2cXol1YLTQdpbnSMT9PUCQHqoDyS3Bq/y7FC3VQ9xPifW0bSEQEsp" +
//            "EbMP4sFpVS39mZwmllsmzaswpW5Bcde+qNizPgGZkO3VyV1ThpQceg0CQA+KqArz" +
//            "7RZHcawZf0spo7j7Hi+6SOVoD1UwSKfO2Q0AwZ+dxBdGk8MbI4yKIFGDMj9/mDXK" +
//            "N4G8dInIuBeJRV0=";

    public EncryptInterceptor() {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HashMap<String, String> headerMap = encryptRequest(request);
        Response response = chain.proceed(addHeader(request, headerMap));
        return logForResponse(response);
    }

    /**
     * 对请求进行加密
     *
     * @param request
     */
    private HashMap<String, String> encryptRequest(Request request) {
        String requestContent = null;
        HashMap<String, String> headers = new HashMap<>();
        try {
            String url = request.url().toString();
            if (request.method().equals("GET")) {
                //get请求
                requestContent = url.substring(url.indexOf("?") + 1);
            } else if (request.body() != null && request.body().contentType().type().equals("multipart")) {
                //post文件
                requestContent = url.substring(url.indexOf("?") + 1);
            } else {
                //form请求
                RequestBody requestBody = request.body();
                if (requestBody != null) {
                    MediaType mediaType = requestBody.contentType();
                    if (mediaType != null && isText(mediaType)) {
                        requestContent = bodyToString(request);
                    } else {
                        LogUtils.e("mediaType为null或者为未知type,未进行加密  url:" + url);
                    }
                }
            }
            if (requestContent.contains("addressBookList")) {
                requestContent = requestContent.substring(0, requestContent.indexOf("addressBookList") - 1);
            }
            if (requestContent.contains("appList")) {//去掉appList的加密验证
                int start = requestContent.indexOf("appList");
                int end = requestContent.indexOf("&", start);
                requestContent = requestContent.substring(0, requestContent.indexOf("appList") - 1) + requestContent.substring(end, requestContent.length());
            }
            headers = encrypt(requestContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return headers;
    }

    private HashMap<String, String> encrypt(String requestContent) throws Exception {
        HashMap<String, String> headers = new HashMap<>();
        if (StringUtils.isEmpty(requestContent)) {
            return headers;
        }
        //生成16位字母或者数字字符串,用rsa加密
        String apiKey = RandomUtil.getRandom(16);
        String apiKeyEnc = RSA.encrypt(apiKey, publicKey);
        String sign = AESCipher.aesEncryptString(requestContent, apiKey);
        headers.put("apiKey", apiKeyEnc);
        headers.put("sign", sign);
////        LogUtils1.i("jiami", "加密内容:"+requestContent);
//        LogUtils1.i("jiami", "原始apiKey:" + apiKeyEnc);
//        LogUtils1.i("jiami", "原始sign:" + sign);
//        LogUtils1.i("jiami", "解密apiKey:"+ RSA.decrypt(apiKeyEnc,privateKey));
//        LogUtils1.i("jiami", "解密内容:"+ AESCipher.aesDecryptString(sign,apiKey));
        return headers;
    }


    private Request addHeader(Request request, HashMap<String, String> headerParamsMap) {
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
        return requestBuilder.headers(headerBuilder.build()).build();
        // process header params end
    }

    private Response logForResponse(Response response) {
//        try
//        {
//            //===>response log
//            Log.i(tag, "========response'log=======");
//            Response.Builder builder = response.newBuilder();
//            Response clone = builder.build();
//            Log.i(tag, "url : " + clone.request().url());
//            Log.i(tag, "code : " + clone.code());
////            Log.i(tag, "protocol : " + clone.protocol());
//            if (!TextUtils.isEmpty(clone.message()))
//                Log.i(tag, "message : " + clone.message());
//
//            if (showResponse)
//            {
//                ResponseBody body = clone.body();
//                if (body != null)
//                {
//                    MediaType mediaType = body.contentType();
//                    if (mediaType != null)
//                    {
//                        Log.i(tag, "responseBody's contentType : " + mediaType.toString());
//                        if (isText(mediaType))
//                        {
//                            String resp = body.string();
//                            Log.i(tag, "responseBody's content : " + resp);
//
//                            body = ResponseBody.create(mediaType, resp);
//                            return response.newBuilder().body(body).build();
//                        } else
//                        {
////                            Log.i(tag, "responseBody's content : " + " maybe [file part] , too large too print , ignored!");
//                        }
//                    }
//                }
//            }
//
//            Log.i(tag, "========response'log=======end");
//        } catch (Exception e)
//        {
////            e.printStackTrace();
//        }

        return response;
    }

    private boolean isText(MediaType mediaType) {
//        Log.e(tag,mediaType.type()+"  "+mediaType.subtype());
        if (mediaType.type() != null && mediaType.type().equals("application")) {
            return true;
        }
        if (mediaType.subtype() != null) {
            if (mediaType.subtype().equals("json") ||
                    mediaType.subtype().equals("xml") ||
                    mediaType.subtype().equals("html") ||
                    mediaType.subtype().equals("application")
                    )
                return true;
        }
        return false;
    }

    private String bodyToString(final Request request) {
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "something error when show requestBody.";
        }
    }
}
