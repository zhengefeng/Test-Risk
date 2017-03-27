package com.risk.integration.util;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zhenge.feng.
 */
public class HttpPostUtil {
    private static String charset = "utf-8";
    private static String suanHuaOrgSecretKey;
    private static String suanHuaOrgCode;
    private static String suanHuaApiURL;

    public static String getHttpJsons(String interCode, TreeMap<String,String> params){
        String url = suanHuaApiURL +interCode;
        params.put("orgcode",suanHuaOrgCode);
        hash(params);
        String result = sendPost(url,params,"utf-8");
        return result;
    }

    static private void hash(Map<String, String> param) {
        //param.put("sorgseq", getSeq());
        StringBuilder sb = new StringBuilder();
        Iterator iterator = param.keySet().iterator();
        while (iterator.hasNext()) {
            sb.append(param.get(iterator.next()));
        }
        param.put("hash", md5(sb.toString() + suanHuaOrgSecretKey, "UTF-8").toUpperCase());
    }


    public static String sendPost(String url, Map<String, String> param, String charset) {
        OutputStream out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = getConnection(realUrl);

            Map<String, String> defaultHeaders = new LinkedHashMap<>();
            defaultHeaders.put("accept", "*/*");
            defaultHeaders.put("connection", "Keep-Alive");
            defaultHeaders.put("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = conn.getOutputStream();
            String p = buildParams(param, charset);
            if(p != null) {
                // 发送请求参数
                out.write(p.getBytes());
                // flush输出流的缓冲
                out.flush();
            }
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), charset));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    static private String md5(String msg, String charset) {
        try {
            System.out.println("md5Src:" + msg);
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] hashedBytes = digest.digest(msg.getBytes(charset));
            String rst = byts2hexstr(hashedBytes);
            System.out.println("md5:" + rst.toUpperCase());
            return rst;
        } catch (NoSuchAlgorithmException nex) {
            nex.printStackTrace();
        } catch (UnsupportedEncodingException uex) {
            uex.printStackTrace();
        }
        return "";
    }

    private static String byts2hexstr(byte[] arrayBytes) {
        StringBuilder sb = new StringBuilder();
        String tmp = null;
        for (int i = 0; i < arrayBytes.length; i++) {
            tmp = Integer.toHexString(arrayBytes[i] & 0xff);
            sb.append(tmp.length() == 1 ? "0" + tmp : tmp);
        }
        return sb.toString();
    }

    public static String buildParams(Map<String, String> param, String charset) {
        if (param != null && !param.isEmpty()) {
            StringBuffer buffer = new StringBuffer();
            for (Map.Entry<String, String> entry : param.entrySet()) {
                try {
                    buffer.append(entry.getKey()).append("=")
                            .append(URLEncoder.encode(entry.getValue(), charset))
                            .append("&");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            return buffer.deleteCharAt(buffer.length() - 1).toString();
        } else {
            return null;
        }
    }

    static public HttpURLConnection getConnection(URL url) {
        HttpURLConnection connection = null;
        try{
            if(url.getProtocol().toUpperCase().startsWith("HTTPS")) {
                SSLContext ctx = SSLContext.getInstance("SSL");
                ctx.init(new KeyManager[0], new TrustManager[] {new X509TrustManager() {

                    @Override
                    public void checkClientTrusted(X509Certificate[] arg0,
                                                   String arg1) throws CertificateException {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] arg0,
                                                   String arg1) throws CertificateException {
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                }}, new SecureRandom());


                HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
                conn.setSSLSocketFactory(ctx.getSocketFactory());
                conn.setConnectTimeout(10000);
                conn.setReadTimeout(40000);

                conn.setHostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                });

                connection = conn;
            } else {
                connection = (HttpURLConnection) url.openConnection();
            }


        } catch(Exception e){
            e.printStackTrace();
        }

        return connection;
    }

    public void setSuanHuaOrgSecretKey(String suanHuaOrgSecretKey) {
        HttpPostUtil.suanHuaOrgSecretKey = suanHuaOrgSecretKey;
    }

    public void setSuanHuaOrgCode(String suanHuaOrgCode) {
        HttpPostUtil.suanHuaOrgCode = suanHuaOrgCode;
    }

    public void setSuanHuaApiURL(String suanHuaApiURL) {
        HttpPostUtil.suanHuaApiURL = suanHuaApiURL;
    }
}
