<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="../css/index.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.STYLE1 {	font-size: 24px;
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
function doDBClick(url,operator,type) {
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
<form action="${pageContext.request.contextPath}/Homemaking/employmentServlet?reqType=selectWorker" method="post">
<table width="100%"  border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" class="where">
  <tr>
    <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;业务管理--&gt;信息检索</td>
    <td align="right">&nbsp;</td>
  </tr>
</table>
<br/>


  <table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" >
    <tr>
      <td width="67%" height="40" align="center" nowrap class="MENU_line1">工人资料检索</td>
    </tr>
  </table>
  <br>
  <table width="96%" height="270" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
   
    <tr>
      <td height="23" align="right" bgcolor="#FFFFFF">姓名：</td>
      <td bgcolor="#FFFFFF"><input name="textarea2" type="text" id="textarea2" value="" size="30" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">性别：</td>
      <td bgcolor="#FFFFFF"><input type="radio" name="radio" id="radio" value="男">
        男
        <input type="radio" name="radio" id="radio2" value="女">
          女</td>
    </tr>
   
    <tr >
      <td  align="right" bgcolor="#FFFFFF">年龄：</td>
      <td   bgcolor="#FFFFFF">
	  <select name="age1">
        <option></option>
	  <option>16</option>
	  <option>17</option>
	  <option>18</option>
	  </select>&nbsp;&nbsp;&nbsp;到&nbsp;&nbsp;&nbsp;&nbsp;
	  <select name="age2">
        <option></option>
	  <option>16</option>
	  <option>17</option>
	  <option>18</option>
	  </select>
	  </td>
     
      <td   align="right" bgcolor="#FFFFFF">从业时间：</td>
      <td   bgcolor="#FFFFFF"><input name="textarea7" type="text" id="textarea7" value="" size="30" class="pi"></td>
    </tr>
    
    <tr>
     
      <td align="right" bgcolor="#FFFFFF">教育程度：</td>
      <td bgcolor="#FFFFFF">
        <input type="radio" name="radio1" id="radio3" value="大专" />
        大专&nbsp;
        <input type="radio" name="radio1" id="radio3" value="高中" />
        高中&nbsp;
        <input type="radio" name="radio1" id="radio3" value="初中" />
        初中&nbsp;
        <input type="radio" name="radio1" id="radio3" value="小学" />
      小学&nbsp; </td>

	   <td height="23" align="right" bgcolor="#FFFFFF">爱好：</td>
      <td colspan="4" bgcolor="#FFFFFF">
        <input type="checkbox" name="checkbox" id="checkbox"  value="唱歌"/>
        唱歌&nbsp;
        <input type="checkbox" name="checkbox" id="checkbox" value="舞蹈" />
        舞蹈&nbsp;
        <input type="checkbox" name="checkbox" id="checkbox"  value="乐器"/>
        乐器&nbsp;
        <input type="checkbox" name="checkbox" id="checkbox" value="体育" />
        体育&nbsp;
        <input type="checkbox" name="checkbox" id="checkbox"  value="书法"/>
      书法&nbsp; </td>
    </tr>
   
   
   
    <tr>
      <td height="23" align="right" bgcolor="#FFFFFF">语言：</td>
      <td colspan="4" bgcolor="#FFFFFF">
        <input type="checkbox" name="checkbox2" id="checkbox2"  value="普通话"/>
        普通话&nbsp;
        <input type="checkbox" name="checkbox2" id="checkbox2" value="广州话" />
        广州话&nbsp;
        <input type="checkbox" name="checkbox3" id="checkbox3" value="英语" />
        英语
      其它语言：&nbsp;
      <input name="textarea16" type="text" id="textarea16" value="" size="30" class="pi"></td>
    </tr>
    <tr>
      <td height="23" align="right" bgcolor="#FFFFFF">状态：</td>
      <td colspan="4" bgcolor="#FFFFFF">
        <input type="radio" name="radio3" id="radio4" value="在岗" />
        在岗&nbsp;&nbsp;
        <input type="radio" name="radio3" id="radio5" value="待岗" />
        待岗&nbsp;&nbsp;
        <input type="radio"  id="radio6" value="radio" />
      其它：&nbsp;
      <input name="textarea17" type="text" id="textarea17" value="" size="30" class="pi"></td>
    </tr>
    <tr>
      <td height="23" align="right" bgcolor="#FFFFFF">婚姻状况：</td>
      <td colspan="4" bgcolor="#FFFFFF">
        <input type="radio" name="radio4" id="radio7" value="已婚" />
        已婚
        &nbsp;
        <input type="radio" name="radio4" id="radio8" value="未婚" />
        未婚&nbsp;&nbsp;
        <input type="radio" name="radio4" id="radio9" value="离异" />
        离异
        &nbsp;
        <input type="radio" name="radio4" id="radio10" value="丧偶" />
        丧偶
        &nbsp;&nbsp;
        <input type="radio"  id="radio11" value="radio" />
      其它：&nbsp;
      <input name="textarea18" type="text" id="textarea18" value="" size="30" class="pi"></td>
    </tr>
    <tr>
      <td height="23" align="right" bgcolor="#FFFFFF">证照状况：</td>
      <td colspan="4" bgcolor="#FFFFFF">
        <input type="checkbox" name="checkbox4" id="checkbox4" value="计生证" />
        计生证&nbsp;
        <input type="checkbox" name="checkbox4" id="checkbox4" value="健康证" />
        健康证&nbsp;&nbsp;
        <input type="checkbox" name="checkbox4" id="checkbox4" value="暂住证" />
        暂住证&nbsp;&nbsp;
        <input type="checkbox" name="checkbox4" id="checkbox4" value="上岗证" />
      上岗证 </td>
    </tr>
   
    
    <tr>
      <td height="23" align="right" bgcolor="#FFFFFF">个人技能：</td>
      <td colspan="4" bgcolor="#FFFFFF"><table width="100%" border="0" cellpadding="1" cellspacing="0" bgcolor="#bdc7d3" class="text_lb">
        <tr>
            <td height="28" bgcolor="#FFFFFF">
              <input type="checkbox" name="checkbox6" id="checkbox7"  value="照顾婴儿" />
              照顾婴儿        &nbsp;&nbsp;&nbsp;
              <input type="checkbox" name="checkbox6" id="checkbox7" value="带小孩" />
              带小孩          &nbsp;&nbsp;&nbsp;
              <input type="checkbox" name="checkbox6" id="checkbox8" value="照顾老人" />
              照顾老人          &nbsp;&nbsp;&nbsp;
              <input type="checkbox" name="checkbox6" id="checkbox9" value="煮饭" />
              煮饭          &nbsp;&nbsp;&nbsp;
              <input type="checkbox" name="checkbox6" id="checkbox10" value="粤菜" />
              粤菜          &nbsp;&nbsp;&nbsp;
              <input type="checkbox" name="checkbox6" id="checkbox11" value="客家菜" />
              客家菜          &nbsp;&nbsp;&nbsp;
              <input type="checkbox" name="checkbox6" id="checkbox12" value="煲烫" />
              煲烫</td>
        </tr>
          <tr>
            <td height="28" bgcolor="#FFFFFF">
              <input type="checkbox" name="checkbox6" id="checkbox7"  value="扫地"/>
              扫地        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="checkbox" name="checkbox6" id="checkbox7"  value="拖地"/>
              拖地          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="checkbox" name="checkbox6" id="checkbox8" value="擦窗" />
              擦窗
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="checkbox" name="checkbox6" id="checkbox9"  value="洗衣"/>
              洗衣          &nbsp;&nbsp;&nbsp;
              <input type="checkbox" name="checkbox6" id="checkbox10" value="打蜡" />
              打蜡          &nbsp;&nbsp;&nbsp;
              <input type="checkbox" name="checkbox6" id="checkbox11" value="通渠" />
              通渠&nbsp;&nbsp;&nbsp;
              &nbsp;&nbsp;&nbsp;&nbsp;其它：
              <input name="textarea26" type="text" id="textarea26" value="" size="30" class="pi"></td>
        </tr>
      </table></td>
    </tr>
 
    
   
   
  </table>

<table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="67%" align="center" class="text" nowrap>
      <input type="submit" name="searchbtn3" value="检   索" class="button_new" >
      <input type="submit" name="searchbtn3" value="返  回" class="button_new"onClick="javascript:location.href='grxx.htm'" >
      <input type="hidden" name="mod" value="no">
    &nbsp;&nbsp; </td>
  </tr>
</table>
</form>
</body>
</html>
