package com.risk.biz.credit.impl;

/**
 * Created by zhenge.feng.
 */
public class ReturnDataTest {
    public static String morePersonInfo() {

        String morePersonInfo = "{\"sorgseq\":\"\",\"status\":\"1\",\"data\":{\"birthday\":\"1986-04-06\",\"idCard\":\"411422198604060084\",\"verify\":\"一致\",\"nativePlace\":\"河南省商丘地区睢县\",\"issuingArea\":\"\",\"education\":\"大学毕业\",\"maritalStatus\":\"10\",\"photo\":\"\",\"birthPlace\":\"河南省商丘地区睢县\",\"nation\":\"汉族\",\"formerName\":\"宋海杰\",\"address\":\"城关镇\",\"sexId\":\"2\",\"name\":\"宋捷\",\"company\":\"运管所\"},\"success\":true}\n";
        //String ss ="{\"sorgseq\":\"\",\"status\":\"1\",\"data\":{\"addressInput\":\"\",\"corpName\":\"曹乃瑄\",\"areaCode\":\"上海\",\"nameInput\":\"\",\"telNum\":\"02163268716\",\"corpTel\":\"02163268716\",\"corpAddress\":\"重庆南路229弄7号1号楼171室\"},\"success\":true}\n";
        return morePersonInfo;
    }

    public static String personGongShanFaInfo() {
        String personGongShanFaInfo = "{\"sorgseq\":\"\",\"status\":\"1\",\"data\":{\"addressInput\":\"\",\"corpName\":\"曹乃瑄\",\"areaCode\":\"上海\",\"nameInput\":\"\",\"telNum\":\"02163268716\",\"corpTel\":\"02163268716\",\"corpAddress\":\"重庆南路229弄7号1号楼171室\"},\"success\":true}\n";
        return personGongShanFaInfo;
    }

    public static String sheSuHuiZong() {
        String sheSuHuiZong = "{\"status\":\"2\",\"data\":{\"ktgg\":0,\"totalNum\":0,\"ajlc\":0,\"wdhmd\":0,\"cpws\":0,\"zxgg\":0,\"fygg\":0,\"sxgg\":0},\"success\":true}";
        return sheSuHuiZong;
    }

    public static String sheSuFengxianZhaiYao() {
        String sheSuFengxianZhaiYao = "{\"status\":\"2\",\"data\":{\"fyggList\":[],\"ktggList\":[],\"sxggList\":[],\"zxggList\":[],\"wdhmdList\":[],\"ajlcList\":[],\"cpwsList\":[]},\"success\":true}";
        return sheSuFengxianZhaiYao;
    }

    public static String zhiYeZiGe() {
        String zhiYeZiGe = "{\"sorgseq\":\"\",\"status\":\"2\",\"data\":{\"certificateList\":[]},\"success\":true}";
        return zhiYeZiGe;
    }

}
