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
    <td>&nbsp;&nbsp;��&nbsp;����λ�ã��ҵ�����--&gt;�������--&gt;�շѹ���</td>
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
      &nbsp;&nbsp; </td>
    </tr>
  </table>
  <br>
  <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3">
    <tr align="center" class="tdtitle">
      <th nowrap align="center" width="5%">���</th>
   
      <th width="14%" align="center" nowrap id="employername" >�ͻ�����</th>
      <th width="10%" height="24" align="center" nowrap id="pay" ><div align="center" orderBy="true"><strong>���ܷ�</strong></div></th>
      <th width="11%" height="24" align="center" nowrap id="tradedate" ><div align="center" orderBy="true"><strong>�ɽ�����</strong></div></th>
      <th width="12%" align="center" nowrap id="workername" ><div align="center" orderBy="true"><strong>����</strong></div></th>
      <th width="21%" align="center" nowrap id="company" ><strong>������˾</strong></th>
      <th width="14%" align="center" nowrap id="queryorder" ><strong>����</strong></th>
    </tr>



    <c:forEach var="order" items="${requestScope.orderList}">
    <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" onDblClick="doDBClick('bl.htm',true,'2');">
      <td nowrap align="center" width="5%">${order.order_number} </td>
      <td align="center" nowrap>${order.employer_name}</td>
      <td height="14" align="center" nowrap>${order.interveningact}</td>
      <td align="center" nowrap>${order.completiondate}</td>
      <td align="center" nowrap>${order.worker_name}</td>
      <td align="center" nowrap>${order.company_name}</td>
      <td align="center" nowrap><a href="../../../controller/orderservlet?reqType=queryorders">�鿴����</a></td>
      <%--../ywgl/ddgl_xg.htm--%>
    </tr>
    </c:forEach>
  <!--  <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" onDblClick="doDBClick('bl.htm',true,'2');">
      <td nowrap align="center" width="5%">1 </td>
  
      <td align="center" nowrap>����</td>
      <td height="14" align="center" nowrap>500</td>
      <td align="center" nowrap>2010-07-01</td>
      <td align="center" nowrap>����</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap><a href="yggl_xg.htm">�鿴����</a></td>
    </tr>-->
   <!-- <tr align="center" class="td1"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" >
      <td nowrap align="center" width="5%">2 </td>
   
      <td align="center" nowrap>&nbsp;</td>
      <td height="14" align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap><a href="#">�鿴����</a><a href="yggl_xg.htm"></a><a href="grxx_xg.htm"></a></td>
    </tr>
    <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" >
      <td nowrap align="center" width="5%">3 </td>
   
      <td align="center" nowrap>&nbsp;</td>
      <td height="14" align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap><a href="#">�鿴����</a><a href="yggl_xg.htm"></a><a href="grxx_xg.htm"></a></td>
    </tr>
    <tr align="center" class="td1"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" >
      <td nowrap align="center" width="5%">4 </td>
  
      <td align="center" nowrap>&nbsp;</td>
      <td height="14" align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap><a href="#">�鿴����</a><a href="yggl_xg.htm"></a><a href="grxx_xg.htm"></a></td>
    </tr>
    <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" >
      <td nowrap align="center">5 </td>
  
      <td align="center" nowrap>&nbsp;</td>
      <td height="14" align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap><a href="#">�鿴����</a><a href="grxx_xg.htm"></a></td>
    </tr>-->

    <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" >
      <td colspan="3" align="right" nowrap><strong>�ϼ��ܶ</strong></td>
      <td height="14" colspan="5" align="left" nowrap>500 <strong>Ԫ</strong></td>
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
