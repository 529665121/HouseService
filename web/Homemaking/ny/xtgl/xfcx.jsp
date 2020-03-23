<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="../css/index.css" rel="stylesheet" type="text/css">
<link href="../css/button.css" rel="stylesheet" type="text/css"><head>
<title>Untitled Document</title>
<script type="text/javascript" src="../js/public.js"></script>
<script language="JavaScript">
function doDBClick(url,operator,type) {
  if (operator == false) {
    document.forms[1].action = url + "&op=view";
    document.forms[1].submit();
  } else {
    document.forms[1].action = url;
    document.forms[1].submit();
  }
}
</script>
</head>

<body>

<table width="100%"  border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" class="where">
  <tr>
    <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;系统管理--&gt;消费查询</td>
    <td align="right">&nbsp;</td>
  </tr>
</table>
<br/>

<form action="${pageContext.request.contextPath}/Homemaking/rechargeServlet?reqType=other_" method="post">
  <table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" class="MENU_line">
    <tr>
      <td width="67%" align="right" class="text" nowrap>&nbsp;公司名称：
        <input type="text" name="searchName" maxlength="20" size="12" value="" class="input">
        &nbsp;&nbsp;&nbsp;&nbsp;公司帐号：
        <input type="text" name="searchName3" maxlength="20" size="12" value="" class="input">
 &nbsp;&nbsp;&nbsp;&nbsp;日期：
        <input type="text" name="searchName2" maxlength="20" size="12" value="" class="input">
        到
        <input type="text" name="searchName4" maxlength="20" size="12" value="" class="input"> &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" name="searchbtn" value="查  询" class="button_new">
      &nbsp;&nbsp; </td>
    </tr>
  </table>
</form>
  <br>
  <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3">
    <tr align="center" class="tdtitle">
      <td nowrap align="center" width="4%">序号</td>
      <td width="27%" align="center" nowrap id=".name" >公司名称</td>
      <td width="9%" align="center" nowrap id=".name" >帐户名</td>
      <td width="9%" height="24" align="center" nowrap id=".phone" ><div align="center" orderBy="true"><strong>刷卡时间</strong></div></td>
      <td width="7%" align="center" nowrap id=".register" ><div align="center" orderBy="true"><strong>本次扣费(元)</strong></div></td>
    </tr>
      <c:forEach items="${sessionScope.record}" var="r" varStatus="e">
    <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" onDblClick="doDBClick('bl.htm',true,'2');">
      <td width="4%" height="14" align="center" nowrap>${e.count}</td>
      <td align="center" nowrap>${r.company_name}</td>
      <td align="center" nowrap>${r.user_name}</td>
      <td align="center" nowrap>${r.record_time}</td>
      <td align="center" nowrap>${r.charge}</td>
    </tr>
      </c:forEach>
    <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" >
      <td height="14" colspan="4" align="right" nowrap><strong>合计金额：</strong></td>
      <td align="center" nowrap>2</td>
    </tr>
  </table>
<form action="${pageContext.request.contextPath}/Homemaking/rechargeServlet?reqType=xfcx" method="post">
    <table width="96%" height="10"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td><input type="hidden" name="orderType" value="asc">
                <input type="hidden" name="orderFid" value=".submit_date">
                <table width="90%" style="font-size:12px;" border="0" cellspacing="3" cellpadding="2">
                    <tr>
                        <td nowrap width="45%" align="center"> 当前第${sessionScope.page+1}页 共${sessionScope.count}记录 分${Integer.valueOf(Math.ceil(sessionScope.count/5))}页显示 </td>
                        <td nowrap width="55%" align="right">
                            <input type="hidden" name="currentPage" value="1">
                            <input type="hidden" name="paginationAction" value="${sessionScope.page}">
                            <input type="hidden" name="paginationAction2" value="${Integer.valueOf(Math.ceil(sessionScope.count/5))}">
                            <img src="../image/First_no.gif" alt="第一页" width="18" height="13" border="0" onclick="doDBClick('${pageContext.request.contextPath}/Homemaking/rechargeServlet?reqType=${sessionScope.reqType}&page=first',true,null)"/>&nbsp&nbsp&nbsp
                            <img src="../image/Previous_no.gif" alt="上一页" width="14" height="13" border="0" onclick="doDBClick('${pageContext.request.contextPath}/Homemaking/rechargeServlet?reqType=${sessionScope.reqType}&page=old',true,null) "/>&nbsp&nbsp&nbsp
                            <img src="../image/Next_no.gif" alt="下一页" width="14" height="13" border="0" onclick="doDBClick('${pageContext.request.contextPath}/Homemaking/rechargeServlet?reqType=${sessionScope.reqType}&page=new',true,null)"/>&nbsp&nbsp&nbsp
                            <img src="../image/Last_no.gif" alt="最后一页" width="18" height="13" border="0" onclick="doDBClick('${pageContext.request.contextPath}/Homemaking/rechargeServlet?reqType=${sessionScope.reqType}&page=last',true,null) "/>&nbsp&nbsp&nbsp
                            <a  onClick="doDBClick('${pageContext.request.contextPath}/Homemaking/rechargeServlet?reqType=${sessionScope.reqType}&page=jump',true,null)">前往</a>
                            <input type=text size='4' onlytype='int'  name='pageSelect' value=''/>
                            页 </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
