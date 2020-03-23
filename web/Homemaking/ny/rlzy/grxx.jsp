<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../css/index.css" rel="stylesheet" type="text/css">
<link href="../css/button.css" rel="stylesheet" type="text/css">
<html>
<head>
    <title>Untitled Document</title>
    <script type="text/javascript" src="../js/public.js"></script>
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
        <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;人力资源--&gt;工人管理</td>
        <td align="right">&nbsp;</td>
    </tr>
</table>
<br/>

<form method="post" action="${pageContext.request.contextPath}/Homemaking/workersvl?currentPage=1">
    <input type="hidden" name="reqType" value="find"/>
    <table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" class="MENU_line">
        <tr>
            <td width="67%" align="right" class="text" nowrap>&nbsp;
                姓名：
                <input type="text" name="username" maxlength="20" size="12" value="" class="input">
                &nbsp;&nbsp;
                性别：
                <input type="radio" name="sex" id="radio" value="男">男
                <input type="radio" name="sex" id="radio2" value="女">女
                年龄：
                <input type="text" name="age" maxlength="20" size="12" value="" class="input">
                状态：
                <select name="status" id="select" class="input">
                    <option selected>请选择</option>
                    <option value="在岗">在岗</option>
                    <option value="待岗">待岗</option>
                    <option value="其他">其他</option>
                </select>
                适合职位：
                <select name="job" id="select2" class="input">
                    <option selected>请选择</option>
                    <option value="保姆">保姆</option>
                    <option value="月嫂">月嫂</option>
                    <option value="家教">家教</option>
                    <option value="钟点工">钟点工</option>
                </select>
                <input type="submit" name="searchbtn" value="查  询" class="button_new">
                <input type="button" name="searchbtn2" value="新  增" class="button_new"
                       onClick="javascript:location.href='grxx_xz.jsp'">
                <input type="hidden" name="mod" value="no">
                &nbsp;&nbsp;
            </td>
        </tr>
    </table>
    <br>
    <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3">
        <tr align="center" class="tdtitle">
            <td nowrap align="center" width="3%">序号</td>
            <td width="12%" align="center" nowrap id=".name"><strong>姓名</strong></td>
            <td width="11%" height="24" align="center" nowrap id=".sex">
                <div align="center" orderBy="true"><strong>性别</strong></div>
            </td>
            <td width="12%" height="24" align="center" nowrap id=".age">
                <div align="center" orderBy="true"><strong>年龄</strong></div>
            </td>
            <td width="16%" align="center" nowrap id=".kill">
                <div align="center" orderBy="true"><strong>个人技能</strong></div>
            </td>
            <td width="13%" align="center" nowrap id=".need">
                <div align="center" orderBy="true"><strong>个人要求</strong></div>
            </td>
            <td width="9%" align="center" nowrap id=".status"><strong>状态</strong></td>
            <td width="15%" align="center" nowrap id=".submit_date"><strong>录入日期</strong></td>
            <td width="9%" align="center" nowrap id=".handle"><strong>操作</strong></td>
        </tr>
        <c:forEach items="${workerlist}" var="worker" varStatus="status">
            <tr align="center" class="td2">
                    <%-- onmouseover="javascript:changeBgColorOnMouseOver(this);"
                     onMouseOut="javascript:changeBgColorOnMouseOut(this);" onDblClick="doDBClick('bl.htm',true,'2');"--%>
                <td nowrap align="center" width="3%">${status.count}</td>
                <td align="center" nowrap>${worker.worker_name}</td>
                <td height="14" align="center" nowrap>${worker.gender}</td>
                <td align="center" nowrap>${worker.age}</td>
                <td align="center" nowrap>${worker.work_type}</td>
                <td align="center" nowrap>${worker.req_pay}</td>
                <td align="center" nowrap>${worker.status}</td>
                <td align="center" nowrap>${worker.entry_time}&nbsp;</td>
                <td align="center" nowrap>
                    <a href="workersvl?reqType=seen&index=${status.index+1}&worker_name=${worker.worker_name}&gender=${worker.gender}&age=${worker.age}&work_type=${worker.work_type}&req_pay=${worker.req_pay}&status=${worker.status}&entry_time=${worker.entry_time}">查看</a>
                    <a href="ny/rlzy/grxx_xg.jsp?index=${status.index+1}&worker_name=${worker.worker_name}&gender=${worker.gender}&age=${worker.age}&work_type=${worker.work_type}&req_pay=${worker.req_pay}&status=${worker.status}">修改</a>
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
                        <td nowrap align="center"> 当前第${currentPage}页 ,共${totalRecording}条记录 ,分${totalPages}页显示</td>
                        <td nowrap width="55%" align="right">
                            <input type="hidden" name="currentPage" value="1">
                            <input type="hidden" name="paginationAction" value="">
                            <a href="workersvl?currentPage=1&reqType=find" >第一页</a>&nbsp;&nbsp;&nbsp;
                            <a href="workersvl?currentPage=${currentPage-1}&reqType=find">上一页</a>&nbsp;&nbsp;&nbsp;
                            <a href="workersvl?currentPage=${currentPage+1}&reqType=find" >下一页</a>&nbsp;&nbsp;&nbsp;
                            <a href="workersvl?currentPage=${totalPages}&reqType=find" >尾页</a>&nbsp;&nbsp;&nbsp;
                            <a href="#" onclick="gotoPage()">前往</a>
                            <input type=text size='4' onlytype='int'  name='pageSelect' id="pageSelect"/>页
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form>
</body>
<script>
    function gotoPage(){
        var pageSelect=document.getElementById("pageSelect").value;
        window.location.href="${pageContext.request.contextPath}/Homemaking/workersvl?currentPage="+pageSelect+"&reqType=higherfind";
    }
</script>
</html>
