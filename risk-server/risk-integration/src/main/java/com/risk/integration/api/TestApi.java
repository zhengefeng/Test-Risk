package com.risk.integration.api;

import org.apache.commons.io.FileUtils;

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
import java.text.SimpleDateFormat;
import java.util.*;

public class TestApi {


    //    final static private String apiURL = "http://localhost:8080/cpcs/api/v1/";
    final static private String apiURL = "https://test.suanhua.org/cpcs/api/v1/";//接口地址
//    final static private String apiURL2 = "http://localhost:8080/cpcs/api/v2/";//接口地址
//    final static private String apiURL2 = "http://188.188.42.165:8080/cpcs/api/v2/";

    //    final static private String apiURL2 = "https://uat.suanhua.org/cpcs/api/v2/";//接口地址
//    final static private String apiURL2 = "https://test.suanhua.org/cpcs/api/v2/";//接口地址
//    final static private String apiURL2 = "https://test.suanhua.org/cpcs/api/v2/";
    final static private String apiURL2 = "https://www.suanhua.org/cpcs/api/v2/";


    final static private String fileDir = "D:/project/suanhua/suanhua_doc/B端系统/机构外部接口/";
    private static String charset = "utf-8";

    final static private String orgSecretKey = "21PnLlCOG4ijTCt";//机构API私钥 co0Pq1v1Zp2P4MI  21PnLlCOG4ijTCt
    final static private String orgcode = "20310115201601001";//机构号 20310103201608001  20310115201601001

    final static private String certtype = "0";

    final static private String name = "XXX";
    final static private String certno = "XXXXX";
    final static private String sreason = "01";
    final static private String query = "1";

    private static String saccount = "T1234567890";

    public static void main(String[] args)throws Throwable {
//        for(String api:"2000,9001,6003".split(",")) {
//            testAPI(api);
//        }

//        testSHShare();
//        testSpecTradeQ();
//        testPersonCreditQ();
//        testQueryRecordQ();


//        testCreditReport();
//        testCreditBatch();
//        testCreditBatchQeruy();
//        testMsgUpload();
//        testMsgUploadQuery();
//        testWarning();
//        download("https://test.suanhua.org/cpcs/api/datasubmit/message/feedback/99370801201509001/993708012015090012015110351.zip/be09db11026211c6ee7c2f5c4ecab14c", null, "d://test.xls");
//        testPush();
//        testPbccrcQ();
        test2000();
//      test2001();
//        test2003();
//       test3001();
//        test3003();
//        test3004();
//        test3005();
//        test4001();
//        test4013();
//        test1001();
//        testM001();
//        testA002();
//        test1000();
//        test6002();
//        test6003();
//        test5003();
//        testCreditQuery();
//        testSpectradeQuery();
//          test8002();
//        test3007();


    }

    private static void test6003() {
        String url = apiURL2 + "channel/6003";
        Map<String,String> params = new TreeMap<>();
        params.put("sorgcode",orgcode);
        params.put("name","冯振阁");
        params.put("idCard","411422198705083330");
        hash(params);
        String result = sendPost(url,params,"utf-8");
        System.out.println(result);

    }

    private static void test3007() {
        String url = apiURL2 + "channel/3007";
        Map<String,String> params = new TreeMap<>();
        params.put("sorgcode",orgcode);
        params.put("name","冯振阁");
        params.put("idCard","411422198705083330");
        hash(params);
        System.out.println(url);
        System.out.println(params.toString());
        String result = sendPost(url,params,"utf-8");
        System.out.println(result);
    }

    private static void test8002() {
        String url = apiURL2 + "channel/8002";
        Map<String,String> params = new TreeMap<>();
        params.put("sorgcode",orgcode);
        params.put("mobileNum","15618605101");
        hash(params);
        System.out.println(url);
        System.out.println(params.toString());
        String result = sendPost(url,params,"utf-8");
        System.out.println(result);
    }

    private static void testSpectradeQuery() {
        String url = apiURL2+"spectrade/query";
        Map<String,String> params = new TreeMap<>();
        params.put("sorgcode",orgcode);
        params.put("name","冯振阁");
        params.put("certtype","0");
        params.put("idCard","411422198705083330");
        params.put("sreason","01");
        params.put("query","0");
        hash(params);
        System.out.println(url);
        System.out.println(params.toString());
        String result = sendPost(url,params,"utf-8");
        System.out.println(result);
    }

    private static void testCreditQuery() {
        String url = apiURL2+"credit/query";
        Map<String,String> params = new TreeMap<>();
        params.put("sorgcode",orgcode);
        params.put("name","冯振阁");
        params.put("certtype","0");
        params.put("idCard","411422198705083330");
        hash(params);
        System.out.println(url);
        System.out.println(params.toString());
        String result = sendPost(url,params,"utf-8");
        System.out.println(result);
    }

    private static void test5003() {
        String url = apiURL2+"channel/5001";
        Map<String,String> params = new TreeMap<>();
        params.put("sorgcode",orgcode);
        params.put("name","冯振阁");
        params.put("idCard","411422198705083330");
        params.put("cardNum","6212251001000620111");
        params.put("mobileNum","15618705101");
        hash(params);
        System.out.println(url);
        System.out.println(params.toString());
        String result = sendPost(url,params,"utf-8");
        System.out.println(result);
    }

    private static void test6002() {
        String url = apiURL2+"channel/6003";
        Map<String,String> params = new TreeMap<>();
        params.put("sorgcode",orgcode);
        params.put("name","冯振阁");
        params.put("idCard","411422198705083330");
        hash(params);
        System.out.println(url);
        System.out.println(params.toString());
        String result = sendPost(url,params,"utf-8");
        System.out.println(result);
    }

    private static void test3005() {
        String url = apiURL2+"channel/3005";
        Map<String,String> params = new TreeMap<>();
        params.put("sorgcode",orgcode);
        params.put("name","冯振阁");
        params.put("idCard","411422198705083330");
        params.put("mobileNum","15618705101");
        hash(params);
        System.out.println(url);
        System.out.println(params.toString());
        String result = sendPost(url,params,"utf-8");
        System.out.println(result);
    }

    private static void test1000() {
        String url = apiURL2+"channel/1000";
        Map<String,String> params = new TreeMap<>();
        params.put("sorgcode",orgcode);
        params.put("name","冯振阁");
        params.put("cardNum","6212251001000620111");
        hash(params);
        System.out.println(url);
        System.out.println(params.toString());
        String result = sendPost(url,params,"utf-8");
        System.out.println(result);
    }

    private static void testA002() {
        String url = apiURL2+"channel/A002";
        Map<String,String> params = new TreeMap<>();
        params.put("sorgcode",orgcode);
        params.put("drivingNo","41142219870508333");
        hash(params);
        System.out.println(url);
        System.out.println(params.toString());
        String result = sendPost(url,params,"utf-8");
        System.out.println(result);
    }

    private static void testM001() {
        String url = apiURL2+"channel/M002";
        Map<String,String> params = new TreeMap<>();
        params.put("sorgcode",orgcode);
        params.put("sorgseq","");
        params.put("mobileNum","13323705779");
        hash(params);
        System.out.println(url);
        System.out.println(params.toString());
        String result = sendPost(url,params,"utf-8");
        System.out.println(result);

    }

    private static void test1001() {
        String url = apiURL2+"channel/1001";
        Map<String,String> params = new TreeMap<>();
        params.put("sorgcode",orgcode);
        params.put("sorgseq","");
        params.put("name","冯振阁");
        params.put("idCard","411422198705083330");
        params.put("cardNum","6212251001000620111");
        params.put("mobileNum","15618705101");

        hash(params);
        System.out.println(url);
        System.out.println(params.toString());
        String result = sendPost(url,params,"utf-8");
        System.out.println(result);
    }

    private static void test4013() {
        String url = apiURL2 +"channel/4013";
        Map<String,String> params = new TreeMap<>();
        params.put("sorgcode",orgcode);
        params.put("sorgseq","");
        params.put("compNameOrNo","上海欣亨金融信息服务有限公司");
        hash(params);
        System.out.println(url);
        System.out.println(params.toString());
        String result = sendPost(url,params,"utf-8");
        System.out.println(result);
    }

    private static void test4001() {
        String url = apiURL2 +"channel/4001";
        Map<String,String> params = new TreeMap<>();
        params.put("sorgcode",orgcode);
        params.put("sorgseq","");
        params.put("name","曹乃瑄");
        params.put("idCard","411422198705083330");
        params.put("keyType","gd");
        hash(params);
        System.out.println(url);
        System.out.println(params.toString());
        String result = sendPost(url,params,"utf-8");
        System.out.println(result);
    }

    private static void test3004() {
        String url = apiURL2 +"channel/3004";
        Map<String,String> params = new TreeMap<>();
        params.put("sorgcode",orgcode);
        params.put("sorgseq","");
        params.put("name","曹乃瑄");
        params.put("idCard","411422198705083330");
        params.put("telephone","02163268716");
        hash(params);
        System.out.println(url);
        System.out.println(params.toString());
        String result = sendPost(url,params,"utf-8");
        System.out.println(result);
    }


    private static void test3003(){
        String url = apiURL2 +"channel/3003";
        Map<String,String> params = new TreeMap<>();
        params.put("sorgcode",orgcode);
        params.put("sorgseq","");
        params.put("name","冯振阁");
        params.put("idCard","411422198705083330");
        hash(params);
        System.out.println(url);
        System.out.println(params.toString());
        String result = sendPost(url,params,"utf-8");
        System.out.println(result);



    }


    private static void test3001(){
        String url = apiURL2 +"channel/3001";
        Map<String,String> params = new TreeMap<>();
        params.put("sorgcode",orgcode);
        params.put("sorgseq","");
        params.put("name","冯振阁");
        params.put("idCard","411422198705083330");
        hash(params);
        System.out.println(url);
        System.out.println(params.toString());
        String result = sendPost(url,params,"utf-8");
        System.out.println(result);
    }

    private static void test2001() {
        String url = apiURL2 +"channel/2001";
        Map<String,String> params = new TreeMap<>();
        params.put("sorgcode",orgcode);
        params.put("sorgseq","");
        params.put("name","冯振阁");
        params.put("idCard","411422198705083330");
        hash(params);
        System.out.println(url);
        System.out.println(params.toString());
        String result = sendPost(url,params,"utf-8");
        System.out.println(result);
    }

    static public void test2000(){
        String url = apiURL2 + "channel/2000";
        Map<String,String> param = new TreeMap<>();
        param.put("sorgcode",orgcode);
        param.put("sorgseq","");
        param.put("name","冯振阁");
        param.put("idCard","411422198705083330");
        hash(param);
        System.out.println(url);
        System.out.println(param.toString());
        String result = sendPost(url,param,"utf-8");
        System.out.println(result);


    }
    public static  void test2003(){
        String url = apiURL2 + "channel/2003";
        Map<String,String> param = new TreeMap<>();
        param.put("sorgcode",orgcode);
        param.put("sorgseq","111");
        param.put("name","冯振阁");
        param.put("idCard","411422198705083330");
        hash(param);
        System.out.println(url);
        System.out.println(param.toString());
        String result = sendPost(url,param,"utf-8");
        System.out.println(result);
    }

    static public void testPbccrcQ() {
        String url = apiURL2 + "pbccrc/report";
        Map<String, String> param = new TreeMap<String, String>();
        param.put("orgcode", orgcode);
        param.put("name", "");
        param.put("idCard", "");
        hash(param);
        System.out.println(url);
        System.out.println(param.toString());
        String result = sendPost(url, param, "utf-8");
        System.out.println(result);
    }


    //异常交易查询
    static void testSpecTradeQ() throws IOException {
        String url = apiURL2 + "spectrade/query/";
        Map<String, String> param = new TreeMap<String, String>();
        param.put("sorgcode", orgcode);
        param.put("name", name);
        param.put("certtype", certtype);
        param.put("certno", certno);
        param.put("sreason", sreason);
        param.put("query", query);
        hash(param);
        System.out.println(url);
        System.out.println(param.toString());
        String result = sendPost(url, param, "utf-8");
        System.out.println(result);

        return;
    }

    //信贷信息查询
    static void testPersonCreditQ() throws IOException {
        String url = apiURL2 + "credit/query";
        Map<String, String> param = new TreeMap<String, String>();
        param.put("sorgcode", orgcode);
        param.put("saccount", saccount);
        param.put("name", name);
        param.put("certtype", certtype);
        param.put("certno", certno);
        param.put("sreason", sreason);
        hash(param);
        System.out.println(url);
        System.out.println(param.toString());
        String result = sendPost(url, param, "utf-8");
        System.out.println(result);
        return;
    }

    //查询记录查询
    static void testSHShare() throws IOException {
        String url = apiURL2 + "shshare/query";
        Map<String, String> param = new TreeMap<String, String>();
        param.put("sorgcode", orgcode);
        param.put("name", name);
        param.put("certtype", certtype);
        param.put("certno", certno);
        hash(param);
        System.out.println(url);
        System.out.println(param.toString());
        String result = sendPost(url, param, "utf-8");
        System.out.println(result);
        return;
    }

    //查询记录查询
    static void testQueryRecordQ() throws IOException {
        String url = apiURL2 + "qrecord";
        Map<String, String> param = new TreeMap<String, String>();
        param.put("sorgcode", orgcode);
        param.put("name", name);
        param.put("certtype", certtype);
        param.put("certno", certno);
        hash(param);
        System.out.println(url);
        System.out.println(param.toString());
        String result = sendPost(url, param, "utf-8");
        System.out.println(result);
        return;
    }

    static void testPush() throws IOException {
        String url = "http://localhost:8080/cpcs/api/data/push/pbccrc";
        Map<String, String> param = new TreeMap<String, String>();
        param.put("orgcode", orgcode);
        param.put("data", "周立");
        param.put("hash", md5("eebf8a561e7c69dddd0acca0695320a8" + new Date().getYear() +
                param.get("data") + param.get("orgcode"), "UTF-8"));
        System.out.println(url + " " + param.toString());
        String result = sendPost(url, param, "UTF-8");
        System.out.println(result);
        return;
    }

    static void testAPI(String apicode) throws IOException {
        String url = apiURL2 + "channel/" + apicode;
        Map<String, String> param = new TreeMap<String, String>();
        param.put("sorgcode", orgcode);
        param.put("name", name);
        param.put("cardNum", "6770986465748335");
        param.put("idCard", certno);
        //param.put("compName", "融通汇信（北京）信息咨询有限公司");
        if("6003".equals(apicode)) {
            param.put("caseType", "ktgg");
            param.put("caseId", "AVBubHkZAzwuYsHSFCQ8");
        }
        if("9001".equals(apicode)) {
            param.put("address", "上海市宝山区行知路638弄");
        }
        hash(param);
        System.out.println(url + " " + param.toString());
        String result = sendPost(url, param, "UTF-8");
        System.out.println(result);
        return;
    }


    //单笔信用报告查询
    static void testCreditReport() {

        String url = apiURL + "creditreport/person";

        Map<String, String> param = new TreeMap<String, String>();

//        param.put("sorgcode", orgcode);
        param.put("iplateid", "110");
        param.put("scerttype", "0");
        param.put("scertno", "");
        param.put("sname", "");
        param.put("sreason", "01");
        hash(param);
        String result = sendPost(url, param, "UTF-8");
        System.out.println(result);
        return;
    }

    //批量信用报告查询
    static void testCreditBatch() throws IOException {

        String url = apiURL + "creditreport/person/batch";

        Map<String, String> param = new TreeMap<String, String>();
        param.put("sorgcode", orgcode);
        param.put("filename", "993708012015090012015091600200.txt");
        param.put("filebuff", byts2hexstr(FileUtils.readFileToByteArray(new File(fileDir + "993708012015090012015091600200.txt"))));
        hash(param);
        String result = sendPost(url, param, "UTF-8");
        System.out.println(result);
        return;
    }

    //批量信用报告查询状态查询
    static void testCreditBatchQeruy() throws IOException {

        String url = apiURL + "creditreport/person/batch/feedback";
        Map<String, String> param = new TreeMap<String, String>();
        param.put("sorgcode", orgcode);
        param.put("filename", "993708012015090012015091600200.txt");
        hash(param);
        String result = sendPost(url, param, "UTF-8");
        System.out.println(result);
        return;
    }

    //标准报文上送
    static void testMsgUpload() throws IOException {

        String url = apiURL + "datasubmit/message";
        Map<String, String> param = new TreeMap<String, String>();
        param.put("sorgcode", orgcode);
        param.put("filename", "993708012015090012015110321.zip");
        param.put("filebuff", byts2hexstr(FileUtils.readFileToByteArray(new File(fileDir + "993708012015090012015110321.zip"))));
        hash(param);
        String result = sendPost(url, param, "UTF-8");
        System.out.println(result);
        return;
    }

    //标准报文上送状态查询
    static void testMsgUploadQuery() throws IOException {

        String url = apiURL + "datasubmit/message/feedback";
        Map<String, String> param = new TreeMap<String, String>();
        param.put("sorgcode", orgcode);
        param.put("filename", "993708012015090012015090321.zip");
        hash(param);

        String result = sendPost(url, param, "UTF-8");
        System.out.println(result);
        return;
    }

    //报警想信息查询
    static void testWarning() throws IOException {
        String url = apiURL + "warning/has";
        Map<String, String> param = new TreeMap<String, String>();
        param.put("sorgcode", orgcode);
        hash(param);
        String result = sendPost(url, param, "UTF-8");
        System.out.println(result);
        return;
    }


    static private String getSeq() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date today = new Date();
        return sdf.format(today) + today.getTime();
    }

    static private void hash(Map<String, String> param) {
        //param.put("sorgseq", getSeq());
        StringBuilder sb = new StringBuilder();
        Iterator iterator = param.keySet().iterator();
        while (iterator.hasNext()) {
            sb.append(param.get(iterator.next()));
        }
        param.put("hash", md5(sb.toString() + orgSecretKey, "UTF-8").toUpperCase());
    }

    static private String md5(String msg, String charset) {
        try {
            System.out.println("md5Src:" + msg);
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] hashedBytes = digest.digest(msg.getBytes(charset));
            String rst = byts2hexstr(hashedBytes);
            System.out.println("md5:" + rst.toUpperCase());
            return rst;
        } catch (NoSuchAlgorithmException   nex) {
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

    static public byte[] download(String url, Map<String, String> param, String savePath) {
        OutputStream out = null;
        InputStream in = null;
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
            if (p != null) {
                // 发送请求参数
                out.write(p.getBytes());
                // flush输出流的缓冲
                out.flush();
            }
            //读取响应数据
            in = conn.getInputStream();
            byte[] buff = new byte[1024];
            ByteArrayOutputStream baot = new ByteArrayOutputStream();
            int len;
            while ((len = in.read(buff)) != -1) {
                baot.write(buff, 0, len);
            }
            if (savePath != null) {//保存文件
                FileOutputStream fo = new FileOutputStream(savePath);
                fo.write(baot.toByteArray());
                fo.close();
            }
            return baot.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
        return null;
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

}
