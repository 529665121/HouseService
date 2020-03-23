<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../css/index.css" rel="stylesheet" type="text/css">
<link href="../css/button.css" rel="stylesheet" type="text/css">
<html>
<head>
    <title>Untitled Document</title>

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
        <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;系统管理--&gt;公司管理</td>
        <td align="right">&nbsp;</td>
    </tr>
</table>
<br/>
<form method="post" action="${pageContext.request.contextPath}/Homemaking/companysvl?currentPage=1">
    <input type="hidden" name="reqType" value="find"/>
    <table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" class="MENU_line">
        <tr>
            <td width="67%" align="right" class="text" nowrap>
                &nbsp;帐号：
                <input type="text" name="searchName" maxlength="20" size="12" value="" class="input">
                &nbsp;&nbsp;名称：
                <input type="text" name="searchName2" maxlength="20" size="12" value="" class="input">
                <input type="submit" name="searchbtn" value="查  询" class="button_new">
                <input type="button" name="searchbtn2" value="新  增" class="button_new"
                       onClick="javascript:window.location.href='gsgl_xz.jsp'">
                <input type="button" name="searchbtn2" value="删  除" class="button_new">
                <input type="hidden" name="mod" value="no">
                &nbsp;&nbsp;
            </td>
        </tr>
    </table>
    <br>
    <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3">
        <tr align="center" class="tdtitle">
            <td nowrap align="center" width="4%">
                <input type="checkbox" name="checkbox" id="checkbox">
            </td>
            <td nowrap align="center" width="6%">序号</td>
            <td width="31%" align="center" nowrap id=".account">帐号</td>
            <td width="38%" height="24" align="center" nowrap id=".name">
                <div align="center" orderBy="true">名称</div>
            </td>
            <td width="21%" align="center" nowrap id=".submit_date">
                <strong>操作</strong>
            </td>
        </tr>
        <c:forEach items="${companyList}" var="company" varStatus="status">
            <tr align="center" class="td2" onmouseover="javascript:changeBgColorOnMouseOver(this);"
                onMouseOut="javascript:changeBgColorOnMouseOut(this);" onDblClick="doDBClick('bl.htm',true,'2');">
                <td nowrap align="center" width="4%">
                    <input type="checkbox" name="checkbox2" id="checkbox2"></td>
                <td nowrap align="center" width="6%">${status.index}</td>
                <td align="center" nowrap>${company.company_account}</td>
                <td height="14" align="center" nowrap>${company.company_name}</td>
                <td align="center" nowrap>
                    <a href="ny/xtgl/gsgl_xg.jsp?index=${status.index}&company_account=${company.company_account}&company_name=${company.company_name}">修改</a>&nbsp;&nbsp;
                    <a href="companysvl?reqType=remove&currentPage=${currentPage}&index=${status.index}&company_account=${company.company_account}&company_name=${company.company_name}">删除</a>&nbsp;&nbsp;
                    <a href="#">选择人员</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <table width="96%" height="10" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td><input type="hidden" name="orderType" value="asc">
                <input type="hidden" name="orderFid" value=".submit_date">
                <table width="90%" style="font-size:12px;" border="0" cellspacing="3" cellpadding="2">
                    <tr>
                        <td nowrap width="45%" align="center"> 当前第${currentPage}页 共${totalRecord}记录 分${totalPages}页显示
                        </td>
                        <td nowrap width="55%" align="right">
                            <input type="hidden" name="currentPage" value="1">
                            <input type="hidden" name="paginationAction" value="">
                            <a href="companysvl?currentPage=1&reqType=find">第一页</a>&nbsp;&nbsp;&nbsp;
                            <a href="companysvl?currentPage=${currentPage-1}&reqType=find">上一页</a>&nbsp;&nbsp;&nbsp;
                            <a href="companysvl?currentPage=${currentPage+1}&reqType=find">下一页</a>&nbsp;&nbsp;&nbsp;
                            <a href="companysvl?currentPage=${totalPages}&reqType=find">尾页</a>&nbsp;&nbsp;&nbsp;
                            <a href="#" onclick="gotoPage()">前往</a>
                            <input type=text size='4' onlytype='int' onfocus='checkTextBoxInput()' name='pageSelect' id="pageSelect" value=''/>
                            页
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form>
</body>
<script>
    function gotoPage() {
        var pageSelect = document.getElementById("pageSelect").value;
        window.location.href = "${pageContext.request.contextPath}/Homemaking/workersvl?currentPage=" + pageSelect + "&reqType=higherfind";
    }
</script>
</html>
