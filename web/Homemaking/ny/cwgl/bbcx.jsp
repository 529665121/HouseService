<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../css/index.css" rel="stylesheet" type="text/css">
<link href="../css/button.css" rel="stylesheet" type="text/css">
<%@page contentType="text/html;charset=GBK" %>
<html><head>
<title>Untitled Document</title>
<script type="text/javascript" src="../js/public.js"></script>
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
    <td>&nbsp;&nbsp;��&nbsp;����λ�ã��ҵ�����--&gt;�������--&gt;������ѯ</td>
    <td align="right">&nbsp;</td>
  </tr>
</table>
<br/>

  <table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" class="MENU_line">
    <tr>
      <td width="67%" align="right" class="text" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���ڣ�
        <input type="text" name="searchName2" maxlength="20" size="12" value="2010-01-01" class="input">
        ��
        <input type="text" name="searchName4" maxlength="20" size="12" value="2010-07-01" class="input">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button" name="searchbtn" value="��  ѯ" class="button_new">
      &nbsp;&nbsp; <input type="button" name="searchbtn" value="��  ӡ" class="button_new"></td>
    </tr>
  </table>
  <br>
  <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3">
    <tr align="center" class="tdtitle">
      <td nowrap align="center" width="5%">���</td>
      <td width="13%" align="center" nowrap id="companyname" >��˾����</td>
      <td width="14%" align="center" nowrap id="consumetype" >��������</td>
      <td width="10%" height="24" align="center" nowrap id="consumecount" ><div align="center" orderBy="true"><strong>���ѽ��</strong></div></td>
      <td width="11%" height="24" align="center" nowrap id=".phone" ><div align="center" orderBy="true"><strong>����ʱ��</strong></div></td>
      <td width="12%" align="center" nowrap id="consumetime" ><div align="center" orderBy="true"></div></td>
      <td width="21%" align="center" nowrap id=".register" >&nbsp;</td>
    </tr>

<c:forEach var="orderform" items="${requestScope.orderformList}">
    <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" onDblClick="doDBClick('bl.htm',true,'2');">
      <td nowrap align="center" width="5%">${orderform.order_number} </td>
      <td align="center" nowrap>${orderform.company_name}</td>
      <td align="center" nowrap>${orderform.consume_type}</td>
      <td height="14" align="center" nowrap>${orderform.consume_count}</td>
      <td align="center" nowrap>${orderform.consume_time}</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
    </tr>
</c:forEach>
   <%-- <tr align="center" class="td1"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" >
      <td nowrap align="center" width="5%">2 </td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td height="14" align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
    </tr>
    <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" >
      <td nowrap align="center" width="5%">3 </td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td height="14" align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
    </tr>
    <tr align="center" class="td1"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" >
      <td nowrap align="center" width="5%">4 </td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td height="14" align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
    </tr>
    <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" >
      <td nowrap align="center">5 </td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td height="14" align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
    </tr>--%>
    <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" >
      <td colspan="3" align="right" nowrap><strong>�ϼ��ܶ</strong></td>
      <td height="14" colspan="4" align="left" nowrap>500 <strong>Ԫ</strong></td>
    </tr>
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