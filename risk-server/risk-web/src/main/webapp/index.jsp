<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <title>征信登录页</title>
    <style type="text/css">
        body {
            background: url(/resources/images/login_bg.jpg) fixed center center no-repeat;
            background-size: auto 100%;
        }
        .login_content {
            position: absolute;
            height: 100%;
            width: 1180px;
            top: 0;
            left: 50%;
            margin-left: -590px;
        }
        .login_content h1 {
            position: absolute;
            width: 111px;
            height: 75px;
            top: 90px;
            left: 0;
            text-indent: -9999px;
            background: url(/resources//resources/images/logo_index.png) center center no-repeat;
            background-size: 100% 100%;
        }
        .login_enter {
            position: absolute;
            width: 620px;
            padding: 30px;
            top: 25%;
            left: 50%;
            margin-left: -340px;
            background: url(/resources/images/login_bg_center.png) repeat;/* 中间透明背景 */
            z-index: 8888;
        }
        .login_enter .left {
            float: left;
            width: 310px;
            border-right: 1px solid #e8e8e8;
        }
        .login_enter .right {
            float: left;
            width: 300px;
        }
        .left .p1 {
            width: 280px;
            height: 30px;
            margin-bottom: 40px;
            font-size: 18px;
            font-weight: bold;
            color: #002f59;
            text-align: left;
            border-bottom: 2px solid #E3E3E3;
        }
        .inst {
            margin-bottom: 20px;
            font-size: 14px;
            color: #414e5e;
        }
        .inst input {
            display: inline-block;
            width: 218px;
            height: 40px;
            border: 1px solid #dddddd;
            text-indent: 10px;
            outline: none;
            line-height: 40px;
            background: #f9f9f9;
        }
        .left .inst-special {
            margin-bottom: 0;
        }
        .left .inst-special  input {
            width: 120px;
            margin-right: 5px;
        }
        .left .inst-special img {
            display: inline-block;
            vertical-align: bottom;
        }
        .left .inst-special .change {
            display: inline-block;
            margin-left: 60px;
            font-size: 16px;
            line-height: 30px;
            color: #073b63;
        }
        .inst .err_tips {
            color: #ed0101;
            line-height: 30px;
            font-size: 12px;
            margin-left: 60px;
        }
        .left .inst-special .input_again {
            text-align: right;
            margin-right: 28px;
            overflow: hidden;
        }
        .inst-special .input_again .err_tips {
            text-align: left;
            float: left;
        }
        .left button {
            display: block;
            width: 280px;
            height: 50px;
            line-height: 50px;
            text-align: center;
            margin: 20px auto;
            background-color: #002f59;
            color: #fff;
            font-size: 18px;
            font-weight: bold;
        }
        .left .forget_pass {
            text-align: right;
            margin-right: 15px;
            color: #073b63;
        }
        .right .title {
            font-size: 22px;
            color: #333;
            text-align: center;
            font-family: "宋体";
            margin-top: 65px;
            letter-spacing: 2px;
            font-weight: bold;
        }
        .right img {
            display: block;
            margin: 40px auto;
        }
        .public_footer {
            position: absolute;
            height: 75px;
            width: 100%;
            bottom: 0;
            right: 0;
            left: 0;
            padding-top: 25px;
            color: #fff;
            font-size: 12px;
            background: #002f59;
            z-index: 999;
        }

        .public_footer p{
            text-align: center;

            margin: 0 auto;
        }
        .black-bg {
            width: 100%;
            background-color: #000;
            height: 100%;
            left: 0;
            top: 0;
            clear: both;
            position: fixed;
            opacity: 0.8;
            z-index: 9998;
        }
        .popup {
            background-color: #fff;
            width: 544px;
            height: 336px;
            position: fixed;
            top: 40%;
            margin-top: -168px;
            left: 50%;
            margin-left: -272px;
            border-radius: 5px;
            z-index: 9999;
            padding: 30px 20px;
            border: 1px solid #A6A6A6;
        }
        .popup p {
            font-size: 18px;
            margin-top: 50px;
            text-align: center;
            line-height: 30px;
        }
        .popup-close {
            position: absolute;
            right: 15px;
            top: 15px;
        }
    </style>
</head>
<body>


<div class="login_content">

    <!--  ------------------------>
    <h1>全民财富征信系统</h1>
    <div class="login_enter">

        <div class="left">
            <p class="p1">登录</p>

            <div class="inst">
                <label for="username">用户名：</label>
                <input type="text"id="username"placeholder="请输入用户名"class="required"/>
                <p  class="err_tips"style="display:block;">请输入用户名</p>
            </div>

            <div class="inst">
                <label for="pass1">密 &nbsp 码：</label>
                <input type="password"id="pass1"placeholder="6-20位数字，字母"class="required"/>
                <p  class="err_tips"style="display:block;">请输入用户名密码</p>

            </div>

            <div class="inst inst-special">
                <label for="yanzheng">验证码：</label>
                <input type="password"id="yanzheng"placeholder="图形验证码"class="required"/>
                <img src="/resources/images/code_yz.png"height="42"width="88">
                <p class="input_again">
                    <span  class="err_tips"style="display:block;">请输入图片中的验证码</span>
                    <span  class="change">换一个</span>
                </p>
            </div>

            <button>登录</button>
            <p class="forget_pass">忘记密码或申请账号</p>


        </div>

        <div class="right">
            <p class="title">全民财富征信系统</p>
            <img src="/resources/images/check.png"height="25"width="154">
        </div>

    </div>
    <!-- ------------------ -->
</div>


<div class="public_footer">
    <p>版权所有&nbsp&nbsp上海欣亨金融信息服务有限公司&nbsp&nbsp沪ICP备&nbsp&nbsp15000682号-1</p>
</div>

<!-- 遮罩 -->
<div class="black-bg"style="display:none"id="blackbg" onclick="closePop()"></div>

<!-- 去登录 -->
<div class="popup"style="display:none" id="tips">
    <img src="/resources/images/popup-close.png" width="13" height="13" class="popup-close" onclick="closePop()"/>
    <img src="/resources/images/tip.png" height="64" width="64"/ style="display:block; margin:20px auto;">

    <p>如您忘记密码或者需要申请新系统账号<br>请联系公司系统管理员</p>

</div>

<script type="text/javascript">
    //弹窗
    function closePop() {
        $('#blackbg').hide();
        $('.popup').hide();
    }

    function openPop(id) {
        $('#blackbg').show();
        $('#' + id).show();

    }

    $(document).ready(function() {
        var a = document.documentElement.clientHeight;
        //alert(a);
        if (parseInt(a) < 750) {
            $(".login_enter").css("top", "20%");
            $(".public_footer").css("height","50px");
            $(".login_content h1").css("top","50px");
        }
        //   if (parseInt(a) <645) {            
        //     $(".public_footer").css("display","none");            
        // }

        $(".forget_pass").click(function(event) {
            openPop("tips");
        });

    });
</script>

</body>
</html>