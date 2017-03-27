<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
</head>
<jsp:include page="../common/common.jsp"></jsp:include>
<body>
<div class="black-bg"></div>

<!--新增系统用户弹窗-->
<div class="popup" style="display: none;">
    <img src="images/popup-close.png" class="popup-close" />
    <h2 class="pop-title">新增系统用户</h2>
    <form class="form-import popup-form-import">
        <div class="form-box">
            <p><label>用户名</label><input type="text" /></p>
            <p><label>姓名</label><input type="text" /></p>
        </div>
        <div class="form-box">
            <p><label>手机号</label><input type="tel" /></p>
            <p><label>邮箱</label><input type="email" /></p>
        </div>
        <div class="form-box">
            <p><label>所属公司</label>
                <select>
                    <option>江苏悦达2</option>
                    <option>江苏悦达3</option>
                    <option>江苏悦达5</option>
                </select>
            </p>
            <p><label>角色</label>
                <select>
                    <option>江苏悦达2</option>
                    <option>江苏悦达3</option>
                    <option>江苏悦达5</option>
                </select>
            </p>
        </div>
        <div class="form-box">
            <p><label>初始密码</label><input type="password" /></p>
            <p><label>确认密码</label><input type="password" /></p>
        </div>
        <p><button class="form-button">保存</button></p>
    </form>
</div>



<!--修改用户弹窗-->
<div class="popup">
    <img src="${basePath}/resources/images/popup-close.png" class="popup-close" />
    <h2 class="pop-title">重置用户密码</h2>
    <form class="form-import popup-form-import">
        <div class="form-box">
            <p class="mt15"><label>用户名</label><span>jsjjsjjsj</span></p>
            <p><label>姓名</label><input type="text" /></p>
        </div>
        <div class="form-box">
            <p><label>手机号</label><input type="tel" /></p>
            <p><label>邮箱</label><input type="email" /></p>
        </div>
        <p><button class="form-button">保存</button></p>
    </form>
</div>
</body>
</html>