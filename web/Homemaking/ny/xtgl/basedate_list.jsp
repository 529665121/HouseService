<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../css/index.css" rel="stylesheet" type="text/css">
<link href="../css/button.css" rel="stylesheet" type="text/css">
<%@page contentType="text/html;charset=GBK" %>
<html>
<head>
<title>Untitled Document</title>

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

<table width="100%"  border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" class="where">
  <tr>
    <td>&nbsp;&nbsp;��&nbsp;����λ�ã��ҵ�����--&gt;ϵͳ����--&gt;��˾����</td>
    <td align="right">&nbsp;</td>
  </tr>
</table>
<br/>
<table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" class="MENU_line">
  <tr>
    <td width="67%" align="right" class="text" nowrap>     &nbsp;&nbsp;&nbsp;���ͣ�
      <select name="">
        	<option value="1">�����̶�</option>
            <option value="2">����</option>
            <option value="3">����</option>
            <option value="4">֤��״��</option>
            <option value="5">������</option>
            <option value="6">���˼���</option>
            <option value="7">��������</option>
      </select>
      <input type="button" name="searchbtn" value="��  ѯ" class="button_new">
      <input type="button" name="searchbtn2" value="��  ��" class="button_new"onClick="javascript:location.href='basedate_add.htm'" >
      <input type="button" name="searchbtn2" value="ɾ  ��" class="button_new"onClick="javascript:location.href=''" >
	  <input type="hidden" name="mod" value="no">
      &nbsp;&nbsp; </td>
  </tr>
</table>
<br>
  <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3">
    <tr align="center" class="tdtitle">
      <td nowrap align="center" width="4%"><input type="checkbox" name="checkbox" id="checkbox"></td>
      <td nowrap align="center" width="6%">���</td>
      <td width="31%" align="center" nowrap id="typename" >����</td>
      <td width="38%" height="24" align="center" nowrap id="type" ><div align="center" orderBy="true">����</div></td>
      <td width="21%" align="center" nowrap id=".submit_date" ><strong>����</strong></td>
    </tr>

      <c:forEach var="datadictionary" items="${requestScope.datadictionaryList}">
          <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" onDblClick="doDBClick('bl.htm',true,'2');">
              <td nowrap align="center" width="4%"><input type="checkbox" name="checkbox2" id="checkbox2"></td>
              <td nowrap align="center" width="6%">${datadictionary.bastic_id} </td>
              <td align="center" nowrap>${datadictionary.bastic_name}</td>
              <td height="14" align="center" nowrap>${datadictionary.bastic_type}</td>
              <td align="center" nowrap><a href="#">�޸�</a>&nbsp;</td>
          </tr>
      </c:forEach>



  <!--  <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" onDblClick="doDBClick('bl.htm',true,'2');">
      <td nowrap align="center" width="4%"><input type="checkbox" name="checkbox2" id="checkbox2"></td>
      <td nowrap align="center" width="6%">1 </td>
      <td align="center" nowrap>����</td>
      <td height="14" align="center" nowrap>�����̶�</td>
      <td align="center" nowrap><a href="#">�޸�</a>&nbsp;</td>
    </tr>

    <tr align="center" class="td1"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" >
      <td nowrap align="center" width="4%"><input type="checkbox" name="checkbox3" id="checkbox3"></td>
      <td nowrap align="center" width="6%">2 </td>
      <td align="center" nowrap>��ɩ</td>
      <td height="14" align="center" nowrap>��������</td>
      <td align="center" nowrap><a href="#">�޸�</a>&nbsp;&nbsp;</td>
    </tr>-->



  </table>

<table width="96%" height="10"  border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td><input type="hidden" name="orderType" value="asc">
          <input type="hidden" name="orderFid" value=".submit_date">
          <table width="90%" style="font-size:12px;" border="0" cellspacing="3" cellpadding="2">
            <tr>
              <td nowrap width="45%" align="center"> ��ǰ��1ҳ ��5��¼ ��1ҳ��ʾ </td>
              <td nowrap width="55%" align="right"><input type="hidden" name="currentPage" value="1">
                  <input type="hidden" name="paginationAction" value="">
                  <img src="../image/First_no.gif" alt="��һҳ" width="18" height="13" border="0">&nbsp&nbsp&nbsp <img src="../image/Previous_no.gif" alt="��һҳ" width="14" height="13" border="0">&nbsp&nbsp&nbsp <img src="../image/Next_no.gif" alt="��һҳ" width="14" height="13" border="0">&nbsp&nbsp&nbsp <img src="../image/Last_no.gif" alt="���һҳ" width="18" height="13" border="0">&nbsp&nbsp&nbsp <a href="javascript:this.document.AwaitForm.submit()" oncontextmenu="return false" onClick="if(this.document.AwaitForm.pageSelect.value==''){ alert('ҳ���������');return false;}
 else {this.document.AwaitForm.paginationAction.value='gotoPage';}">ǰ��</a>
                  <input type=text size='4' onlytype='int' onfocus='checkTextBoxInput()' name='pageSelect' value=''/>
                ҳ </td>
            </tr>
          </table>

      </td>
    </tr>
  </table>

</body>
</html>