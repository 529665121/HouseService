<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../css/index.css" rel="stylesheet" type="text/css">
<html>
<style type="text/css">
    <!--
    .STYLE1 {
        font-size: 24px;
        font-weight: bold;
    }

    -->
</style>
<head>
    <title>Untitled Document</title>
    <script type="text/javascript" src="../tdp/js/validator.js"></script>
    <script type="text/javascript" src="../tdp/js/public.js"></script>
    <script type="text/javascript" src="../javascript/handleArchive.js"></script>
    <script language="JavaScript">
        function doDBClick(url, operator, type) {
            if (operator == false) {
                document.forms[0].action = url + "&op=view";
                document.forms[0].submit();
            } else {
                document.forms[0].action = url;
                document.forms[0].submit();
            }
        }
    </script>
</head>

<body>

<table width="100%" border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" class="where">
    <tr>
        <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;系统管理--&gt;用户管理</td>
        <td align="right">&nbsp;</td>
    </tr>
</table>
<br/>
<br>
<form method="post" action="${pageContext.request.contextPath}/Homemaking/usersvl">
    <input type="hidden" name="reqType" value="mod"/>
    <input type="hidden" name="currentPage" value="${param.currentPage}"/>
    <input type="hidden" name="account_id" value="${param.account_id}"/>
    <table width="96%" height="97" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3"
           class="text_lb">
        <tr>
            <td width="67" height="23" align="right" bgcolor="#FFFFFF">账号</td>
            <td width="296" bgcolor="#FFFFFF">
                <input name="accountcode" type="text" id="textarea" value="${param.accountcode}" size="30" class="pi">
            </td>
            <td width="84" align="right" bgcolor="#FFFFFF">姓名</td>
            <td width="317" bgcolor="#FFFFFF">
                <input name="username" type="text" id="textarea4" value="${param.username}" size="30" class="pi">
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FFFFFF">邮箱</td>
            <td bgcolor="#FFFFFF">
                <input name="email" type="text" id="textarea1" value="${param.email}" size="30" class="pi">
            </td>
            <td align="right" bgcolor="#FFFFFF">所属公司级别</td>
            <td bgcolor="#FFFFFF">
                <span class="text">
                    <select name="select" id="select" class="input">
                      <option>请选择</option>
                      <option value="1">总公司</option>
                      <option value="2">分公司</option>
                    </select>
                </span></td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">密码</td>
            <td bgcolor="#FFFFFF">
                <input name="password" type="password" id="textarea3" value="" size="30" class="pi">
            </td>
            <td align="right" bgcolor="#FFFFFF">确认密码</td>
            <td bgcolor="#FFFFFF">
                <input name="confirm_password" type="password" id="textarea5" value="" size="30" class="pi">
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">是否可用</td>
            <td bgcolor="#FFFFFF">
                <input type="radio" name="radio" id="radio3" value="1">是
                <input type="radio" name="radio" id="radio4" value="0">否
            </td>
            <td height="23" align="right" bgcolor="#FFFFFF">账号所属公司</td>
            <td bgcolor="#FFFFFF">
                <input name="belong" type="text" id="textarea6" value="" size="30" class="pi">
            </td>
        </tr>
    </table>
    <table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td width="67%" align="center" class="text" nowrap>
                <input type="submit" name="searchbtn3" value="保存" class="button_new">
                <input type="submit" name="searchbtn3" value="返回" class="button_new"
                       onClick="javascript:location.href='yhgl.jsp'">
                <%--<input type="hidden" name="mod" value="no">--%>
                ${info}
                &nbsp;&nbsp;
            </td>
        </tr>
    </table>
</form>
</body>
</html>
