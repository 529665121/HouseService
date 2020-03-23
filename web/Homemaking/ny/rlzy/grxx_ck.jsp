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
        <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;人力资源--&gt;工人管理</td>
        <td align="right">&nbsp;</td>
    </tr>
</table>
<br/>


<table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td width="67%" height="40" align="center" nowrap class="MENU_line1">工人资料登记表</td>
    </tr>
</table>
<br>
<form method="post" action="${pageContext.request.contextPath}/Homemaking/workersvl">
    <input type="hidden" name="reqType" value="see">
    <c:forEach items="${workerList}" var="worker">
        <table width="96%" height="512" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3"
               class="text_lb">
            <tr>
                <td width="118" height="23" align="right" bgcolor="#FFFFFF">员工编号：</td>
                <td width="284" bgcolor="#FFFFFF">${worker.worker_number}</td>
                <td width="104" align="right" bgcolor="#FFFFFF">所属公司：</td>
                <td width="289" bgcolor="#FFFFFF">${worker.company_number}</td>
                <td width="138" rowspan="6" align="center" valign="middle" bgcolor="#FFFFFF">相片:${worker.photo}</td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">姓名：</td>
                <td bgcolor="#FFFFFF">${worker.worker_name}</td>
                <td align="right" bgcolor="#FFFFFF">性别：</td>
                <td bgcolor="#FFFFFF">${worker.gender}</td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">身份证号码：</td>
                <td bgcolor="#FFFFFF">${worker.idnumber}</td>
                <td height="23" align="right" bgcolor="#FFFFFF">出生年月：</td>
                <td bgcolor="#FFFFFF">${worker.birthday}</td>
            </tr>
            <tr>
                <td align="right" bgcolor="#FFFFFF">年龄：</td>
                <td bgcolor="#FFFFFF">${worker.age}</td>
                <td height="23" align="right" bgcolor="#FFFFFF">身高：</td>
                <td bgcolor="#FFFFFF">${worker.height}</td>
            </tr>
            <tr>
                <td align="right" bgcolor="#FFFFFF">手机：</td>
                <td bgcolor="#FFFFFF">${worker.mobile_phone}</td>
                <td align="right" bgcolor="#FFFFFF">电话：</td>
                <td bgcolor="#FFFFFF">${worker.telephone}</td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">工种：</td>
                <td bgcolor="#FFFFFF">${worker.work_type}</td>
                <td align="right" bgcolor="#FFFFFF">从业时间：</td>
                <td bgcolor="#FFFFFF">${worker.work_time}</td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">缺陷：</td>
                <td bgcolor="#FFFFFF">${worker.disadvantage}</td>
                <td align="right" bgcolor="#FFFFFF">教育程度：</td>
                <td bgcolor="#FFFFFF">大专&nbsp;</td>
                <td bgcolor="#FFFFFF">&nbsp;</td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">户籍地址：</td>
                <td colspan="4" bgcolor="#FFFFFF">${worker.address}</td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">现住地址：</td>
                <td colspan="4" bgcolor="#FFFFFF">${worker.current_address}</td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">银行卡号：</td>
                <td bgcolor="#FFFFFF">${worker.bankcard}</td>
                <td align="right" bgcolor="#FFFFFF">保险单号：</td>
                <td colspan="2" bgcolor="#FFFFFF">${worker.insurance}</td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">爱好：</td>
                <td colspan="4" bgcolor="#FFFFFF">&nbsp;</td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">语言：</td>
                <td colspan="4" bgcolor="#FFFFFF">${worker.language}</td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">状态：</td>
                <td colspan="4" bgcolor="#FFFFFF">
                        ${worker.status}
                </td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">婚姻状况：</td>
                <td colspan="4" bgcolor="#FFFFFF"> ${worker.marital}</td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">证照状况：</td>
                <td colspan="4" bgcolor="#FFFFFF"> ${worker.license}</td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">体检情况：</td>
                <td colspan="4" bgcolor="#FFFFFF">
                    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
                        <tr>
                            <td width="68%" height="28" bgcolor="#FFFFFF">${worker.check_up}</td>
                            <td width="11%" align="right" bgcolor="#FFFFFF">体检时间：</td>
                            <td width="21%" bgcolor="#FFFFFF">${worker.check_up_time}</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td height="23" align="right" nowrap bgcolor="#FFFFFF">家庭成员：
                    <input type="button" name="button3" id="button3" value="+"/></td>
                <td colspan="4" bgcolor="#FFFFFF">
                    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
                        <tr>
                            <td height="28" bgcolor="#FFFFFF">
                                <div align="center">关系</div>
                            </td>
                            <td height="28" bgcolor="#FFFFFF">
                                <div align="center">姓名</div>
                            </td>
                            <td height="28" bgcolor="#FFFFFF">
                                <div align="center">年龄</div>
                            </td>
                            <td height="28" bgcolor="#FFFFFF">
                                <div align="center">电话</div>
                            </td>
                            <td height="28" bgcolor="#FFFFFF">
                                <div align="center">工作单位(学校)</div>
                            </td>
                        </tr>
                        <tr>
                            <td height="28" align="center" bgcolor="#FFFFFF">父亲</td>
                            <td height="28" align="center" bgcolor="#FFFFFF">李四</td>
                            <td height="28" align="center" bgcolor="#FFFFFF">50</td>
                            <td height="28" align="center" bgcolor="#FFFFFF">1323245</td>
                            <td height="28" align="center" bgcolor="#FFFFFF">&nbsp;</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">个人技能：</td>
                <td colspan="4" bgcolor="#FFFFFF">
                    <table width="100%" border="0" cellpadding="1" cellspacing="0" bgcolor="#bdc7d3" class="text_lb">
                        <tr>
                            <td height="28" bgcolor="#FFFFFF">${worker.skill}</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">主要工作经历：
                    <input type="button" name="button4" id="button4" value="+"/></td>
                <td colspan="4" bgcolor="#FFFFFF">
                    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
                        <tr>
                            <td width="45%" height="28" bgcolor="#FFFFFF">
                                <div align="center">单位</div>
                            </td>
                            <td width="17%" height="28" bgcolor="#FFFFFF">
                                <div align="center">工种</div>
                            </td>
                            <td width="17%" height="28" bgcolor="#FFFFFF">
                                <div align="center">职务</div>
                            </td>
                            <td width="21%" height="28" bgcolor="#FFFFFF">
                                <div align="center">工作时间</div>
                            </td>
                        </tr>
                        <tr>
                            <td height="28" align="center" bgcolor="#FFFFFF">&nbsp;</td>
                            <td height="28" align="center" bgcolor="#FFFFFF">&nbsp;</td>
                            <td height="28" align="center" bgcolor="#FFFFFF">&nbsp;</td>
                            <td height="28" align="center" bgcolor="#FFFFFF">&nbsp;</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">岗位培训记录：
                    <input type="button" name="button5" id="button5" value="+"/></td>
                <td colspan="4" bgcolor="#FFFFFF">
                    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
                        <tr>
                            <td width="42%" height="28" bgcolor="#FFFFFF">
                                <div align="center">培训机构</div>
                            </td>
                            <td width="25%" height="28" bgcolor="#FFFFFF">
                                <div align="center">培训内容</div>
                            </td>
                            <td width="15%" height="28" bgcolor="#FFFFFF">
                                <div align="center">培训情况</div>
                            </td>
                            <td width="18%" height="28" bgcolor="#FFFFFF">
                                <div align="center">培训时间</div>
                            </td>
                        </tr>
                        <tr>
                            <td height="28" align="center" bgcolor="#FFFFFF">&nbsp;</td>
                            <td height="28" align="center" bgcolor="#FFFFFF">&nbsp;</td>
                            <td height="28" align="center" bgcolor="#FFFFFF">&nbsp;</td>
                            <td height="28" align="center" bgcolor="#FFFFFF">&nbsp;</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">自我介绍：</td>
                <td colspan="4" bgcolor="#FFFFFF">${worker.introduction}</td>
            </tr>
            <tr>
                <td height="23" align="right" bgcolor="#FFFFFF">人人要求：</td>
                <td colspan="4" bgcolor="#FFFFFF">
                    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
                        <tr>
                            <td width="10%" height="28" align="right" bgcolor="#FFFFFF">时间要求：</td>
                            <td width="37%" height="28" bgcolor="#FFFFFF">${worker.req_time}</td>
                            <td width="10%" height="28" align="right" bgcolor="#FFFFFF">住宿：</td>
                            <td width="43%" height="28" bgcolor="#FFFFFF">${worker.stay_room}</td>
                        </tr>
                        <tr>
                            <td height="28" align="right" bgcolor="#FFFFFF">工资要求：</td>
                            <td height="28" bgcolor="#FFFFFF">${worker.req_pay}</td>
                            <td height="28" align="right" bgcolor="#FFFFFF">餐饮或其它：</td>
                            <td height="28" bgcolor="#FFFFFF">${worker.food}</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </c:forEach>
    <table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td width="67%" align="center" class="text" nowrap>
                <input type="button" name="searchbtn3" value="返  回" class="button_new"
                       onClick="javascript:window.location.href='grxx.jsp'">
                <input type="hidden" name="mod" value="no">
                &nbsp;&nbsp;
            </td>
        </tr>
    </table>
</form>
</body>
</html>
